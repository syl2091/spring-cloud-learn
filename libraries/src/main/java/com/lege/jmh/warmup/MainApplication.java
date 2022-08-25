package com.lege.jmh.warmup;

/**
 * @author lege
 * @Description
 * @create 2022-08-25 15:00
 */
public class MainApplication {

    static {
        long start = System.nanoTime();
        ManualClassLoader.load();
        long end = System.nanoTime();
        System.out.println("Warm Up time : " + (end - start));
    }


    public static void main(String[] args) {
        long start = System.nanoTime();
        ManualClassLoader.load();
        long end = System.nanoTime();
        System.out.println("Total time taken : " + (end - start));
    }
}
