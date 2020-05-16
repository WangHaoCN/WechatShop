
package com.ssm.wechatshop.flink.config;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

/**
 * galileo: ParquetSchemaConfig
 *
 * @author wanghao
 * @version 2019-12-13 09:34
 */
@Data
public class ParquetSchemaConfig implements Serializable {

    private String type = "record";

    private String name;

    private List<FieldConfig> fields = newArrayList();

    public ParquetSchemaConfig setField(String fieldName, String fieldType) {

        fields.add(new FieldConfig(fieldName, fieldType));
        return this;
    }

    private ParquetSchemaConfig(String name) {
        this.name = name;
    }

    public static ParquetSchemaConfig getNewInstance(String name) {

        return new ParquetSchemaConfig(name);
    }

    @Data
    @AllArgsConstructor
    private class FieldConfig implements Serializable {
        private String name;

        private String type;
    }
}
