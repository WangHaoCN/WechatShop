
package com.ssm.wechatshop.flink.broadcast;

import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.functions.source.SourceFunction;

import java.util.concurrent.TimeUnit;

/**
 * galileo: DynamicConfigSource
 *
 * @author wanghao
 * @version 2019-12-23 14:44
 */
public class DynamicConfigSource implements SourceFunction<Tuple2<String, String>> {

    private volatile boolean isRunning = true;

    @Override
    public void run(SourceContext<Tuple2<String, String>> sourceContext) throws Exception {
        long idx = 1;
        while (isRunning) {
            sourceContext.collect(Tuple2.of("demoConfigKey", "value" + idx));
            idx++;
            TimeUnit.SECONDS.sleep(10);
        }
    }

    @Override
    public void cancel() {
        isRunning = false;
    }
}
