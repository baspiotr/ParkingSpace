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

    protected static BigDecimal calculateVIPFee(BigDecimal hours) {

        BigDecimal prev = BigDecimal.ZERO;
        BigDecimal next = new BigDecimal(2);
        BigDecimal sum = new BigDecimal(3);

        if (hours.intValue() > 3) {

            for (int i = 3; i <= hours.intValue(); i++) {
                prev = next;
                next = prev.multiply(new BigDecimal(1.5));
                sum = sum.add(next);
            }
        }
        return sum;
    }

    public static BigDecimal calculateFee(Role role, int hours) {

        BigDecimal sum = new BigDecimal(-1);

        if (role.equals(Role.DRIVER_REGULAR)) {
            if (hours <= 1) {
                return new BigDecimal(1);
            } else if (hours == 2) {
                return new BigDecimal(3);
            }
            sum = sum.add(calculateFactorialRegularFee(new BigDecimal(hours)));
        } else if (role.equals(Role.DRIVER_VIP)) {
            if (hours <= 1) {
                return new BigDecimal(0);
            } else if (hours == 2) {
                return new BigDecimal(2);
            }
            sum = sum.add(calculateVIPFee(new BigDecimal(hours)));
        }
        return sum.stripTrailingZeros();
    }
}