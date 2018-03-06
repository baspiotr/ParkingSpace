package com.baspiotr.parkingspaces.domain.model;

import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

public class DriverParkingTimeTest {

    @Test
    public void testGetHours() {
        DriverParkingTime driverParkingTime = new DriverParkingTime();
        driverParkingTime.start();
        LocalDateTime tempEndTime = LocalDateTime.now().plusHours(2);
        driverParkingTime.endTime = tempEndTime;

        assertEquals("Number of hours between start and endTime time", 2, driverParkingTime.getHours());
    }



}
