package com.lvonce.logicweaver.benchmarks;

import com.lvonce.logicweaver.executors.BehaviorExecutor;

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
public class BehaviorExecutorBench {
    private static BehaviorExecutor executor;
    @Setup
    public void prepare() {
//        class Entity  implements IBehaviorEntity {
//            public ArrayList<Integer> resultList;
//            public Entity() {
//                resultList = new ArrayList<>();
//            }
//            public IBehaviorFunction action1 = (IBehaviorExecutor executor, Object config) -> {
//                BehaviorDebug.debug("action1");
//                resultList.add(1);
//                return BehaviorResult.TRUE;
//            };
//            public IBehaviorFunction action2 = (IBehaviorEntity entity, Object config) -> {
//                BehaviorDebug.debug("action2");
//                resultList.add(2);
//                return BehaviorResult.FALSE;
//            };
//            public IBehaviorFunction action3 = (IBehaviorEntity entity, Object config) -> {
//                BehaviorDebug.debug("action3");
//                resultList.add(3);
//                return null;
//            };
//            public IBehaviorFunction action4 = (IBehaviorEntity entity, Object config) -> {
//                BehaviorDebug.debug("action4");
//                resultList.add(4);
//                return BehaviorResult.DISCARD;
//            };
//            public IBehaviorFunction action5 = (IBehaviorEntity entity, Object config) -> {
//                BehaviorDebug.debug("action5");
//                resultList.add(5);
//                return this.action2;
//            };
//        }

////        Entity entity = new Entity();
////        BehaviorUnit node1 = new BehaviorUnit(entity.getBehaviorIndex(entity.action1));
////        BehaviorUnit node2 = new BehaviorUnit(entity.getBehaviorIndex(entity.action2));
////        BehaviorUnit node3 = new BehaviorUnit(entity.getBehaviorIndex(entity.action3));
////        BehaviorUnit node4 = new BehaviorUnit(entity.getBehaviorIndex(entity.action4));
////        BehaviorUnit node5 = new BehaviorUnit(entity.getBehaviorIndex(entity.action5));
////        IBehaviorNode[] list1 = {node1, node5, node3};
//
//        BehaviorSequence behaviorSequence1 = new BehaviorSequence(list1, -3);
//        executor = new BehaviorExecutor(entity, behaviorSequence1);
    }

    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void measure() {
        executor.run();
    }

}