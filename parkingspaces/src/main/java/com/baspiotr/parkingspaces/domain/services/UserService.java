package com.baspiotr.parkingspaces.domain.services;

public interface UserService {

    boolean startParkingMeter(int userId);

    boolean stopParkingMeter(int userId);

    String getFeeFor(int userId);
}
