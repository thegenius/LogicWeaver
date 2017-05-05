package com.lvonce;

import com.lvonce.benchmarks.BehaviorSequence2Bench;
import com.lvonce.benchmarks.BehaviorSequenceBench;
import com.lvonce.concepts.BehaviorResult;
import com.lvonce.containers.BehaviorNode;
import com.lvonce.containers.BehaviorParallel;
import com.lvonce.containers.BehaviorSequence;
import com.lvonce.executors.BehaviorExecutor;
import com.lvonce.interfaces.IBehaviorEntity;
import com.lvonce.interfaces.IBehaviorFunction;
import com.lvonce.interfaces.IBehaviorNode;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.ArrayList;

import com.lvonce.Person;
import com.lvonce.Person.PersonConfig;
public class Main {

    public void runBenchmark() {
        try {
            Options opt = new OptionsBuilder()
                    .include(".*" + BehaviorSequenceBench.class.getSimpleName() + ".*")
                    .include(".*" + BehaviorSequence2Bench.class.getSimpleName() + ".*")
                    .forks(1).build();
            new Runner(opt).run();
        } catch (RunnerException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        IBehaviorEntity entity = new Person();
        Person.PersonConfig hello = Person.Builder.genConfig(Person.PersonConfig.class, 1, "hello behavior config");

        IBehaviorNode node1 = Person.Builder.genNode(Person.class, Person.action1, hello);
        IBehaviorNode node11 = entity.genNode(Person.action1, "Hello Behavior 11");
        IBehaviorNode node2 = new BehaviorNode(entity.getBehaviorIndex(Person.action2), "Hello action2");
        IBehaviorNode node3 = new BehaviorNode(entity.getBehaviorIndex(Person.action3), "action3");
        IBehaviorNode node4 = new BehaviorNode(entity.getBehaviorIndex(Person.action3Appendix), "appendix3");
        IBehaviorNode node5 = new BehaviorNode(entity.getBehaviorIndex(Person.action4), "action4");
        IBehaviorNode node6 = new BehaviorNode(entity.getBehaviorIndex(Person.action4Appendix), "appendix4");

        IBehaviorNode[] list = {node1, node11, node2, node3};
        IBehaviorNode sequence = new BehaviorSequence(list, IBehaviorNode.RESULT.TRUE.value);

        list = new IBehaviorNode[]{ node4, node5, node6};
        IBehaviorNode parallel = new BehaviorParallel(list, 0);

        list = new IBehaviorNode[] {sequence, parallel};
        IBehaviorNode root = new BehaviorSequence(list, IBehaviorNode.RESULT.FALSE.value);


        boolean success = root.defineCompleted();
        BehaviorDebug.debug("success:%s", success);
        if (success){
            BehaviorExecutor executor = new BehaviorExecutor(entity, root);
            executor.run();
        }



//        list = new IBehaviorNode[]{node1, node3, node3};
//        sequence = new BehaviorSequence(list, IBehaviorNode.RESULT.TRUE.value);
//        executor = new BehaviorExecutor(entity, sequence);
//        executor.run();
//        executor.run();
//        executor.run();
//        System.out.println(executor.getStatus());
//        executor.run();

    }
}
