package com.lvonce;

import com.lvonce.benchmarks.BehaviorSequence2Bench;
import com.lvonce.benchmarks.BehaviorSequenceBench;

import com.lvonce.builders.BehaviorBuilder;
import com.lvonce.examples.Person;
import com.lvonce.examples.PersonConfig;
import com.lvonce.examples.PersonLogic;

import com.lvonce.interfaces.IBehaviorNode;
import com.lvonce.executors.BehaviorExecutor;

import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.ArrayList;

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

    public static void testSequence4() {
        IBehaviorNode node1 = BehaviorBuilder.genNode(Person.action1, new PersonConfig(1, "config1"));
        IBehaviorNode node2 = BehaviorBuilder.genNode(Person.action3, new PersonConfig(2, "config2"));

        IBehaviorNode[] list1 = {node1, node2};
        IBehaviorNode root = BehaviorBuilder.genSequence(list1, IBehaviorNode.RESULT.TRUE.value);

        IBehaviorNode logic = root;
        Person entity = new Person();

        BehaviorExecutor executor = new BehaviorExecutor(entity, logic);

        ArrayList<Integer> expectedList = new ArrayList(){{ add(1); add(3); }};
        ArrayList<Integer> commandList = executor.runDebug();

        expectedList = new ArrayList(){{ add(4); }};
        commandList = executor.runDebug();

    }

    public static void main(String[] args) {
        Person entity = new Person();
        try {
            IBehaviorNode logic = PersonLogic.logic;
            if (logic != null){
                BehaviorExecutor executor = new BehaviorExecutor(entity, logic);
                executor.run();
                //executor.run();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
