package com.lvonce.benchmarks.generated;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.Collection;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.openjdk.jmh.annotations.CompilerControl;
import org.openjdk.jmh.logic.InfraControl;
import org.openjdk.jmh.logic.ThreadControl;
import org.openjdk.jmh.logic.BlackHole;
import org.openjdk.jmh.logic.results.Result;
import org.openjdk.jmh.logic.results.ThroughputResult;
import org.openjdk.jmh.logic.results.AverageTimeResult;
import org.openjdk.jmh.logic.results.SampleTimeResult;
import org.openjdk.jmh.logic.results.SingleShotResult;
import org.openjdk.jmh.util.internal.SampleBuffer;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Threads;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.logic.results.RawResults;
import org.openjdk.jmh.logic.results.ResultRole;

@CompilerControl(CompilerControl.Mode.DONT_INLINE)
@Generated("org.openjdk.jmh.processor.internal.GenerateMicroBenchmarkProcessor")
public final class BehaviorExecutorBench {

    boolean jmh_bench_pad_0, jmh_bench_pad_0_1, jmh_bench_pad_0_2, jmh_bench_pad_0_3, jmh_bench_pad_0_4, jmh_bench_pad_0_5, jmh_bench_pad_0_6, jmh_bench_pad_0_7, jmh_bench_pad_0_8, jmh_bench_pad_0_9, jmh_bench_pad_0_10, jmh_bench_pad_0_11, jmh_bench_pad_0_12, jmh_bench_pad_0_13, jmh_bench_pad_0_14, jmh_bench_pad_0_15;
    boolean jmh_bench_pad_1, jmh_bench_pad_1_1, jmh_bench_pad_1_2, jmh_bench_pad_1_3, jmh_bench_pad_1_4, jmh_bench_pad_1_5, jmh_bench_pad_1_6, jmh_bench_pad_1_7, jmh_bench_pad_1_8, jmh_bench_pad_1_9, jmh_bench_pad_1_10, jmh_bench_pad_1_11, jmh_bench_pad_1_12, jmh_bench_pad_1_13, jmh_bench_pad_1_14, jmh_bench_pad_1_15;
    boolean jmh_bench_pad_2, jmh_bench_pad_2_1, jmh_bench_pad_2_2, jmh_bench_pad_2_3, jmh_bench_pad_2_4, jmh_bench_pad_2_5, jmh_bench_pad_2_6, jmh_bench_pad_2_7, jmh_bench_pad_2_8, jmh_bench_pad_2_9, jmh_bench_pad_2_10, jmh_bench_pad_2_11, jmh_bench_pad_2_12, jmh_bench_pad_2_13, jmh_bench_pad_2_14, jmh_bench_pad_2_15;
    boolean jmh_bench_pad_3, jmh_bench_pad_3_1, jmh_bench_pad_3_2, jmh_bench_pad_3_3, jmh_bench_pad_3_4, jmh_bench_pad_3_5, jmh_bench_pad_3_6, jmh_bench_pad_3_7, jmh_bench_pad_3_8, jmh_bench_pad_3_9, jmh_bench_pad_3_10, jmh_bench_pad_3_11, jmh_bench_pad_3_12, jmh_bench_pad_3_13, jmh_bench_pad_3_14, jmh_bench_pad_3_15;
    boolean jmh_bench_pad_4, jmh_bench_pad_4_1, jmh_bench_pad_4_2, jmh_bench_pad_4_3, jmh_bench_pad_4_4, jmh_bench_pad_4_5, jmh_bench_pad_4_6, jmh_bench_pad_4_7, jmh_bench_pad_4_8, jmh_bench_pad_4_9, jmh_bench_pad_4_10, jmh_bench_pad_4_11, jmh_bench_pad_4_12, jmh_bench_pad_4_13, jmh_bench_pad_4_14, jmh_bench_pad_4_15;
    boolean jmh_bench_pad_5, jmh_bench_pad_5_1, jmh_bench_pad_5_2, jmh_bench_pad_5_3, jmh_bench_pad_5_4, jmh_bench_pad_5_5, jmh_bench_pad_5_6, jmh_bench_pad_5_7, jmh_bench_pad_5_8, jmh_bench_pad_5_9, jmh_bench_pad_5_10, jmh_bench_pad_5_11, jmh_bench_pad_5_12, jmh_bench_pad_5_13, jmh_bench_pad_5_14, jmh_bench_pad_5_15;
    boolean jmh_bench_pad_6, jmh_bench_pad_6_1, jmh_bench_pad_6_2, jmh_bench_pad_6_3, jmh_bench_pad_6_4, jmh_bench_pad_6_5, jmh_bench_pad_6_6, jmh_bench_pad_6_7, jmh_bench_pad_6_8, jmh_bench_pad_6_9, jmh_bench_pad_6_10, jmh_bench_pad_6_11, jmh_bench_pad_6_12, jmh_bench_pad_6_13, jmh_bench_pad_6_14, jmh_bench_pad_6_15;
    boolean jmh_bench_pad_7, jmh_bench_pad_7_1, jmh_bench_pad_7_2, jmh_bench_pad_7_3, jmh_bench_pad_7_4, jmh_bench_pad_7_5, jmh_bench_pad_7_6, jmh_bench_pad_7_7, jmh_bench_pad_7_8, jmh_bench_pad_7_9, jmh_bench_pad_7_10, jmh_bench_pad_7_11, jmh_bench_pad_7_12, jmh_bench_pad_7_13, jmh_bench_pad_7_14, jmh_bench_pad_7_15;
    boolean jmh_bench_pad_8, jmh_bench_pad_8_1, jmh_bench_pad_8_2, jmh_bench_pad_8_3, jmh_bench_pad_8_4, jmh_bench_pad_8_5, jmh_bench_pad_8_6, jmh_bench_pad_8_7, jmh_bench_pad_8_8, jmh_bench_pad_8_9, jmh_bench_pad_8_10, jmh_bench_pad_8_11, jmh_bench_pad_8_12, jmh_bench_pad_8_13, jmh_bench_pad_8_14, jmh_bench_pad_8_15;
    boolean jmh_bench_pad_9, jmh_bench_pad_9_1, jmh_bench_pad_9_2, jmh_bench_pad_9_3, jmh_bench_pad_9_4, jmh_bench_pad_9_5, jmh_bench_pad_9_6, jmh_bench_pad_9_7, jmh_bench_pad_9_8, jmh_bench_pad_9_9, jmh_bench_pad_9_10, jmh_bench_pad_9_11, jmh_bench_pad_9_12, jmh_bench_pad_9_13, jmh_bench_pad_9_14, jmh_bench_pad_9_15;
    boolean jmh_bench_pad_10, jmh_bench_pad_10_1, jmh_bench_pad_10_2, jmh_bench_pad_10_3, jmh_bench_pad_10_4, jmh_bench_pad_10_5, jmh_bench_pad_10_6, jmh_bench_pad_10_7, jmh_bench_pad_10_8, jmh_bench_pad_10_9, jmh_bench_pad_10_10, jmh_bench_pad_10_11, jmh_bench_pad_10_12, jmh_bench_pad_10_13, jmh_bench_pad_10_14, jmh_bench_pad_10_15;
    boolean jmh_bench_pad_11, jmh_bench_pad_11_1, jmh_bench_pad_11_2, jmh_bench_pad_11_3, jmh_bench_pad_11_4, jmh_bench_pad_11_5, jmh_bench_pad_11_6, jmh_bench_pad_11_7, jmh_bench_pad_11_8, jmh_bench_pad_11_9, jmh_bench_pad_11_10, jmh_bench_pad_11_11, jmh_bench_pad_11_12, jmh_bench_pad_11_13, jmh_bench_pad_11_14, jmh_bench_pad_11_15;
    boolean jmh_bench_pad_12, jmh_bench_pad_12_1, jmh_bench_pad_12_2, jmh_bench_pad_12_3, jmh_bench_pad_12_4, jmh_bench_pad_12_5, jmh_bench_pad_12_6, jmh_bench_pad_12_7, jmh_bench_pad_12_8, jmh_bench_pad_12_9, jmh_bench_pad_12_10, jmh_bench_pad_12_11, jmh_bench_pad_12_12, jmh_bench_pad_12_13, jmh_bench_pad_12_14, jmh_bench_pad_12_15;
    boolean jmh_bench_pad_13, jmh_bench_pad_13_1, jmh_bench_pad_13_2, jmh_bench_pad_13_3, jmh_bench_pad_13_4, jmh_bench_pad_13_5, jmh_bench_pad_13_6, jmh_bench_pad_13_7, jmh_bench_pad_13_8, jmh_bench_pad_13_9, jmh_bench_pad_13_10, jmh_bench_pad_13_11, jmh_bench_pad_13_12, jmh_bench_pad_13_13, jmh_bench_pad_13_14, jmh_bench_pad_13_15;
    boolean jmh_bench_pad_14, jmh_bench_pad_14_1, jmh_bench_pad_14_2, jmh_bench_pad_14_3, jmh_bench_pad_14_4, jmh_bench_pad_14_5, jmh_bench_pad_14_6, jmh_bench_pad_14_7, jmh_bench_pad_14_8, jmh_bench_pad_14_9, jmh_bench_pad_14_10, jmh_bench_pad_14_11, jmh_bench_pad_14_12, jmh_bench_pad_14_13, jmh_bench_pad_14_14, jmh_bench_pad_14_15;
    boolean jmh_bench_pad_15, jmh_bench_pad_15_1, jmh_bench_pad_15_2, jmh_bench_pad_15_3, jmh_bench_pad_15_4, jmh_bench_pad_15_5, jmh_bench_pad_15_6, jmh_bench_pad_15_7, jmh_bench_pad_15_8, jmh_bench_pad_15_9, jmh_bench_pad_15_10, jmh_bench_pad_15_11, jmh_bench_pad_15_12, jmh_bench_pad_15_13, jmh_bench_pad_15_14, jmh_bench_pad_15_15;

