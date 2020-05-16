
package com.ssm.wechatshop.flink.broadcast;

import org.apache.commons.lang3.RandomUtils;
import org.apache.flink.streaming.api.functions.source.SourceFunction;

import java.util.Arrays;
import java.util.List;

/**
 * galileo: TestSourceFunction
 *
 * @author wanghao
 * @version 2019-12-10 16:08
 */
public class BroadCastStateSourceFunction implements SourceFunction<String> {

    @Override
    public void run(SourceContext<String> ctx) throws Exception {
        List<String> strings = Arrays.asList(
                "alert_6d6adb4a5bc84bdc9505b96cc08278f4|'2019-12-28 10:01:45','6d6adb4a5bc84bdc9505b96cc08278f4','page','0','15118','443','14675','3315','11360','0','0','0','0','0','0','0','0','443','0','7708','0','443','14670','0','0','0','1','ec26-687f8249','v0.1.4','58148d4f0da44bf39d0f7d8046ea55a6','v.pptv.com','2019-12-28 10:01:30','[]','http://v.pptv.com/show/AT1T0O1kXpzicfeU.html?&rcc_id=2019092050','http://v.pptv.com/show/AT1T0O1kXpzicfeU.html','118.119.104.165','Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.75 Safari/537.36','zh_CN','北京','北京','东城区','unknown','unknown','Chrome','55','Windows 10','PC','','web','pgtitle=PPTV播放页;pgcate=pptv','e30='"
                , "alert_login_info|'2019-12-22 10:37:47','d26d3e77573741dfa426d28d6c4179c8','2019-12-22 10:37:46,283','2019-12-22 10:37:46','OAuthAuthenticationHandler','true','','6223203680','','142000000154','117.136.41.67','','208000202057','wap_new','','TWLolsDdgnSlas7ftkB7Z5302','','',''"
                , "alert_login_info|'2019-12-22 10:38:45','d26d3e77573741dfa426d28d6c4179c8','2019-12-22 10:38:43,427','2019-12-22 10:38:43','RememberMeCredentialsAuthenticationHandler','true','','7008123260','','142000000154','221.234.18.130','','208000103055','','','p_6ef37c24-8ceb-4307-b92b-a3eb75ea73d5','0.0,0.0','0.0,0.0',''"
                , "alert_login_info|'2019-12-22 10:38:45','d26d3e77573741dfa426d28d6c4179c8','2019-12-22 10:38:45,039','2019-12-22 10:38:45','RememberMeCredentialsAuthenticationHandler','true','','6182174670','','142000000154','120.229.222.121','','208000202003','','','2078050417471576413019223_5AA430E8142A3CFD904DBD3C91CC5D763D054C17DE9E6FD4404DE14FCBA5772D2C931FF46BFA900215595F67401F130A','116.316352,23.599183','0.0,0.0',''"
                , "alert_register_info|'2019-12-22 10:39:02','d6e40686fa404bed99a178b36aea607c','2019-12-22 10:39:01,524','2019-12-22 10:39:01','13681922229','138000000010','person','WCHAT_PUB_ACCT_UNION_REG_PAGE','208000202116','0','R0000','成功','180.152.187.32','regBind','','7126769760','',''"
        );
        while (true) {
            ctx.collect(strings.get(RandomUtils.nextInt(0, strings.size() - 1)));
        }
    }

    @Override
    public void cancel() {

    }
}
