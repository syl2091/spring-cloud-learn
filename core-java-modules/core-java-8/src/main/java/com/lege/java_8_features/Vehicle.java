package com.lege.java_8_features;

public interface Vehicle {

    void moveTo(long altitude, long longitude);

    /**java8之后接口具有静态方法*/
    static String producer() {
        return "N&F Vehicles";
    }

    /**java8之后接口具有默认方法*/
    default long[] startPosition() {
        return new long[] { 23, 15 };
    }

    default String getOverview() {
        return "ATV made by " + producer();
    }
}
