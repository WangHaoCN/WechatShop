
package com.ssm.wechatshop.flink.state;

import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.time.Time;

/**
 * galileo: FlinkTumblingWindowsInnerJoin
 *
 * @author wanghao
 * @version 2020-01-10 10:23
 */
public class FlinkTumblingWindowsInnerJoin {

    public static void main(String[] args) throws Exception {

        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        env.setParallelism(1);

        DataStreamSource<String> stringDataStreamSource = env.socketTextStream("127.0.0.1", 8888);

        SingleOutputStreamOperator<Integer> mapStream = stringDataStreamSource.map(new MapFunction<String, Integer>() {
            @Override
            public Integer map(String value) throws Exception {
                return Integer.parseInt(value);
            }
        });
        /**
         * 不分组，5条一个窗口
         */
        SingleOutputStreamOperator<Integer> summed = mapStream.timeWindowAll(Time.seconds(5),Time.seconds(2)).sum(0);

        summed.print();

        env.execute();
    }

}
