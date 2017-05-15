package com.lvonce.logicweaver.benchmarks;

import com.lvonce.logicweaver.containers.BehaviorSequence;

import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.GenerateMicroBenchmark;
import org.openjdk.jmh.annotations.OutputTimeUnit;

import java.util.concurrent.TimeUnit;

/**
 * Created by Wangwei on 2017/3/28.
 */
@State(Scope.Thread)
public class BehaviorSequence2Bench {
    private BehaviorSequence behaviorSequence;
    @Setup
    public void prepare() {
//        BehaviorUnit node1 = new BehaviorUnit(23);
//        BehaviorUnit node2 = new BehaviorUnit(24);
//        BehaviorUnit node3 = new BehaviorUnit(25);
//        BehaviorUnit node4 = new BehaviorUnit(26);
//        BehaviorUnit node5 = new BehaviorUnit(27);
//        BehaviorUnit node6 = new BehaviorUnit(28);
//        IBehaviorNode[] list1 = {node1, node2, node3};
//        IBehaviorNode[] list2 = {node4, node5, node6};
//
//        BehaviorSequence behaviorSequence1 = new BehaviorSequence(list1, -3);
//        BehaviorSequence behaviorSequence2 = new BehaviorSequence(list2, -3);
//
//        IBehaviorNode[] list = {behaviorSequence1, behaviorSequence2};
//        behaviorSequence = new BehaviorSequence(list, -3);
    }

    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void measure() {
//        behaviorSequence.run();
//        behaviorSequence.run(IBehaviorNode.STATUS.TRUE);
//        behaviorSequence.run(IBehaviorNode.STATUS.TRUE);
    }

}
