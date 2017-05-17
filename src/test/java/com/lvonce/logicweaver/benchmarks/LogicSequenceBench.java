package com.lvonce.logicweaver.benchmarks;

import com.lvonce.logicweaver.examples.Person;
import com.lvonce.logicweaver.examples.PersonLogic;
import com.lvonce.logicweaver.interfaces.ILogicNode;
import org.junit.Test;
import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

import com.lvonce.logicweaver.examples.Person;
import com.lvonce.logicweaver.examples.PersonLogic;
import com.lvonce.logicweaver.interfaces.ILogicNode;

import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.GenerateMicroBenchmark;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

import com.lvonce.logicweaver.executors.LogicExecutor;


@State(Scope.Thread)
public class LogicSequenceBench {

    @Setup
    public void prepare() {
    }

    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void measure() {
        Person entity = new Person();
        ILogicNode logic = PersonLogic.logic;
        LogicExecutor executor = new LogicExecutor(entity, logic);
        executor.run();
    }
}
