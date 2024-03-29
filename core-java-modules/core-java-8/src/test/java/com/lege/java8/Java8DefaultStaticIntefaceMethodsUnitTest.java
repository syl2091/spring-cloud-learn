package com.lege.java8;


import com.lege.java_8_features.Vehicle;
import com.lege.java_8_features.VehicleImpl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author lege
 * @Description
 * @create 2022-08-16 13:57
 */
public class Java8DefaultStaticIntefaceMethodsUnitTest {
    @Test
    public void callStaticInterfaceMethdosMethods_whenExpectedResults_thenCorrect() {
        Vehicle vehicle = new VehicleImpl();
        String overview = vehicle.getOverview();
        long[] startPosition = vehicle.startPosition();

        assertEquals(overview, "ATV made by N&F Vehicles");
        assertEquals(startPosition[0], 23);
        assertEquals(startPosition[1], 15);
    }


    @Test
    public void callDefaultInterfaceMethods_whenExpectedResults_thenCorrect() {
        String producer = Vehicle.producer();
        assertEquals(producer, "N&F Vehicles");
    }

}
