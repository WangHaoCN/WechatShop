/*
 *
 * This file is part of galileo project.
 * It can not be copied and/or distributed without the express
 * permission of cloudytrace group.
 */
package com.ssm.wechatshop.flink.map;

import org.apache.flink.api.common.functions.MapFunction;

/**
 * galileo: StringMapFunction
 *
 * @author wanghao (Employee ID: 18070945)
 * @version 1.2.0, 2019-12-06 17:45
 * @since 1.2.0, 2019-12-06 17:45
 */
public class StringMapFunction implements MapFunction<String, String> {
    @Override
    public String map(String s) {

        return s;
    }
}
