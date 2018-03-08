package com.baspiotr.parkingspaces.domain.model;

import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

public class UserTest {

    @Test
    public void testGetHours() {
        User driver = User.builder().firstName("Piotr").lastName("Basinski").role(Role.DRIVER_REGULAR).build();
        driver.setStartTime(LocalDateTime.now());
        LocalDateTime tempEndTime = LocalDateTime.now().plusHours(2);
        driver.setEndTime(tempEndTime);
        assertEquals("Number of hours between start and endTime time", 2, driver.getHours());
    }
}
