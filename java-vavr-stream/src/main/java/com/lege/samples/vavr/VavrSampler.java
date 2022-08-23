package com.lege.samples.vavr;

import io.vavr.collection.Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author lege
 * @Description
 * @create 2022-08-23 13:43
 */
public class VavrSampler {
    static int[] intArray = new int[]{1, 2, 4};
    static List<Integer> intList = new ArrayList<Integer>();
    static int[][] intOfInts = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

    public static void main(String[] args) {
        //vavrStreamElementAccess();
        //vavrParallelStreamAccess();
        jdkFlatMapping();
    }
    public static void vavrStreamElementAccess() {
        System.out.println("Vavr Element Access");
        System.out.println("====================================");
        Stream<Integer> vavredStream = Stream.ofAll(intArray);
        System.out.println("Vavr index access: " + vavredStream.get(2));
        System.out.println("Vavr head element access: " + vavredStream.get());

        Stream<String> vavredStringStream = Stream.of("foo", "bar", "baz");
        System.out.println("Find foo " + vavredStringStream.indexOf("foo"));
    }

    public static void vavrParallelStreamAccess() {
        try {
            System.out.println("Vavr Stream Concurrent Modification");
            System.out.println("====================================");
            Stream<Integer> vavrStream = Stream.ofAll(intList);
            intList.add(5);
            vavrStream.forEach(i -> System.out.println("in a Vavr Stream: " + i));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        Stream<Integer> wrapped = Stream.ofAll(intArray);
        intArray[2] = 5;
        wrapped.forEach(i -> System.out.println("Vavr looped " + i));
    }

    public static void jdkFlatMapping() {
        System.out.println("JDK FlatMap -> Uncomment line 68 to test");
        System.out.println("====================================");
        int[][] intOfInts = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        IntStream mapToInt = Arrays.stream(intOfInts)
                .map(intArr -> Arrays.stream(intArr))
                .flatMapToInt(val -> val.map(n -> {
                    return n * n;
                }))
                .peek(n -> System.out.println("Peeking at " + n));
        //Uncomment to execute pipeline
        //mapToInt.forEach(n -> System.out.println("FlatMapped Result "+n));
    }
}