    public Collection<? extends Result> measure_Throughput(InfraControl control, ThreadControl threadControl) throws Throwable {

        if (threadControl.subgroup == 0) {
            BehaviorExecutorBench_1_jmh l_bench = tryInit_f_bench(control, new BehaviorExecutorBench_1_jmh());
            BlackHole_1_jmh l_blackhole = tryInit_f_blackhole(control, new BlackHole_1_jmh());

            control.preSetup();
            if (!l_blackhole.readyIteration) {
                l_blackhole.clearSinks();
                l_blackhole.readyIteration = true;
            }

            control.announceWarmupReady();
            while (control.warmupShouldWait) {
                l_bench.measure();
            }

            RawResults res = new RawResults(1L);
            measure_Throughput_measurementLoop(control, res, l_bench, l_blackhole);
            control.announceWarmdownReady();
            while (control.warmdownShouldWait) {
                l_bench.measure();
            }
            control.preTearDown();
            if (l_blackhole.readyIteration) {
                l_blackhole.readyIteration = false;
            }

            if (control.isLastIteration()) {
                if (l_bench.readyTrial) {
                    l_bench.readyTrial = false;
                }
                f_bench = null;
                f_blackhole = null;
            }
            Collection<Result> results = new ArrayList<Result>();
            TimeUnit tu = (control.timeUnit != null) ? control.timeUnit : TimeUnit.SECONDS;
            results.add(new ThroughputResult(ResultRole.PRIMARY, "measure", res.getOperations(), res.getTime(), tu));
            return results;
        } else
            throw new IllegalStateException("Harness failed to distribute threads among groups properly");

    }
    public  void measure_Throughput_measurementLoop(InfraControl control, RawResults result, BehaviorExecutorBench_1_jmh l_bench, BlackHole_1_jmh l_blackhole) throws Throwable {
        long operations = 0;
        long realTime = 0;
        result.startTime = System.nanoTime();
        do {
            l_bench.measure();
            operations++;
        } while(!control.isDone);
        result.stopTime = System.nanoTime();
        result.realTime = realTime;
        result.operations = operations;
    }


    public Collection<? extends Result> measure_AverageTime(InfraControl control, ThreadControl threadControl) throws Throwable {
        if (threadControl.subgroup == 0) {
            BehaviorExecutorBench_1_jmh l_bench = tryInit_f_bench(control, new BehaviorExecutorBench_1_jmh());
            BlackHole_1_jmh l_blackhole = tryInit_f_blackhole(control, new BlackHole_1_jmh());

            control.preSetup();
            if (!l_blackhole.readyIteration) {
                l_blackhole.clearSinks();
                l_blackhole.readyIteration = true;
            }

            control.announceWarmupReady();
            while (control.warmupShouldWait) {
                l_bench.measure();
            }

            RawResults res = new RawResults(1L);
            measure_AverageTime_measurementLoop(control, res, l_bench, l_blackhole);
            control.announceWarmdownReady();
            while (control.warmdownShouldWait) {
                l_bench.measure();
            }
            control.preTearDown();
            if (l_blackhole.readyIteration) {
                l_blackhole.readyIteration = false;
            }

            if (control.isLastIteration()) {
                if (l_bench.readyTrial) {
                    l_bench.readyTrial = false;
                }
                f_bench = null;
                f_blackhole = null;
            }
            Collection<Result> results = new ArrayList<Result>();
            TimeUnit tu = (control.timeUnit != null) ? control.timeUnit : TimeUnit.SECONDS;
            results.add(new AverageTimeResult(ResultRole.PRIMARY, "measure", res.getOperations(), res.getTime(), tu));
            return results;
        } else
            throw new IllegalStateException("Harness failed to distribute threads among groups properly");

    }
    public  void measure_AverageTime_measurementLoop(InfraControl control, RawResults result, BehaviorExecutorBench_1_jmh l_bench, BlackHole_1_jmh l_blackhole) throws Throwable {
        long operations = 0;
        long realTime = 0;
        result.startTime = System.nanoTime();
        do {
            l_bench.measure();
            operations++;
        } while(!control.isDone);
        result.stopTime = System.nanoTime();
        result.realTime = realTime;
        result.operations = operations;
    }


