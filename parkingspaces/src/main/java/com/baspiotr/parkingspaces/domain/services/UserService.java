package com.baspiotr.parkingspaces.domain.services;

import java.math.BigDecimal;

public interface UserService {

    boolean startParkingMeter(int userId);

    boolean stopParkingMeter(int userId);

    BigDecimal fee(int userId);

    boolean isTimerStartedForUser(int userId);

    BigDecimal allDayEarnings();
}
