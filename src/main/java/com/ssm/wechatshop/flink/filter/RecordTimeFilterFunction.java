
package com.ssm.wechatshop.flink.filter;

import org.apache.avro.generic.GenericRecord;
import org.apache.flink.api.common.functions.FilterFunction;

import java.time.Duration;

import static java.lang.Long.parseLong;

/**
 * galileo: TimeFilterFunction
 *
 * @author wanghao
 * @version 2019-12-24 10:23
 */
public class RecordTimeFilterFunction implements FilterFunction<GenericRecord> {

    private static final long pastThreeDays = -Duration.ofDays(3).toMillis();

    private static final long futureThreeDay = Duration.ofDays(3).toMillis();

    private final String columnName;

    public RecordTimeFilterFunction(String columnName) {
        this.columnName = columnName;
    }

    @Override
    public boolean filter(GenericRecord value) {
        long eventTime = parseLong(valueOf(value.get(columnName))) * 1000;
        long systemTime = currentTimeMillis();
        long timeStamp = eventTime - systemTime;

        return timeStamp > pastThreeDays && timeStamp < futureThreeDay;
    }

}
