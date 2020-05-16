
package com.ssm.wechatshop.flink.config;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigBeanFactory;
import com.typesafe.config.ConfigFactory;

/**
 * galileo: ConfigurationLoader
 *
 * @author wanghao
 * @version 2019-12-27 14:09
 */
public class ConfigurationLoader {

    public static GalileoConfig load() {
        Config config = ConfigFactory.load();
        return ConfigBeanFactory.create(config.getConfig("galileoConfig"), GalileoConfig.class);
    }

}
