package com.lege.jmh.warmup;

import com.lege.jmh.warmup.dummy.Dummy;

/**
 * @author lege
 * @Description
 * @create 2022-08-25 14:59
 */
public class ManualClassLoader {
    public static void load(){
        for (int i = 0; i < 1000; i++) {
            Dummy d = new Dummy();
            d.m();
        }
    }
}
