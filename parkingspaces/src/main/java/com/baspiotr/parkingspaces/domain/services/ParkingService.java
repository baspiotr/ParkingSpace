package com.baspiotr.parkingspaces.domain.services;

public interface ParkingService {

    boolean isCarStartedParkingMeterByUserId(int userId);

    double allDayEarnings();


}