    public Collection<? extends Result> measure_SampleTime(InfraControl control, ThreadControl threadControl) throws Throwable {

        if (threadControl.subgroup == 0) {
            BehaviorExecutorBench_1_jmh l_bench = tryInit_f_bench(control, new BehaviorExecutorBench_1_jmh());
            BlackHole_1_jmh l_blackhole = tryInit_f_blackhole(control, new BlackHole_1_jmh());

            control.preSetup();
            if (!l_blackhole.readyIteration) {
                l_blackhole.clearSinks();
                l_blackhole.readyIteration = true;
            }

            control.announceWarmupReady();
            while (control.warmupShouldWait) {
                l_bench.measure();
            }

            SampleBuffer buffer = new SampleBuffer();
            measure_SampleTime_measurementLoop(control, buffer, l_bench, l_blackhole);
            control.announceWarmdownReady();
            while (control.warmdownShouldWait) {
                l_bench.measure();
            }

            control.preTearDown();
            if (l_blackhole.readyIteration) {
                l_blackhole.readyIteration = false;
            }

            if (control.isLastIteration()) {
                if (l_bench.readyTrial) {
                    l_bench.readyTrial = false;
                }
                f_bench = null;
                f_blackhole = null;
            }
            Collection<Result> results = new ArrayList<Result>();
            TimeUnit tu = (control.timeUnit != null) ? control.timeUnit : TimeUnit.SECONDS;
            results.add(new SampleTimeResult(ResultRole.PRIMARY, "measure", buffer, tu));
            return results;
        } else
            throw new IllegalStateException("Harness failed to distribute threads among groups properly");
    }
    public  void measure_SampleTime_measurementLoop(InfraControl control, SampleBuffer buffer, BehaviorExecutorBench_1_jmh l_bench, BlackHole_1_jmh l_blackhole) throws Throwable {
        long realTime = 0;
        int rnd = (int)System.nanoTime();
        int rndMask = 0;
        long time = 0;
        int currentStride = 0;
        do {
            rnd = (rnd * 1664525 + 1013904223);
            boolean sample = (rnd & rndMask) == 0;
            if (sample) {
                time = System.nanoTime();
            }
            l_bench.measure();
            if (sample) {
                buffer.add(System.nanoTime() - time);
                if (currentStride++ > 1000000) {
                    buffer.half();
                    currentStride = 0;
                    rndMask = (rndMask << 1) + 1;
                }
            }
        } while(!control.isDone);
    }


    public Collection<? extends Result> measure_SingleShotTime(InfraControl control, ThreadControl threadControl) throws Throwable {
        long realTime = 0;
        if (threadControl.subgroup == 0) {
            BehaviorExecutorBench_1_jmh l_bench = tryInit_f_bench(control, new BehaviorExecutorBench_1_jmh());
            BlackHole_1_jmh l_blackhole = tryInit_f_blackhole(control, new BlackHole_1_jmh());

            control.preSetup();
            if (!l_blackhole.readyIteration) {
                l_blackhole.clearSinks();
                l_blackhole.readyIteration = true;
            }

            long time1 = System.nanoTime();
            int batchSize = control.batchSize;
            for (int b = 0; b < batchSize; b++) {
                l_bench.measure();
            }
            long time2 = System.nanoTime();
            control.preTearDown();
            if (l_blackhole.readyIteration) {
                l_blackhole.readyIteration = false;
            }

            if (control.isLastIteration()) {
                if (l_bench.readyTrial) {
                    l_bench.readyTrial = false;
                }
                f_bench = null;
                f_blackhole = null;
            }
            Collection<Result> results = new ArrayList<Result>();
            TimeUnit tu = (control.timeUnit != null) ? control.timeUnit : TimeUnit.SECONDS;
            results.add(new SingleShotResult(ResultRole.PRIMARY, "measure", (realTime > 0) ? realTime : (time2 - time1), tu));
            return results;
        } else
            throw new IllegalStateException("Harness failed to distribute threads among groups properly");

    }
    
    BehaviorExecutorBench_1_jmh f_bench;
    
    BehaviorExecutorBench_1_jmh tryInit_f_bench(InfraControl control, BehaviorExecutorBench_1_jmh val) throws Throwable {
        if (f_bench == null) {
                    val.prepare();
                    val.readyTrial = true;
              f_bench = val;
        }
        return f_bench;
    }
    
    BlackHole_1_jmh f_blackhole;
    
    BlackHole_1_jmh tryInit_f_blackhole(InfraControl control, BlackHole_1_jmh val) throws Throwable {
        if (f_blackhole == null) {
                    val.readyTrial = true;
              f_blackhole = val;
        }
        return f_blackhole;
    }


