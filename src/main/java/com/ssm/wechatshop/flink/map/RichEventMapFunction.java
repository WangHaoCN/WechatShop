
package com.ssm.wechatshop.flink.map;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.List;

import static java.time.LocalDateTime.now;
import static java.time.LocalDateTime.parse;
import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE;
import static java.time.format.DateTimeFormatter.ISO_LOCAL_TIME;

/**
 * galileo: RichSourceMapFunction
 *
 * @author wanghao
 * @version 2019-12-17 15:52
 */
@Slf4j
public class RichEventMapFunction extends RichMapFunction<String, GenericRecord> {

    private static final DateTimeFormatter EXCEPTION_MODEL_TIME_FORMATTER = new DateTimeFormatterBuilder()
            .parseCaseInsensitive()
            .append(ISO_LOCAL_DATE)
            .appendLiteral(' ')
            .append(ISO_LOCAL_TIME)
            .toFormatter();

    private static final ZoneOffset ES_TIME_ZONE_OFFSET = ZoneOffset.ofHours(8);

    private final String schemaString;

    private static final AvroSchemaConverter converter = new AvroSchemaConverter();

    private Schema schema;

    private final List<ResponseEntity> responseList;

    public RichEventMapFunction(String schemaString, List<ResponseEntity> responseList) {
        this.schemaString = schemaString;
        this.responseList = responseList;
    }

    @Override
    public GenericRecord map(String value) {
        StringBuilder stringBuilder = new StringBuilder(value);
        String substring = stringBuilder.substring(stringBuilder.indexOf("|") + 2, stringBuilder.length() - 1);
        GenericRecord record = new Record(schema);

        List<String> kafkaMessage = split(substring, "','");

        int size = kafkaMessage.size();

        for (int i = 0; i < responseList.size() && size > i; i++) {
            ResponseEntity responseEntity = responseList.get(i);
            String valueStr = kafkaMessage.get(i);
            if ("Date".equalsIgnoreCase(responseEntity.getColumn_type())) {
                LocalDateTime localDateTime = now();
                try {
                    if (!"0000-00-00 00:00:00".equals(valueStr)) {

                        localDateTime = parse(valueStr, EXCEPTION_MODEL_TIME_FORMATTER);
                    }

                    return null;
                } catch (Exception e) {

                    log.warn("dateTime parse exception, {},exception:{}", value, e);
                }
                record.put(responseEntity.getColumn_name(), localDateTime.toEpochSecond(ES_TIME_ZONE_OFFSET));
            } else {

                record.put(responseEntity.getColumn_name(), valueStr);
            }
        }
        return record;
    }

    @Override
    public void open(Configuration parameters) throws Exception {
        super.open(parameters);

        this.schema = converter.convert(parseMessageType(schemaString));
    }
}
