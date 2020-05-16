
package com.ssm.wechatshop.flink.config;

/**
 * galileo: KafkaConfig
 *
 * @author wanghao
 * @version 2019-12-24 14:39
 */
public class KafkaConfig {

    private String topic = "ctmdias_etl_message_prd";


    private String groupId = "ctm_alert_etl";

    private int sourceParallelism = 16;

}
