
package com.ssm.wechatshop.flink.state;

import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.java.tuple.Tuple;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.TimeCharacteristic;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.KeyedStream;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.datastream.WindowedStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.windows.GlobalWindow;

/**
 * galileo: CountWindow
 *
 * @author wanghao
 * @version 2020-01-10 16:07
 */
public class CountWindow {

    public static void main(String[] args) throws Exception {
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        env.setStreamTimeCharacteristic(TimeCharacteristic.EventTime);

        DataStreamSource<String> stringDataStreamSource = env.socketTextStream("127.0.0.1", 8888);

        SingleOutputStreamOperator<Tuple2<String, Integer>> map = stringDataStreamSource.map((MapFunction<String, Tuple2<String, Integer>>) value -> {
            String[] split = value.split(",");

            String word = split[0];
            Integer count = Integer.parseInt(split[0]);

            return Tuple2.of(word, count);
        });

        KeyedStream<Tuple2<String, Integer>, Tuple> tuple2TupleKeyedStream = map.keyBy(0);

        WindowedStream<Tuple2<String, Integer>, Tuple, GlobalWindow> tuple2TupleGlobalWindowWindowedStream = tuple2TupleKeyedStream.countWindow(5);

        SingleOutputStreamOperator<Tuple2<String, Integer>> sum = tuple2TupleGlobalWindowWindowedStream.sum(1);

        sum.print();

        env.execute();
    }
}
