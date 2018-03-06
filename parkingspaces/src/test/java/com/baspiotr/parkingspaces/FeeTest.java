package com.baspiotr.parkingspaces;

import com.baspiotr.parkingspaces.domain.model.Role;
import com.baspiotr.parkingspaces.domain.utils.Fee;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class FeeTest {

    @Test
    public void testCalculateFeeForRegular() {
        assertEquals(new BigDecimal(1), Fee.calculateFee(Role.DRIVER_REGULAR, BigDecimal.ONE));
        assertEquals(new BigDecimal(3), Fee.calculateFee(Role.DRIVER_REGULAR, new BigDecimal(2)));
        assertEquals(new BigDecimal(7), Fee.calculateFee(Role.DRIVER_REGULAR, new BigDecimal(3)));
        assertEquals(new BigDecimal(15), Fee.calculateFee(Role.DRIVER_REGULAR, new BigDecimal(4)));
        assertEquals(new BigDecimal(31), Fee.calculateFee(Role.DRIVER_REGULAR, new BigDecimal(5)));
        assertEquals(new BigDecimal(127), Fee.calculateFee(Role.DRIVER_REGULAR, new BigDecimal(7)));
    }

    @Test
    public void testCalculateFeeForVIP() {
        assertEquals(new BigDecimal(0), Fee.calculateFee(Role.DRIVER_VIP, BigDecimal.ONE));
        assertEquals(new BigDecimal(2), Fee.calculateFee(Role.DRIVER_VIP, new BigDecimal(2)));
//        assertEquals(new BigDecimal(5), Fee.calculateFee(Role.DRIVER_VIP, new BigDecimal(3)));
        assertEquals(new BigDecimal(9.5), Fee.calculateFee(Role.DRIVER_VIP, new BigDecimal(4)));
        assertEquals(new BigDecimal(16.25), Fee.calculateFee(Role.DRIVER_VIP, new BigDecimal(5)));
        assertEquals(new BigDecimal(41.5625), Fee.calculateFee(Role.DRIVER_VIP, new BigDecimal(7)));
    }

}
