
package com.ssm.wechatshop.flink;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collector;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
/**
 * Galileo Streaming Job
 *
 * @author wanghao (Employee ID: 18070945)
 * @version 1.2.0, 2019-12-05 10:52
 * @since 1.2.0, 2019-12-05 10:52
 */
@Slf4j
public class StreamingJob {

    private static final Set<Collector.Characteristics> CH_UNORDERED_ID
            = Collections.unmodifiableSet(EnumSet.of(Collector.Characteristics.UNORDERED,
            Collector.Characteristics.IDENTITY_FINISH));

    private static final TypeReference<List<ResponseEntity>> HTTP_RESPONSE_REFERENCE = new TypeReference<List<ResponseEntity>>() {
    };

    private StreamingJob() {
        throw new IllegalAccessError("Utility class");
    }

    private static <T> Collector<T, ?, Set<T>> convertToTreeSet() {
        return new GalileoCollector<>((Supplier<Set<T>>) TreeSet::new, Set::add,
                (left, right) -> {
                    left.addAll(right);
                    return left;
                },
                CH_UNORDERED_ID);
    }

    private static GalileoConfig config = ConfigurationLoader.load();

    private static final AvroSchemaConverter converter = new AvroSchemaConverter();

    public static void main(String[] args) throws Exception {
        String response = getHttpResponse();

        List<ResponseEntity> responseEntities = INSTANCE.fromJson(response, HTTP_RESPONSE_REFERENCE);

        assert responseEntities != null;
        Map<String, Set<ResponseEntity>> collect = responseEntities
                .stream()
                .collect(groupingBy(ResponseEntity::getCk_name, mapping(ResponseEntity::get, convertToTreeSet())));

        StreamExecutionEnvironment environment = createEnvironment();

        SplitStream<String> split = environment
                .addSource(getMetricSource())
                .setParallelism(config.getSourceParallelism())
                .setMaxParallelism(config.getSourceParallelism())
                .map(String::valueOf)
                .split((OutputSelector<String>) s -> {
                    String[] splitArray = s.split("\\|");
                    List<String> output = newArrayList();
                    output.add(splitArray[0]);

                    return output;
                });

        collect.forEach((ckName, entitySet) -> {
            List<ResponseEntity> responseList = getResponseEntities(entitySet);
            String schemaString = getSchemaStr(ckName, entitySet);
            MessageType parquetSchema = parseMessageType(schemaString);

//            DataStream<Group> select = split
//                    .select(ckName)
//                    .map(new RichSourceMapFunction(schemaString, responseList))
//                    .filter(Objects::nonNull)
//                    .setParallelism(config.getSourceParallelism())
//                    .setMaxParallelism(config.getSystemParallelism());
//
//            Optional<ResponseEntity> first = responseList.stream().filter(res -> null != res.getEvent_time() && 1 == res.getEvent_time()).findFirst();
//            first.ifPresent(item -> select
//                    .filter(new TimeFilterFunction(item.getColumn_name()))
//                    .addSink(getStringBucketingSink(ckName + "_all", schemaString, parquetSchema, item.getColumn_name()))
//                    .setParallelism(config.getSystemParallelism())
//                    .name("Alluxio Parquet Sink,tableName:" + ckName));

            Optional<ResponseEntity> first = responseList.stream().filter(res -> null != res.getEvent_time() && 1 == res.getEvent_time()).findFirst();

            DataStream<GenericRecord> select = split
                    .select(ckName)
                    .map(new RichEventMapFunction(schemaString, responseList))
                    .filter(Objects::nonNull)
                    .setParallelism(config.getSourceParallelism())
                    .setMaxParallelism(config.getSystemParallelism());

            first.ifPresent(item -> select
                    .filter(new RecordTimeFilterFunction(item.getColumn_name()))
                    .addSink(getStreamingFileSink(ckName + "_all", parquetSchema, item.getColumn_name()))
                    .setParallelism(config.getSystemParallelism())
                    .name("Alluxio Parquet Sink,tableName:" + ckName));

        });

        environment.execute("Cloudy Trace Galileo Streaming Job - Rev." + currentTimeMillis());
    }

