
package com.ssm.wechatshop.flink.broadcast;

import lombok.Data;

/**
 * galileo: Action
 *
 * @author wanghao
 * @version 2019-12-24 14:55
 */
@Data
public class Action {

    private Long userId;

    private String action;
}
