/*
 *
 * This file is part of galileo project.
 * It can not be copied and/or distributed without the express
 * permission of cloudytrace group.
 */
package com.ssm.wechatshop.flink.entity;

import lombok.Data;
import org.apache.parquet.example.data.Group;

import java.io.Serializable;

/**
 * galileo: ExceptionModel
 *
 * @author wanghao (Employee ID: 18070945)
 * @version 1.2.0, 2019-12-05 17:36
 * @since 1.2.0, 2019-12-05 17:36
 */
@Data
public class ExceptionModel implements Serializable {
    private static final long serialVersionUID = 8868695434458133343L;

    private String tableName;

    private String value;

    private Group group;
}
