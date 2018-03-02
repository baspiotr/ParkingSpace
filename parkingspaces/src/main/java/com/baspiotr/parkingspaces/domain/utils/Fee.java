package com.baspiotr.parkingspaces.domain.utils;

import com.baspiotr.parkingspaces.domain.model.Role;

public class Fee {

    private static double feeRegular(double n) {
        if (n == 0)
            return 1;
        else
            return (2 * feeRegular(n - 1));
    }

    private static double feeVIP(double n) {
        if (n == 0)
            return 1;
        else
            return (1.5 * feeVIP(n - 1));
    }

    public static double calculateFee(Role role, double hours) {

        double sum = 3;

        if (role.equals(Role.DRIVER_REGULAR)) {
            if (hours <= 1) {
                return 1;
            } else if (hours == 2) {
                return 3;
            }
            sum += feeRegular(hours);
        } else if (role.equals(Role.DRIVER_VIP)) {
            if (hours <= 1) {
                return 0;
            } else if (hours == 2) {
                return 3;
            }
            sum += feeVIP(hours);
        }

        return sum;
    }

}
