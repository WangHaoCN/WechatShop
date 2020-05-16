
package com.ssm.wechatshop.flink.config;

import lombok.Data;

/**
 * galileo: GalileoConfig
 *
 * @author wanghao
 * @version 2019-12-16 15:55
 */
@Data
public class GalileoConfig {

    private String httpUrl;

    private String alluxioZkList;

    private Integer alluxioBatchSize;

    private Integer alluxioBatchRolloverInterval;

    private String topic;

    private String kafkaZkList;

    private String kafkaBrokerList;

    private String groupId;

    private int sourceParallelism;

    private int systemParallelism;

    private int systemMaxParallelism;
}