    static class BehaviorExecutorBench_1_jmh_B1 extends com.lvonce.benchmarks.BehaviorExecutorBench {
        boolean jmh_b3_pad_0, jmh_b3_pad_0_1, jmh_b3_pad_0_2, jmh_b3_pad_0_3, jmh_b3_pad_0_4, jmh_b3_pad_0_5, jmh_b3_pad_0_6, jmh_b3_pad_0_7, jmh_b3_pad_0_8, jmh_b3_pad_0_9, jmh_b3_pad_0_10, jmh_b3_pad_0_11, jmh_b3_pad_0_12, jmh_b3_pad_0_13, jmh_b3_pad_0_14, jmh_b3_pad_0_15;
        boolean jmh_b3_pad_1, jmh_b3_pad_1_1, jmh_b3_pad_1_2, jmh_b3_pad_1_3, jmh_b3_pad_1_4, jmh_b3_pad_1_5, jmh_b3_pad_1_6, jmh_b3_pad_1_7, jmh_b3_pad_1_8, jmh_b3_pad_1_9, jmh_b3_pad_1_10, jmh_b3_pad_1_11, jmh_b3_pad_1_12, jmh_b3_pad_1_13, jmh_b3_pad_1_14, jmh_b3_pad_1_15;
        boolean jmh_b3_pad_2, jmh_b3_pad_2_1, jmh_b3_pad_2_2, jmh_b3_pad_2_3, jmh_b3_pad_2_4, jmh_b3_pad_2_5, jmh_b3_pad_2_6, jmh_b3_pad_2_7, jmh_b3_pad_2_8, jmh_b3_pad_2_9, jmh_b3_pad_2_10, jmh_b3_pad_2_11, jmh_b3_pad_2_12, jmh_b3_pad_2_13, jmh_b3_pad_2_14, jmh_b3_pad_2_15;
        boolean jmh_b3_pad_3, jmh_b3_pad_3_1, jmh_b3_pad_3_2, jmh_b3_pad_3_3, jmh_b3_pad_3_4, jmh_b3_pad_3_5, jmh_b3_pad_3_6, jmh_b3_pad_3_7, jmh_b3_pad_3_8, jmh_b3_pad_3_9, jmh_b3_pad_3_10, jmh_b3_pad_3_11, jmh_b3_pad_3_12, jmh_b3_pad_3_13, jmh_b3_pad_3_14, jmh_b3_pad_3_15;
        boolean jmh_b3_pad_4, jmh_b3_pad_4_1, jmh_b3_pad_4_2, jmh_b3_pad_4_3, jmh_b3_pad_4_4, jmh_b3_pad_4_5, jmh_b3_pad_4_6, jmh_b3_pad_4_7, jmh_b3_pad_4_8, jmh_b3_pad_4_9, jmh_b3_pad_4_10, jmh_b3_pad_4_11, jmh_b3_pad_4_12, jmh_b3_pad_4_13, jmh_b3_pad_4_14, jmh_b3_pad_4_15;
        boolean jmh_b3_pad_5, jmh_b3_pad_5_1, jmh_b3_pad_5_2, jmh_b3_pad_5_3, jmh_b3_pad_5_4, jmh_b3_pad_5_5, jmh_b3_pad_5_6, jmh_b3_pad_5_7, jmh_b3_pad_5_8, jmh_b3_pad_5_9, jmh_b3_pad_5_10, jmh_b3_pad_5_11, jmh_b3_pad_5_12, jmh_b3_pad_5_13, jmh_b3_pad_5_14, jmh_b3_pad_5_15;
        boolean jmh_b3_pad_6, jmh_b3_pad_6_1, jmh_b3_pad_6_2, jmh_b3_pad_6_3, jmh_b3_pad_6_4, jmh_b3_pad_6_5, jmh_b3_pad_6_6, jmh_b3_pad_6_7, jmh_b3_pad_6_8, jmh_b3_pad_6_9, jmh_b3_pad_6_10, jmh_b3_pad_6_11, jmh_b3_pad_6_12, jmh_b3_pad_6_13, jmh_b3_pad_6_14, jmh_b3_pad_6_15;
        boolean jmh_b3_pad_7, jmh_b3_pad_7_1, jmh_b3_pad_7_2, jmh_b3_pad_7_3, jmh_b3_pad_7_4, jmh_b3_pad_7_5, jmh_b3_pad_7_6, jmh_b3_pad_7_7, jmh_b3_pad_7_8, jmh_b3_pad_7_9, jmh_b3_pad_7_10, jmh_b3_pad_7_11, jmh_b3_pad_7_12, jmh_b3_pad_7_13, jmh_b3_pad_7_14, jmh_b3_pad_7_15;
        boolean jmh_b3_pad_8, jmh_b3_pad_8_1, jmh_b3_pad_8_2, jmh_b3_pad_8_3, jmh_b3_pad_8_4, jmh_b3_pad_8_5, jmh_b3_pad_8_6, jmh_b3_pad_8_7, jmh_b3_pad_8_8, jmh_b3_pad_8_9, jmh_b3_pad_8_10, jmh_b3_pad_8_11, jmh_b3_pad_8_12, jmh_b3_pad_8_13, jmh_b3_pad_8_14, jmh_b3_pad_8_15;
        boolean jmh_b3_pad_9, jmh_b3_pad_9_1, jmh_b3_pad_9_2, jmh_b3_pad_9_3, jmh_b3_pad_9_4, jmh_b3_pad_9_5, jmh_b3_pad_9_6, jmh_b3_pad_9_7, jmh_b3_pad_9_8, jmh_b3_pad_9_9, jmh_b3_pad_9_10, jmh_b3_pad_9_11, jmh_b3_pad_9_12, jmh_b3_pad_9_13, jmh_b3_pad_9_14, jmh_b3_pad_9_15;
        boolean jmh_b3_pad_10, jmh_b3_pad_10_1, jmh_b3_pad_10_2, jmh_b3_pad_10_3, jmh_b3_pad_10_4, jmh_b3_pad_10_5, jmh_b3_pad_10_6, jmh_b3_pad_10_7, jmh_b3_pad_10_8, jmh_b3_pad_10_9, jmh_b3_pad_10_10, jmh_b3_pad_10_11, jmh_b3_pad_10_12, jmh_b3_pad_10_13, jmh_b3_pad_10_14, jmh_b3_pad_10_15;
        boolean jmh_b3_pad_11, jmh_b3_pad_11_1, jmh_b3_pad_11_2, jmh_b3_pad_11_3, jmh_b3_pad_11_4, jmh_b3_pad_11_5, jmh_b3_pad_11_6, jmh_b3_pad_11_7, jmh_b3_pad_11_8, jmh_b3_pad_11_9, jmh_b3_pad_11_10, jmh_b3_pad_11_11, jmh_b3_pad_11_12, jmh_b3_pad_11_13, jmh_b3_pad_11_14, jmh_b3_pad_11_15;
        boolean jmh_b3_pad_12, jmh_b3_pad_12_1, jmh_b3_pad_12_2, jmh_b3_pad_12_3, jmh_b3_pad_12_4, jmh_b3_pad_12_5, jmh_b3_pad_12_6, jmh_b3_pad_12_7, jmh_b3_pad_12_8, jmh_b3_pad_12_9, jmh_b3_pad_12_10, jmh_b3_pad_12_11, jmh_b3_pad_12_12, jmh_b3_pad_12_13, jmh_b3_pad_12_14, jmh_b3_pad_12_15;
        boolean jmh_b3_pad_13, jmh_b3_pad_13_1, jmh_b3_pad_13_2, jmh_b3_pad_13_3, jmh_b3_pad_13_4, jmh_b3_pad_13_5, jmh_b3_pad_13_6, jmh_b3_pad_13_7, jmh_b3_pad_13_8, jmh_b3_pad_13_9, jmh_b3_pad_13_10, jmh_b3_pad_13_11, jmh_b3_pad_13_12, jmh_b3_pad_13_13, jmh_b3_pad_13_14, jmh_b3_pad_13_15;
        boolean jmh_b3_pad_14, jmh_b3_pad_14_1, jmh_b3_pad_14_2, jmh_b3_pad_14_3, jmh_b3_pad_14_4, jmh_b3_pad_14_5, jmh_b3_pad_14_6, jmh_b3_pad_14_7, jmh_b3_pad_14_8, jmh_b3_pad_14_9, jmh_b3_pad_14_10, jmh_b3_pad_14_11, jmh_b3_pad_14_12, jmh_b3_pad_14_13, jmh_b3_pad_14_14, jmh_b3_pad_14_15;
        boolean jmh_b3_pad_15, jmh_b3_pad_15_1, jmh_b3_pad_15_2, jmh_b3_pad_15_3, jmh_b3_pad_15_4, jmh_b3_pad_15_5, jmh_b3_pad_15_6, jmh_b3_pad_15_7, jmh_b3_pad_15_8, jmh_b3_pad_15_9, jmh_b3_pad_15_10, jmh_b3_pad_15_11, jmh_b3_pad_15_12, jmh_b3_pad_15_13, jmh_b3_pad_15_14, jmh_b3_pad_15_15;
    }
    
    static class BehaviorExecutorBench_1_jmh_B2 extends BehaviorExecutorBench_1_jmh_B1 {
        public volatile int setupTrialMutex;
        public volatile int tearTrialMutex;
        public final static AtomicIntegerFieldUpdater setupTrialMutexUpdater = AtomicIntegerFieldUpdater.newUpdater(BehaviorExecutorBench_1_jmh_B2.class, "setupTrialMutex");
        public final static AtomicIntegerFieldUpdater tearTrialMutexUpdater = AtomicIntegerFieldUpdater.newUpdater(BehaviorExecutorBench_1_jmh_B2.class, "tearTrialMutex");
    
        public volatile int setupIterationMutex;
        public volatile int tearIterationMutex;
        public final static AtomicIntegerFieldUpdater setupIterationMutexUpdater = AtomicIntegerFieldUpdater.newUpdater(BehaviorExecutorBench_1_jmh_B2.class, "setupIterationMutex");
        public final static AtomicIntegerFieldUpdater tearIterationMutexUpdater = AtomicIntegerFieldUpdater.newUpdater(BehaviorExecutorBench_1_jmh_B2.class, "tearIterationMutex");
    
        public volatile int setupInvocationMutex;
        public volatile int tearInvocationMutex;
        public final static AtomicIntegerFieldUpdater setupInvocationMutexUpdater = AtomicIntegerFieldUpdater.newUpdater(BehaviorExecutorBench_1_jmh_B2.class, "setupInvocationMutex");
        public final static AtomicIntegerFieldUpdater tearInvocationMutexUpdater = AtomicIntegerFieldUpdater.newUpdater(BehaviorExecutorBench_1_jmh_B2.class, "tearInvocationMutex");
    
