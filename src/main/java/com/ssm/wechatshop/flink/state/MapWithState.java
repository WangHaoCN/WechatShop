
package com.ssm.wechatshop.flink.state;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.time.Time;

/**
 * galileo: MapWithState
 *
 * @author wanghao
 * @version 2020-01-09 11:35
 */
public class MapWithState {

    public static void main(String[] args) throws Exception {

        //获取运行环境
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        //连接socket获取输入的数据
        DataStreamSource<String> text = env.socketTextStream("127.0.0.1", 9090);

        //计算数据
        DataStream<Tuple2<String, Integer>> windowCount = text.flatMap((FlatMapFunction<String, Tuple2<String, Integer>>) (value, out) -> {
            String[] splits = value.split("\\s");
            for (String word : splits) {
                out.collect(new Tuple2<>(word, 1));
            }
        }).keyBy("word").timeWindow(Time.seconds(2), Time.seconds(1)).sum("count");

        windowCount.print()
                .setParallelism(1);
        env.execute("streaming word count");
    }

}