    private static List<ResponseEntity> getResponseEntities(Set<ResponseEntity> entitySet) {
        List<ResponseEntity> responseList = newArrayList();
        responseList.add(new ResponseEntity().setColumn_index(0).setColumn_name("processTime").setColumn_type("Date"));
        responseList.add(new ResponseEntity().setColumn_index(1).setColumn_name("dataSource").setColumn_type("String"));
        responseList.addAll(entitySet);
        return responseList;
    }

    private static StreamExecutionEnvironment createEnvironment() {
        StreamExecutionEnvironment executionEnvironment = getExecutionEnvironment();

        executionEnvironment.enableCheckpointing(2000);
        executionEnvironment.getCheckpointConfig().setCheckpointingMode(CheckpointingMode.EXACTLY_ONCE);
//        executionEnvironment.getCheckpointConfig().

        executionEnvironment.setParallelism(config.getSystemParallelism()).setMaxParallelism(config.getSystemMaxParallelism());
        return executionEnvironment;
    }

    private static BucketingSink<Group> getStringBucketingSink(String tableName, String schemaString, MessageType messageType, String eventTimeName) {
        String basePath = "alluxio://zk@" + config.getAlluxioZkList() + "/alert_test/" + tableName + "/";
        BucketingSink<Group> sink = new BucketingSink<>(basePath);

        // 设置以yyyyMMdd的格式进行切分目录，类似hive的日期分区
        sink.setBucketer(new DateTimeBucketer<>("yyyyMMdd", eventTimeName));
        // 设置文件块大小128M，超过128M会关闭当前文件，开启下一个文件
        sink.setBatchSize(config.getAlluxioBatchSize() * 1024 * 1024);
        // 设置一小时翻滚一次
        sink.setBatchRolloverInterval(config.getAlluxioBatchRolloverInterval() * 60 * 1000L);
        // 设置等待写入的文件前缀，默认是_
        sink.setPendingPrefix("");
        // 设置等待写入的文件后缀，默认是.pending
        sink.setPendingSuffix("");
        //设置正在处理的文件前缀，默认为_
        sink.setInProgressPrefix(".");

        sink.setWriter(new SinkParquetWriter<>(schemaString, messageType));

        return sink;
    }


    private static StreamingFileSink<GenericRecord> getStreamingFileSink(String tableName, MessageType messageType, String eventTimeName) {
        String basePath = "alluxio://zk@" + config.getAlluxioZkList() + "/alert_test/" + tableName + "/";

        return StreamingFileSink.forBulkFormat(
                new Path(basePath),
                ParquetAvroWriters.forGenericRecord(converter.convert(messageType)))
                .withBucketAssigner(new EventBucketAssigner(eventTimeName))
                .build();
    }

    private static RichParallelSourceFunction<String> getMetricSource() {
        if (false) {
            Properties kafkaParams = new Properties();
            kafkaParams.put("zookeeper.connect", config.getKafkaZkList());
            kafkaParams.put("bootstrap.servers", config.getKafkaBrokerList());
            kafkaParams.put("group.id", config.getGroupId());
            kafkaParams.put("enable.auto.commit", "true");
            kafkaParams.put("auto.commit.interval.ms", "1000");
            kafkaParams.put("auto.offset.reset", "smallest");
            kafkaParams.put("fetch.message.max.bytes", "10485760");
            kafkaParams.put("key.deserializer", StringDeserializer.class.getName());
            kafkaParams.put("value.deserializer", StringDeserializer.class.getName());
            kafkaParams.put("partition.assignment.strategy", "range");

            return new FlinkKafkaConsumer08<>(config.getTopic(), new SimpleStringSchema(), kafkaParams);
        } else {

            return new TestSourceFunction();
        }
    }

    private static String getHttpResponse() throws URISyntaxException, IOException {
        URIBuilder builder = new URIBuilder(config.getHttpUrl());
        builder.setParameter("key", "h7f32H8p4CV10JM831h92bgv1g73fg87a92w")
                .setParameter("sql", "select ck_name,c.column_name,c.column_type,c.column_index,c.event_time,task.tps\n" +
                        "from t_intel_alert_task task\n" +
                        "left join t_intel_alert_column c on task.task_id=c.task_id\n" +
                        "where enable_status = 1 order by ck_name,c.column_index");
        HttpPost post = new HttpPost(builder.build());
        CloseableHttpClient httpClient = createDefault();
        CloseableHttpResponse httpResponse = httpClient.execute(post);
        HttpEntity entity = httpResponse.getEntity();

        return EntityUtils.toString(entity);
    }
}