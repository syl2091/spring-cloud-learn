package com.lege.java8;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;

/**
 * @author lege
 * @Description
 * @create 2022-08-17 10:27
 */
public class Java8MaxMinInArrUnitTest {
    @Test
    public void whenArrayIsOfIntegerThenMinUsesIntegerComparator() {
        int[] integers = new int[] { 20, 98, 12, 7, 35 };

        int min = Arrays.stream(integers)
                .max()
                .getAsInt();

        assertEquals(98, min);
    }


    @Test
    public void whenArrayIsOfCustomTypeThenMaxUsesCustomComparator() {
        Car porsche = new Car("Porsche 959", 319);
        Car ferrari = new Car("Ferrari 288 GTO", 303);
        Car bugatti = new Car("Bugatti Veyron 16.4 Super Sport", 415);
        Car mcLaren = new Car("McLaren F1", 355);
        Car[] fastCars = { porsche, ferrari, bugatti, mcLaren };

        Car maxBySpeed = Arrays.stream(fastCars)
                .max(Comparator.comparing(Car::getTopSpeed))
                .orElseThrow(NoSuchElementException::new);

        assertEquals(bugatti, maxBySpeed);
    }
}
