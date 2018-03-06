package com.baspiotr.parkingspaces.domain.utils;

import com.baspiotr.parkingspaces.domain.model.Role;

import java.math.BigDecimal;

public class Fee {

    protected static BigDecimal calculateFactorialRegularFee(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) == 0) {
            return BigDecimal.ONE;
        } else {
            BigDecimal regularFeeMultiplier = new BigDecimal(2);
            return regularFeeMultiplier.multiply(calculateFactorialRegularFee(amount.subtract(BigDecimal.ONE)));
        }
    }

    protected static BigDecimal calculateFactorialVIPFee(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) == 0) {
            return BigDecimal.ONE;
        } else {
            BigDecimal multiplier = new BigDecimal(1.5);
            return multiplier.multiply(calculateFactorialVIPFee(amount.subtract(BigDecimal.ONE)));
        }
    }

    public static BigDecimal calculateFee(Role role, BigDecimal hours) {


        BigDecimal sum = new BigDecimal(-1);

        System.out.println("Hours = " + hours.toString());

        if (role.equals(Role.DRIVER_REGULAR)) {
            if (hours.intValue() <= 1) {
                return new BigDecimal(1);
            } else if (hours.intValue() == 2) {
                return new BigDecimal(3);
            }
            sum = sum.add(calculateFactorialRegularFee(hours));
        } else if (role.equals(Role.DRIVER_VIP)) {
            if (hours.intValue() <= 1) {
                return new BigDecimal(0);
            } else if (hours.intValue() == 2) {
                return new BigDecimal(2);
            }
            sum = sum.add(calculateFactorialVIPFee(hours));
        }
        return sum;
    }
}