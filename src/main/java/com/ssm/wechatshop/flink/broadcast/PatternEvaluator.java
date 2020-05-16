
package com.ssm.wechatshop.flink.broadcast;

import org.apache.flink.api.common.state.BroadcastState;
import org.apache.flink.api.common.state.MapStateDescriptor;
import org.apache.flink.api.common.state.ValueState;
import org.apache.flink.api.common.state.ValueStateDescriptor;
import org.apache.flink.api.common.typeinfo.Types;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.functions.co.KeyedBroadcastProcessFunction;
import org.apache.flink.util.Collector;

/**
 * galileo: PatternEvaluator
 *
 * @author wanghao
 * @version 2019-12-24 15:03
 */
public class PatternEvaluator extends KeyedBroadcastProcessFunction<Long, Action, Pattern, Tuple2<Long, Pattern>> {

    ValueState<String> preActionsState;

    MapStateDescriptor<Void, Pattern> patternDesc;

    @Override
    public void open(Configuration parameters) {
        preActionsState = getRuntimeContext().getState(new ValueStateDescriptor<>("lastAction", Types.STRING));

        patternDesc = new MapStateDescriptor<>("patterns", Types.VOID, Types.POJO(Pattern.class));
    }

    /**
     * processElement() 方法：接受到用户行为流的每条消息时会调用，并能够对广播状态进行只读操作，以防止导致跨越类中多个并发实例的不同广播状态的修改。
     * PatternEvaluator 类的 processElement() 方法从广播状态中获取当前模式，并从 keyed state 中获取用户的前一个操作。
     * 如果两者都存在，它会检查前一个和当前的操作行为是否与模式匹配，如果是这样，则会发出模式匹配记录。最后，它将 keyed state 更新为当前用户操作；
     *
     * @param action
     * @param readOnlyContext
     * @param collector
     * @throws Exception
     */
    @Override
    public void processElement(Action action, ReadOnlyContext readOnlyContext, Collector<Tuple2<Long, Pattern>> collector) throws Exception {
        Pattern pattern = readOnlyContext.getBroadcastState(this.patternDesc).get(null);

        String preAction = preActionsState.value();

        if (pattern != null && preAction != null) {
            if (pattern.getFirstAction().equals(preAction) && pattern.getSecondAction().equals(action.getAction())) {

                collector.collect(new Tuple2<>(readOnlyContext.getCurrentKey(), pattern));
            }
        }

        preActionsState.update(action.getAction());
    }

    /**
     * 每次收到广播流的记录时会调用。在 PatternEvaluator 类中，我们只需使用 null 键将接收到的 Pattern 记录放入广播状态中（记住，我们只在 MapState 中存储一个模式）
     *
     * @param pattern
     * @param context
     * @param collector
     * @throws Exception
     */
    @Override
    public void processBroadcastElement(Pattern pattern, Context
            context, Collector<Tuple2<Long, Pattern>> collector) throws Exception {
        BroadcastState<Void, Pattern> bcState = context.getBroadcastState(patternDesc);

        bcState.put(null, pattern);
    }

    /**
     * 当之前注册过的计时器触发时被调用。计时器可以在processElement 方法中定义，用于执行计算或是清除状态。
     * 为了保持代码的简洁性，我们没有在例子中实现这个方法，但当用户在某段时间内没有操作时，它可以用来删除最后一个操作，以避免由于非活动用户而导致状态增长；
     *
     * @param timestamp
     * @param ctx
     * @param out
     * @throws Exception
     */
    @Override
    public void onTimer(long timestamp, OnTimerContext ctx, Collector<Tuple2<Long, Pattern>> out) throws Exception {
        super.onTimer(timestamp, ctx, out);
    }
}