        public boolean readyTrial;
        public boolean readyIteration;
        public boolean readyInvocation;
    }
    
    static class BehaviorExecutorBench_1_jmh_B3 extends BehaviorExecutorBench_1_jmh_B2 {
        boolean jmh_b3_pad_0, jmh_b3_pad_0_1, jmh_b3_pad_0_2, jmh_b3_pad_0_3, jmh_b3_pad_0_4, jmh_b3_pad_0_5, jmh_b3_pad_0_6, jmh_b3_pad_0_7, jmh_b3_pad_0_8, jmh_b3_pad_0_9, jmh_b3_pad_0_10, jmh_b3_pad_0_11, jmh_b3_pad_0_12, jmh_b3_pad_0_13, jmh_b3_pad_0_14, jmh_b3_pad_0_15;
        boolean jmh_b3_pad_1, jmh_b3_pad_1_1, jmh_b3_pad_1_2, jmh_b3_pad_1_3, jmh_b3_pad_1_4, jmh_b3_pad_1_5, jmh_b3_pad_1_6, jmh_b3_pad_1_7, jmh_b3_pad_1_8, jmh_b3_pad_1_9, jmh_b3_pad_1_10, jmh_b3_pad_1_11, jmh_b3_pad_1_12, jmh_b3_pad_1_13, jmh_b3_pad_1_14, jmh_b3_pad_1_15;
        boolean jmh_b3_pad_2, jmh_b3_pad_2_1, jmh_b3_pad_2_2, jmh_b3_pad_2_3, jmh_b3_pad_2_4, jmh_b3_pad_2_5, jmh_b3_pad_2_6, jmh_b3_pad_2_7, jmh_b3_pad_2_8, jmh_b3_pad_2_9, jmh_b3_pad_2_10, jmh_b3_pad_2_11, jmh_b3_pad_2_12, jmh_b3_pad_2_13, jmh_b3_pad_2_14, jmh_b3_pad_2_15;
        boolean jmh_b3_pad_3, jmh_b3_pad_3_1, jmh_b3_pad_3_2, jmh_b3_pad_3_3, jmh_b3_pad_3_4, jmh_b3_pad_3_5, jmh_b3_pad_3_6, jmh_b3_pad_3_7, jmh_b3_pad_3_8, jmh_b3_pad_3_9, jmh_b3_pad_3_10, jmh_b3_pad_3_11, jmh_b3_pad_3_12, jmh_b3_pad_3_13, jmh_b3_pad_3_14, jmh_b3_pad_3_15;
        boolean jmh_b3_pad_4, jmh_b3_pad_4_1, jmh_b3_pad_4_2, jmh_b3_pad_4_3, jmh_b3_pad_4_4, jmh_b3_pad_4_5, jmh_b3_pad_4_6, jmh_b3_pad_4_7, jmh_b3_pad_4_8, jmh_b3_pad_4_9, jmh_b3_pad_4_10, jmh_b3_pad_4_11, jmh_b3_pad_4_12, jmh_b3_pad_4_13, jmh_b3_pad_4_14, jmh_b3_pad_4_15;
        boolean jmh_b3_pad_5, jmh_b3_pad_5_1, jmh_b3_pad_5_2, jmh_b3_pad_5_3, jmh_b3_pad_5_4, jmh_b3_pad_5_5, jmh_b3_pad_5_6, jmh_b3_pad_5_7, jmh_b3_pad_5_8, jmh_b3_pad_5_9, jmh_b3_pad_5_10, jmh_b3_pad_5_11, jmh_b3_pad_5_12, jmh_b3_pad_5_13, jmh_b3_pad_5_14, jmh_b3_pad_5_15;
        boolean jmh_b3_pad_6, jmh_b3_pad_6_1, jmh_b3_pad_6_2, jmh_b3_pad_6_3, jmh_b3_pad_6_4, jmh_b3_pad_6_5, jmh_b3_pad_6_6, jmh_b3_pad_6_7, jmh_b3_pad_6_8, jmh_b3_pad_6_9, jmh_b3_pad_6_10, jmh_b3_pad_6_11, jmh_b3_pad_6_12, jmh_b3_pad_6_13, jmh_b3_pad_6_14, jmh_b3_pad_6_15;
        boolean jmh_b3_pad_7, jmh_b3_pad_7_1, jmh_b3_pad_7_2, jmh_b3_pad_7_3, jmh_b3_pad_7_4, jmh_b3_pad_7_5, jmh_b3_pad_7_6, jmh_b3_pad_7_7, jmh_b3_pad_7_8, jmh_b3_pad_7_9, jmh_b3_pad_7_10, jmh_b3_pad_7_11, jmh_b3_pad_7_12, jmh_b3_pad_7_13, jmh_b3_pad_7_14, jmh_b3_pad_7_15;
        boolean jmh_b3_pad_8, jmh_b3_pad_8_1, jmh_b3_pad_8_2, jmh_b3_pad_8_3, jmh_b3_pad_8_4, jmh_b3_pad_8_5, jmh_b3_pad_8_6, jmh_b3_pad_8_7, jmh_b3_pad_8_8, jmh_b3_pad_8_9, jmh_b3_pad_8_10, jmh_b3_pad_8_11, jmh_b3_pad_8_12, jmh_b3_pad_8_13, jmh_b3_pad_8_14, jmh_b3_pad_8_15;
        boolean jmh_b3_pad_9, jmh_b3_pad_9_1, jmh_b3_pad_9_2, jmh_b3_pad_9_3, jmh_b3_pad_9_4, jmh_b3_pad_9_5, jmh_b3_pad_9_6, jmh_b3_pad_9_7, jmh_b3_pad_9_8, jmh_b3_pad_9_9, jmh_b3_pad_9_10, jmh_b3_pad_9_11, jmh_b3_pad_9_12, jmh_b3_pad_9_13, jmh_b3_pad_9_14, jmh_b3_pad_9_15;
        boolean jmh_b3_pad_10, jmh_b3_pad_10_1, jmh_b3_pad_10_2, jmh_b3_pad_10_3, jmh_b3_pad_10_4, jmh_b3_pad_10_5, jmh_b3_pad_10_6, jmh_b3_pad_10_7, jmh_b3_pad_10_8, jmh_b3_pad_10_9, jmh_b3_pad_10_10, jmh_b3_pad_10_11, jmh_b3_pad_10_12, jmh_b3_pad_10_13, jmh_b3_pad_10_14, jmh_b3_pad_10_15;
        boolean jmh_b3_pad_11, jmh_b3_pad_11_1, jmh_b3_pad_11_2, jmh_b3_pad_11_3, jmh_b3_pad_11_4, jmh_b3_pad_11_5, jmh_b3_pad_11_6, jmh_b3_pad_11_7, jmh_b3_pad_11_8, jmh_b3_pad_11_9, jmh_b3_pad_11_10, jmh_b3_pad_11_11, jmh_b3_pad_11_12, jmh_b3_pad_11_13, jmh_b3_pad_11_14, jmh_b3_pad_11_15;
        boolean jmh_b3_pad_12, jmh_b3_pad_12_1, jmh_b3_pad_12_2, jmh_b3_pad_12_3, jmh_b3_pad_12_4, jmh_b3_pad_12_5, jmh_b3_pad_12_6, jmh_b3_pad_12_7, jmh_b3_pad_12_8, jmh_b3_pad_12_9, jmh_b3_pad_12_10, jmh_b3_pad_12_11, jmh_b3_pad_12_12, jmh_b3_pad_12_13, jmh_b3_pad_12_14, jmh_b3_pad_12_15;
        boolean jmh_b3_pad_13, jmh_b3_pad_13_1, jmh_b3_pad_13_2, jmh_b3_pad_13_3, jmh_b3_pad_13_4, jmh_b3_pad_13_5, jmh_b3_pad_13_6, jmh_b3_pad_13_7, jmh_b3_pad_13_8, jmh_b3_pad_13_9, jmh_b3_pad_13_10, jmh_b3_pad_13_11, jmh_b3_pad_13_12, jmh_b3_pad_13_13, jmh_b3_pad_13_14, jmh_b3_pad_13_15;
        boolean jmh_b3_pad_14, jmh_b3_pad_14_1, jmh_b3_pad_14_2, jmh_b3_pad_14_3, jmh_b3_pad_14_4, jmh_b3_pad_14_5, jmh_b3_pad_14_6, jmh_b3_pad_14_7, jmh_b3_pad_14_8, jmh_b3_pad_14_9, jmh_b3_pad_14_10, jmh_b3_pad_14_11, jmh_b3_pad_14_12, jmh_b3_pad_14_13, jmh_b3_pad_14_14, jmh_b3_pad_14_15;
        boolean jmh_b3_pad_15, jmh_b3_pad_15_1, jmh_b3_pad_15_2, jmh_b3_pad_15_3, jmh_b3_pad_15_4, jmh_b3_pad_15_5, jmh_b3_pad_15_6, jmh_b3_pad_15_7, jmh_b3_pad_15_8, jmh_b3_pad_15_9, jmh_b3_pad_15_10, jmh_b3_pad_15_11, jmh_b3_pad_15_12, jmh_b3_pad_15_13, jmh_b3_pad_15_14, jmh_b3_pad_15_15;
    }
    
