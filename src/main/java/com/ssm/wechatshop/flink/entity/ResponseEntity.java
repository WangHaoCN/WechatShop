package com.ssm.wechatshop.flink.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class ResponseEntity implements Comparable<ResponseEntity>, Serializable {

    private String ck_name;

    private String column_name;

    private String column_type;

    private Integer column_index;

    private Integer event_time;

    private Integer tps;

    public static ResponseEntity get(ResponseEntity entity) {
        return entity;
    }

    @Override
    public int compareTo(ResponseEntity entity) {
        if (ck_name.equalsIgnoreCase(entity.getCk_name()) && column_name.equalsIgnoreCase(entity.getColumn_name())) {
            return 0;
        }

        return Integer.compare(column_index, entity.getColumn_index());
    }
}