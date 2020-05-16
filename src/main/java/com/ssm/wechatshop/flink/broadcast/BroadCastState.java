
package com.ssm.wechatshop.flink.broadcast;

/**
 * galileo: BroadCastState
 *
 * @author wanghao
 * @version 2019-12-23 14:43
 */
public class BroadCastState {

    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        DataStreamSource<String> originStream = env.addSource(new TestSourceFunction());

        DataStream<Action> actions = env.addSource(new TestSourceFunction())
                .map((MapFunction<String, Action>) value -> new Action());

        DataStream<Pattern> patterns = env.addSource(new TestSourceFunction())
                .map((MapFunction<String, Pattern>) value -> new Pattern());

        KeyedStream<Action, Long> actionsByUser = actions.keyBy((KeySelector<Action, Long>) Action::getUserId);

        MapStateDescriptor<Void, Pattern> bcStateDescriptor =
                new MapStateDescriptor<>("patterns", Types.VOID, Types.POJO(Pattern.class));

        BroadcastStream<Pattern> broadcast = patterns.broadcast(bcStateDescriptor);

        DataStream<Tuple2<Long, Pattern>> process = actionsByUser.connect(broadcast)
                .process(new PatternEvaluator());

        MapStateDescriptor<String, String> descriptor = new MapStateDescriptor("dynamicConfig", BasicTypeInfo.STRING_TYPE_INFO, BasicTypeInfo.STRING_TYPE_INFO);
        BroadcastStream<Tuple2<String, String>> configStream = env.addSource(new DynamicConfigSource()).broadcast(descriptor);

        BroadcastConnectedStream<String, Tuple2<String, String>> connectStream = originStream.connect(configStream);
        connectStream.process(new BroadcastProcessFunction<String, Tuple2<String, String>, Void>() {
            @Override
            public void processElement(String value, ReadOnlyContext ctx, Collector<Void> out) throws Exception {
                ReadOnlyBroadcastState<String, String> config = ctx.getBroadcastState(descriptor);
                String configValue = config.get("demoConfigKey");
                //do some process base on the config
            }

            @Override
            public void processBroadcastElement(Tuple2<String, String> value, Context ctx, Collector<Void> out) throws Exception {
                //update state
                ctx.getBroadcastState(descriptor).put(value.getField(0), value.getField(1));
            }
        });

        env.execute("testBroadcastState");
    }

}
