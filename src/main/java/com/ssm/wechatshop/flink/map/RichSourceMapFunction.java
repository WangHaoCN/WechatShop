/*
 *
 * This file is part of galileo project.
 * It can not be copied and/or distributed without the express
 * permission of cloudytrace group.
 */
package com.ssm.wechatshop.flink.map;

import lombok.extern.slf4j.Slf4j;
import org.apache.flink.api.common.functions.RichMapFunction;
import org.apache.flink.configuration.Configuration;
import org.apache.parquet.example.data.Group;
import org.apache.parquet.example.data.simple.SimpleGroupFactory;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.List;

import static java.time.LocalDateTime.now;
import static java.time.LocalDateTime.parse;
import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE;
import static java.time.format.DateTimeFormatter.ISO_LOCAL_TIME;
import static org.apache.parquet.schema.MessageTypeParser.parseMessageType;

/**
 * galileo: RichSourceMapFunction
 *
 * @author wanghao
 * @version 2019-12-17 15:52
 */
@Slf4j
public class RichSourceMapFunction extends RichMapFunction<String, Group> {

    private static final DateTimeFormatter EXCEPTION_MODEL_TIME_FORMATTER = new DateTimeFormatterBuilder()
            .parseCaseInsensitive()
            .append(ISO_LOCAL_DATE)
            .appendLiteral(' ')
            .append(ISO_LOCAL_TIME)
            .toFormatter();

    private static final ZoneOffset ES_TIME_ZONE_OFFSET = ZoneOffset.ofHours(8);

    private final String schemaString;
    private final List<ResponseEntity> responseList;

    private SimpleGroupFactory simpleGroupFactory;

    public RichSourceMapFunction(String schemaString, List<ResponseEntity> responseList) {
        this.schemaString = schemaString;
        this.responseList = responseList;
    }

    @Override
    public Group map(String value) {
        StringBuilder stringBuilder = new StringBuilder(value);
        String substring = stringBuilder.substring(stringBuilder.indexOf("|") + 2, stringBuilder.length() - 1);

        List<String> kafkaMessage = split(substring, "','");

        int size = kafkaMessage.size();

        Group group = simpleGroupFactory.newGroup();
        for (int i = 0; i < responseList.size() && size > i; i++) {
            ResponseEntity responseEntity = responseList.get(i);
            String valueStr = kafkaMessage.get(i);
            if ("Date".equalsIgnoreCase(responseEntity.getColumn_type())) {
                LocalDateTime localDateTime = now();
                try {
                    if ("0000-00-00 00:00:00".equals(valueStr)) {

                        return null;
                    }

                    localDateTime = parse(valueStr, EXCEPTION_MODEL_TIME_FORMATTER);
                } catch (Exception e) {

                    log.warn("dateTime parse exception, {},exception:{}", value, e);
                }
                group.append(responseEntity.getColumn_name(), localDateTime.toEpochSecond(ES_TIME_ZONE_OFFSET));
            } else {

                group.append(responseEntity.getColumn_name(), valueStr);
            }
        }
        return group;
    }

    @Override
    public void open(Configuration parameters) throws Exception {
        super.open(parameters);

        simpleGroupFactory = new SimpleGroupFactory(parseMessageType(schemaString));
    }
}
