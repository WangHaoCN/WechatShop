
package com.ssm.wechatshop.flink.sink;

import org.apache.flink.streaming.api.functions.sink.SinkFunction;
import org.apache.parquet.example.data.Group;

/**
 * galileo: EmptySinkFunction
 *
 * @author wanghao
 * @version 2019-12-18 13:39
 */
public class EmptySinkFunction implements SinkFunction<Group> {

    @Override
    public void invoke(Group value, Context context) {

    }

}