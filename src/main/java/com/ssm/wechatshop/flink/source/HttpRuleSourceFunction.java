
package com.ssm.wechatshop.flink.source;

/**
 * galileo: HttpRuleSourceFunction
 *
 * @author wanghao
 * @version 2019-12-26 09:39
 */
public class HttpRuleSourceFunction extends RichSourceFunction<ResponseEntity> {

    @Override
    public void run(SourceContext<ResponseEntity> ctx) throws Exception {

    }

    @Override
    public void cancel() {

    }

    @Override
    public void open(Configuration parameters) throws Exception {
        super.open(parameters);

    }
}
