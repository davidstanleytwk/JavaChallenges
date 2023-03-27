package com.stanley;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
public class MissingPositiveBenchmark
{
    static MissingPositive mpHeap = MissingPostiveFactory.getMissPositiveClass("heap");
    static MissingPositive mpSol = MissingPostiveFactory.getMissPositiveClass("solution");

    static MissingPositive mpArray = MissingPostiveFactory.getMissPositiveClass("arrays");
    private static final int[] in= new int[]{0,-1,-2,-100,-45,-23,-12,-33,-21,-5,-66,-77,-12,-13,-15,-15,-16,-18,-62,-4,-45,-23,-12,-33,21,5,66,77,12,13,15,15,16,18,62,4,45,23,12,33,21,5,66,77,12,13,15,15,16,18,62,4,45,23,12,33,21,5,66,77,12,13,15,15,16,18,62,4,45,23,12,33,21,5,66,77,12,13,15,15,16,18,62,4};

    @Benchmark @BenchmarkMode(Mode.Throughput)
    @Fork(value = 1, warmups = 0)
    @Warmup(iterations = 0)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void simpleHeap(Blackhole bh)
    {

        int i = mpHeap.firstMissingPositive(in);
        bh.consume(i);
    }


    @Benchmark @BenchmarkMode(Mode.Throughput)
    @Fork(value = 1, warmups = 0)
    @Warmup(iterations = 0 )
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void simpleSolution(Blackhole bh)
    {

        int i = mpSol.firstMissingPositive(in);
        bh.consume(i);
    }


    @Benchmark @BenchmarkMode(Mode.Throughput)
    @Fork(value = 1, warmups = 0)
    @Warmup(iterations = 0 )
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void simpleArray(Blackhole bh)
    {

        int i = mpArray.firstMissingPositive(in);
        bh.consume(i);
    }


}