    static final class BehaviorExecutorBench_1_jmh extends BehaviorExecutorBench_1_jmh_B3 {
    }
    
    static class BlackHole_1_jmh_B1 extends org.openjdk.jmh.logic.BlackHole {
        boolean jmh_b3_pad_0, jmh_b3_pad_0_1, jmh_b3_pad_0_2, jmh_b3_pad_0_3, jmh_b3_pad_0_4, jmh_b3_pad_0_5, jmh_b3_pad_0_6, jmh_b3_pad_0_7, jmh_b3_pad_0_8, jmh_b3_pad_0_9, jmh_b3_pad_0_10, jmh_b3_pad_0_11, jmh_b3_pad_0_12, jmh_b3_pad_0_13, jmh_b3_pad_0_14, jmh_b3_pad_0_15;
        boolean jmh_b3_pad_1, jmh_b3_pad_1_1, jmh_b3_pad_1_2, jmh_b3_pad_1_3, jmh_b3_pad_1_4, jmh_b3_pad_1_5, jmh_b3_pad_1_6, jmh_b3_pad_1_7, jmh_b3_pad_1_8, jmh_b3_pad_1_9, jmh_b3_pad_1_10, jmh_b3_pad_1_11, jmh_b3_pad_1_12, jmh_b3_pad_1_13, jmh_b3_pad_1_14, jmh_b3_pad_1_15;
        boolean jmh_b3_pad_2, jmh_b3_pad_2_1, jmh_b3_pad_2_2, jmh_b3_pad_2_3, jmh_b3_pad_2_4, jmh_b3_pad_2_5, jmh_b3_pad_2_6, jmh_b3_pad_2_7, jmh_b3_pad_2_8, jmh_b3_pad_2_9, jmh_b3_pad_2_10, jmh_b3_pad_2_11, jmh_b3_pad_2_12, jmh_b3_pad_2_13, jmh_b3_pad_2_14, jmh_b3_pad_2_15;
        boolean jmh_b3_pad_3, jmh_b3_pad_3_1, jmh_b3_pad_3_2, jmh_b3_pad_3_3, jmh_b3_pad_3_4, jmh_b3_pad_3_5, jmh_b3_pad_3_6, jmh_b3_pad_3_7, jmh_b3_pad_3_8, jmh_b3_pad_3_9, jmh_b3_pad_3_10, jmh_b3_pad_3_11, jmh_b3_pad_3_12, jmh_b3_pad_3_13, jmh_b3_pad_3_14, jmh_b3_pad_3_15;
        boolean jmh_b3_pad_4, jmh_b3_pad_4_1, jmh_b3_pad_4_2, jmh_b3_pad_4_3, jmh_b3_pad_4_4, jmh_b3_pad_4_5, jmh_b3_pad_4_6, jmh_b3_pad_4_7, jmh_b3_pad_4_8, jmh_b3_pad_4_9, jmh_b3_pad_4_10, jmh_b3_pad_4_11, jmh_b3_pad_4_12, jmh_b3_pad_4_13, jmh_b3_pad_4_14, jmh_b3_pad_4_15;
        boolean jmh_b3_pad_5, jmh_b3_pad_5_1, jmh_b3_pad_5_2, jmh_b3_pad_5_3, jmh_b3_pad_5_4, jmh_b3_pad_5_5, jmh_b3_pad_5_6, jmh_b3_pad_5_7, jmh_b3_pad_5_8, jmh_b3_pad_5_9, jmh_b3_pad_5_10, jmh_b3_pad_5_11, jmh_b3_pad_5_12, jmh_b3_pad_5_13, jmh_b3_pad_5_14, jmh_b3_pad_5_15;
        boolean jmh_b3_pad_6, jmh_b3_pad_6_1, jmh_b3_pad_6_2, jmh_b3_pad_6_3, jmh_b3_pad_6_4, jmh_b3_pad_6_5, jmh_b3_pad_6_6, jmh_b3_pad_6_7, jmh_b3_pad_6_8, jmh_b3_pad_6_9, jmh_b3_pad_6_10, jmh_b3_pad_6_11, jmh_b3_pad_6_12, jmh_b3_pad_6_13, jmh_b3_pad_6_14, jmh_b3_pad_6_15;
        boolean jmh_b3_pad_7, jmh_b3_pad_7_1, jmh_b3_pad_7_2, jmh_b3_pad_7_3, jmh_b3_pad_7_4, jmh_b3_pad_7_5, jmh_b3_pad_7_6, jmh_b3_pad_7_7, jmh_b3_pad_7_8, jmh_b3_pad_7_9, jmh_b3_pad_7_10, jmh_b3_pad_7_11, jmh_b3_pad_7_12, jmh_b3_pad_7_13, jmh_b3_pad_7_14, jmh_b3_pad_7_15;
        boolean jmh_b3_pad_8, jmh_b3_pad_8_1, jmh_b3_pad_8_2, jmh_b3_pad_8_3, jmh_b3_pad_8_4, jmh_b3_pad_8_5, jmh_b3_pad_8_6, jmh_b3_pad_8_7, jmh_b3_pad_8_8, jmh_b3_pad_8_9, jmh_b3_pad_8_10, jmh_b3_pad_8_11, jmh_b3_pad_8_12, jmh_b3_pad_8_13, jmh_b3_pad_8_14, jmh_b3_pad_8_15;
        boolean jmh_b3_pad_9, jmh_b3_pad_9_1, jmh_b3_pad_9_2, jmh_b3_pad_9_3, jmh_b3_pad_9_4, jmh_b3_pad_9_5, jmh_b3_pad_9_6, jmh_b3_pad_9_7, jmh_b3_pad_9_8, jmh_b3_pad_9_9, jmh_b3_pad_9_10, jmh_b3_pad_9_11, jmh_b3_pad_9_12, jmh_b3_pad_9_13, jmh_b3_pad_9_14, jmh_b3_pad_9_15;
        boolean jmh_b3_pad_10, jmh_b3_pad_10_1, jmh_b3_pad_10_2, jmh_b3_pad_10_3, jmh_b3_pad_10_4, jmh_b3_pad_10_5, jmh_b3_pad_10_6, jmh_b3_pad_10_7, jmh_b3_pad_10_8, jmh_b3_pad_10_9, jmh_b3_pad_10_10, jmh_b3_pad_10_11, jmh_b3_pad_10_12, jmh_b3_pad_10_13, jmh_b3_pad_10_14, jmh_b3_pad_10_15;
        boolean jmh_b3_pad_11, jmh_b3_pad_11_1, jmh_b3_pad_11_2, jmh_b3_pad_11_3, jmh_b3_pad_11_4, jmh_b3_pad_11_5, jmh_b3_pad_11_6, jmh_b3_pad_11_7, jmh_b3_pad_11_8, jmh_b3_pad_11_9, jmh_b3_pad_11_10, jmh_b3_pad_11_11, jmh_b3_pad_11_12, jmh_b3_pad_11_13, jmh_b3_pad_11_14, jmh_b3_pad_11_15;
        boolean jmh_b3_pad_12, jmh_b3_pad_12_1, jmh_b3_pad_12_2, jmh_b3_pad_12_3, jmh_b3_pad_12_4, jmh_b3_pad_12_5, jmh_b3_pad_12_6, jmh_b3_pad_12_7, jmh_b3_pad_12_8, jmh_b3_pad_12_9, jmh_b3_pad_12_10, jmh_b3_pad_12_11, jmh_b3_pad_12_12, jmh_b3_pad_12_13, jmh_b3_pad_12_14, jmh_b3_pad_12_15;
        boolean jmh_b3_pad_13, jmh_b3_pad_13_1, jmh_b3_pad_13_2, jmh_b3_pad_13_3, jmh_b3_pad_13_4, jmh_b3_pad_13_5, jmh_b3_pad_13_6, jmh_b3_pad_13_7, jmh_b3_pad_13_8, jmh_b3_pad_13_9, jmh_b3_pad_13_10, jmh_b3_pad_13_11, jmh_b3_pad_13_12, jmh_b3_pad_13_13, jmh_b3_pad_13_14, jmh_b3_pad_13_15;
        boolean jmh_b3_pad_14, jmh_b3_pad_14_1, jmh_b3_pad_14_2, jmh_b3_pad_14_3, jmh_b3_pad_14_4, jmh_b3_pad_14_5, jmh_b3_pad_14_6, jmh_b3_pad_14_7, jmh_b3_pad_14_8, jmh_b3_pad_14_9, jmh_b3_pad_14_10, jmh_b3_pad_14_11, jmh_b3_pad_14_12, jmh_b3_pad_14_13, jmh_b3_pad_14_14, jmh_b3_pad_14_15;
        boolean jmh_b3_pad_15, jmh_b3_pad_15_1, jmh_b3_pad_15_2, jmh_b3_pad_15_3, jmh_b3_pad_15_4, jmh_b3_pad_15_5, jmh_b3_pad_15_6, jmh_b3_pad_15_7, jmh_b3_pad_15_8, jmh_b3_pad_15_9, jmh_b3_pad_15_10, jmh_b3_pad_15_11, jmh_b3_pad_15_12, jmh_b3_pad_15_13, jmh_b3_pad_15_14, jmh_b3_pad_15_15;
    }
    
