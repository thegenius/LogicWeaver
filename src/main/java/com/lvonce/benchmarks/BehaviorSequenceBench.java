package com.lvonce.benchmarks;

import com.lvonce.examples.Person;
import com.lvonce.examples.PersonLogic;
import com.lvonce.interfaces.IBehaviorNode;

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
public class BehaviorSequenceBench {
    private Person person;
    @Setup
    public void prepare() {
        person = new Person();
        IBehaviorNode behavior = PersonLogic.logic;
    }

    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void measure() {

    }

}
