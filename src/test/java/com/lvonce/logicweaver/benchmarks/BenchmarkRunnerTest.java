package com.lvonce.logicweaver.benchmarks;


import org.junit.Test;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class BenchmarkRunnerTest {

    @Test
    public void runBenchmark() {
        try {
            Options opt = new OptionsBuilder()
                    .include(".*" + LogicSequenceBench.class.getSimpleName() + ".*")
                    .forks(1).build();
            new Runner(opt).run();
        } catch (RunnerException e) {
            e.printStackTrace();
        }
    }
}