    static class BlackHole_1_jmh_B2 extends BlackHole_1_jmh_B1 {
        public volatile int setupTrialMutex;
        public volatile int tearTrialMutex;
        public final static AtomicIntegerFieldUpdater setupTrialMutexUpdater = AtomicIntegerFieldUpdater.newUpdater(BlackHole_1_jmh_B2.class, "setupTrialMutex");
        public final static AtomicIntegerFieldUpdater tearTrialMutexUpdater = AtomicIntegerFieldUpdater.newUpdater(BlackHole_1_jmh_B2.class, "tearTrialMutex");
    
        public volatile int setupIterationMutex;
        public volatile int tearIterationMutex;
        public final static AtomicIntegerFieldUpdater setupIterationMutexUpdater = AtomicIntegerFieldUpdater.newUpdater(BlackHole_1_jmh_B2.class, "setupIterationMutex");
        public final static AtomicIntegerFieldUpdater tearIterationMutexUpdater = AtomicIntegerFieldUpdater.newUpdater(BlackHole_1_jmh_B2.class, "tearIterationMutex");
    
        public volatile int setupInvocationMutex;
        public volatile int tearInvocationMutex;
        public final static AtomicIntegerFieldUpdater setupInvocationMutexUpdater = AtomicIntegerFieldUpdater.newUpdater(BlackHole_1_jmh_B2.class, "setupInvocationMutex");
        public final static AtomicIntegerFieldUpdater tearInvocationMutexUpdater = AtomicIntegerFieldUpdater.newUpdater(BlackHole_1_jmh_B2.class, "tearInvocationMutex");
    
        public boolean readyTrial;
        public boolean readyIteration;
        public boolean readyInvocation;
    }
    
