package com.lege.jmh;

import com.lege.jmh.warmup.dummy.Dummy;
import org.openjdk.jmh.annotations.Benchmark;

/**
 * @author lege
 * @Description
 * @create 2022-08-25 15:06
 */
public class BenchMark {
    @Benchmark
    public void init(){
        Dummy d = new Dummy();
        d.m();
    }
}
