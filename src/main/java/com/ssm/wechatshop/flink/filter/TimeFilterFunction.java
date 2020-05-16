
package com.ssm.wechatshop.flink.filter;

import org.apache.flink.api.common.functions.FilterFunction;
import org.apache.parquet.example.data.Group;

import java.time.Duration;

/**
 * galileo: TimeFilterFunction
 *
 * @author wanghao
 * @version 2019-12-24 10:23
 */
public class TimeFilterFunction implements FilterFunction<Group> {

    private static final long pastThreeDays = -Duration.ofDays(3).toMillis();

    private static final long futureThreeDay = Duration.ofDays(3).toMillis();

    private final String columnName;

    public TimeFilterFunction(String columnName) {
        this.columnName = columnName;
    }

    @Override
    public boolean filter(Group value) {
        long eventTime = value.getLong(columnName, 0) * 1000;
        long systemTime = currentTimeMillis();
        long timeStamp = eventTime - systemTime;

        return timeStamp > pastThreeDays && timeStamp < futureThreeDay;
    }

}