    static class BlackHole_1_jmh_B3 extends BlackHole_1_jmh_B2 {
        boolean jmh_b3_pad_0, jmh_b3_pad_0_1, jmh_b3_pad_0_2, jmh_b3_pad_0_3, jmh_b3_pad_0_4, jmh_b3_pad_0_5, jmh_b3_pad_0_6, jmh_b3_pad_0_7, jmh_b3_pad_0_8, jmh_b3_pad_0_9, jmh_b3_pad_0_10, jmh_b3_pad_0_11, jmh_b3_pad_0_12, jmh_b3_pad_0_13, jmh_b3_pad_0_14, jmh_b3_pad_0_15;
        boolean jmh_b3_pad_1, jmh_b3_pad_1_1, jmh_b3_pad_1_2, jmh_b3_pad_1_3, jmh_b3_pad_1_4, jmh_b3_pad_1_5, jmh_b3_pad_1_6, jmh_b3_pad_1_7, jmh_b3_pad_1_8, jmh_b3_pad_1_9, jmh_b3_pad_1_10, jmh_b3_pad_1_11, jmh_b3_pad_1_12, jmh_b3_pad_1_13, jmh_b3_pad_1_14, jmh_b3_pad_1_15;
        boolean jmh_b3_pad_2, jmh_b3_pad_2_1, jmh_b3_pad_2_2, jmh_b3_pad_2_3, jmh_b3_pad_2_4, jmh_b3_pad_2_5, jmh_b3_pad_2_6, jmh_b3_pad_2_7, jmh_b3_pad_2_8, jmh_b3_pad_2_9, jmh_b3_pad_2_10, jmh_b3_pad_2_11, jmh_b3_pad_2_12, jmh_b3_pad_2_13, jmh_b3_pad_2_14, jmh_b3_pad_2_15;
        boolean jmh_b3_pad_3, jmh_b3_pad_3_1, jmh_b3_pad_3_2, jmh_b3_pad_3_3, jmh_b3_pad_3_4, jmh_b3_pad_3_5, jmh_b3_pad_3_6, jmh_b3_pad_3_7, jmh_b3_pad_3_8, jmh_b3_pad_3_9, jmh_b3_pad_3_10, jmh_b3_pad_3_11, jmh_b3_pad_3_12, jmh_b3_pad_3_13, jmh_b3_pad_3_14, jmh_b3_pad_3_15;
        boolean jmh_b3_pad_4, jmh_b3_pad_4_1, jmh_b3_pad_4_2, jmh_b3_pad_4_3, jmh_b3_pad_4_4, jmh_b3_pad_4_5, jmh_b3_pad_4_6, jmh_b3_pad_4_7, jmh_b3_pad_4_8, jmh_b3_pad_4_9, jmh_b3_pad_4_10, jmh_b3_pad_4_11, jmh_b3_pad_4_12, jmh_b3_pad_4_13, jmh_b3_pad_4_14, jmh_b3_pad_4_15;
        boolean jmh_b3_pad_5, jmh_b3_pad_5_1, jmh_b3_pad_5_2, jmh_b3_pad_5_3, jmh_b3_pad_5_4, jmh_b3_pad_5_5, jmh_b3_pad_5_6, jmh_b3_pad_5_7, jmh_b3_pad_5_8, jmh_b3_pad_5_9, jmh_b3_pad_5_10, jmh_b3_pad_5_11, jmh_b3_pad_5_12, jmh_b3_pad_5_13, jmh_b3_pad_5_14, jmh_b3_pad_5_15;
        boolean jmh_b3_pad_6, jmh_b3_pad_6_1, jmh_b3_pad_6_2, jmh_b3_pad_6_3, jmh_b3_pad_6_4, jmh_b3_pad_6_5, jmh_b3_pad_6_6, jmh_b3_pad_6_7, jmh_b3_pad_6_8, jmh_b3_pad_6_9, jmh_b3_pad_6_10, jmh_b3_pad_6_11, jmh_b3_pad_6_12, jmh_b3_pad_6_13, jmh_b3_pad_6_14, jmh_b3_pad_6_15;
        boolean jmh_b3_pad_7, jmh_b3_pad_7_1, jmh_b3_pad_7_2, jmh_b3_pad_7_3, jmh_b3_pad_7_4, jmh_b3_pad_7_5, jmh_b3_pad_7_6, jmh_b3_pad_7_7, jmh_b3_pad_7_8, jmh_b3_pad_7_9, jmh_b3_pad_7_10, jmh_b3_pad_7_11, jmh_b3_pad_7_12, jmh_b3_pad_7_13, jmh_b3_pad_7_14, jmh_b3_pad_7_15;
        boolean jmh_b3_pad_8, jmh_b3_pad_8_1, jmh_b3_pad_8_2, jmh_b3_pad_8_3, jmh_b3_pad_8_4, jmh_b3_pad_8_5, jmh_b3_pad_8_6, jmh_b3_pad_8_7, jmh_b3_pad_8_8, jmh_b3_pad_8_9, jmh_b3_pad_8_10, jmh_b3_pad_8_11, jmh_b3_pad_8_12, jmh_b3_pad_8_13, jmh_b3_pad_8_14, jmh_b3_pad_8_15;
        boolean jmh_b3_pad_9, jmh_b3_pad_9_1, jmh_b3_pad_9_2, jmh_b3_pad_9_3, jmh_b3_pad_9_4, jmh_b3_pad_9_5, jmh_b3_pad_9_6, jmh_b3_pad_9_7, jmh_b3_pad_9_8, jmh_b3_pad_9_9, jmh_b3_pad_9_10, jmh_b3_pad_9_11, jmh_b3_pad_9_12, jmh_b3_pad_9_13, jmh_b3_pad_9_14, jmh_b3_pad_9_15;
        boolean jmh_b3_pad_10, jmh_b3_pad_10_1, jmh_b3_pad_10_2, jmh_b3_pad_10_3, jmh_b3_pad_10_4, jmh_b3_pad_10_5, jmh_b3_pad_10_6, jmh_b3_pad_10_7, jmh_b3_pad_10_8, jmh_b3_pad_10_9, jmh_b3_pad_10_10, jmh_b3_pad_10_11, jmh_b3_pad_10_12, jmh_b3_pad_10_13, jmh_b3_pad_10_14, jmh_b3_pad_10_15;
        boolean jmh_b3_pad_11, jmh_b3_pad_11_1, jmh_b3_pad_11_2, jmh_b3_pad_11_3, jmh_b3_pad_11_4, jmh_b3_pad_11_5, jmh_b3_pad_11_6, jmh_b3_pad_11_7, jmh_b3_pad_11_8, jmh_b3_pad_11_9, jmh_b3_pad_11_10, jmh_b3_pad_11_11, jmh_b3_pad_11_12, jmh_b3_pad_11_13, jmh_b3_pad_11_14, jmh_b3_pad_11_15;
        boolean jmh_b3_pad_12, jmh_b3_pad_12_1, jmh_b3_pad_12_2, jmh_b3_pad_12_3, jmh_b3_pad_12_4, jmh_b3_pad_12_5, jmh_b3_pad_12_6, jmh_b3_pad_12_7, jmh_b3_pad_12_8, jmh_b3_pad_12_9, jmh_b3_pad_12_10, jmh_b3_pad_12_11, jmh_b3_pad_12_12, jmh_b3_pad_12_13, jmh_b3_pad_12_14, jmh_b3_pad_12_15;
        boolean jmh_b3_pad_13, jmh_b3_pad_13_1, jmh_b3_pad_13_2, jmh_b3_pad_13_3, jmh_b3_pad_13_4, jmh_b3_pad_13_5, jmh_b3_pad_13_6, jmh_b3_pad_13_7, jmh_b3_pad_13_8, jmh_b3_pad_13_9, jmh_b3_pad_13_10, jmh_b3_pad_13_11, jmh_b3_pad_13_12, jmh_b3_pad_13_13, jmh_b3_pad_13_14, jmh_b3_pad_13_15;
        boolean jmh_b3_pad_14, jmh_b3_pad_14_1, jmh_b3_pad_14_2, jmh_b3_pad_14_3, jmh_b3_pad_14_4, jmh_b3_pad_14_5, jmh_b3_pad_14_6, jmh_b3_pad_14_7, jmh_b3_pad_14_8, jmh_b3_pad_14_9, jmh_b3_pad_14_10, jmh_b3_pad_14_11, jmh_b3_pad_14_12, jmh_b3_pad_14_13, jmh_b3_pad_14_14, jmh_b3_pad_14_15;
        boolean jmh_b3_pad_15, jmh_b3_pad_15_1, jmh_b3_pad_15_2, jmh_b3_pad_15_3, jmh_b3_pad_15_4, jmh_b3_pad_15_5, jmh_b3_pad_15_6, jmh_b3_pad_15_7, jmh_b3_pad_15_8, jmh_b3_pad_15_9, jmh_b3_pad_15_10, jmh_b3_pad_15_11, jmh_b3_pad_15_12, jmh_b3_pad_15_13, jmh_b3_pad_15_14, jmh_b3_pad_15_15;
    }
    
    static final class BlackHole_1_jmh extends BlackHole_1_jmh_B3 {
    }
    

}

