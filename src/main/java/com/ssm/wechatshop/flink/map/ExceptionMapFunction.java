
package com.ssm.wechatshop.flink.map;

import java.util.Map;

/**
 * galileo: ExceptionMapFunction
 *
 * @author wanghao (Employee ID: 18070945)
 * @version 1.2.0, 2019-12-06 10:29
 * @since 1.2.0, 2019-12-06 10:29
 */
public class ExceptionMapFunction implements MapFunction<String, ExceptionModel> {

    public static final Map<String, String> REPLACE_MAP = ImmutableMap.<String, String>builder()
            .put("(", "")
            .put(")", "")
            .build();

    @Override
    public ExceptionModel map(String value) {
        String message = replaceFromMap(value);
        int index = message.indexOf('|');
        if (index < 0) {
            return null;
        }
        ExceptionModel exceptionModel = new ExceptionModel();

        exceptionModel.setTableName(message.substring(0, index));
        exceptionModel.setValue(message.substring(index + 1));
        return exceptionModel;
    }

    private static String replaceFromMap(String string) {
        for (Map.Entry<String, String> entry : REPLACE_MAP.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();

            int start = string.indexOf(key);
            while (start > -1) {
                string = string.replace(key, value);
                start = string.indexOf(key, start);
            }
        }
        return string;
    }
}
