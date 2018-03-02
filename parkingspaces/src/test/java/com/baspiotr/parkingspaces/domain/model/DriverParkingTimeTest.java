package com.baspiotr.parkingspaces.domain.model;

import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

public class DriverParkingTimeTest {

    @Test
    public void testGetHours() {
        DriverParkingTime driverParkingTime = new DriverParkingTime();
        driverParkingTime.startTime();
        LocalDateTime tempEndTime = LocalDateTime.now().plusHours(2);
        driverParkingTime.end = tempEndTime;

        assertEquals("Number of hours between start and end time", 2, driverParkingTime.getHours());
    }

    @Test
    public void testFeeCalculation() {


        long hours = 4;



    }


}
