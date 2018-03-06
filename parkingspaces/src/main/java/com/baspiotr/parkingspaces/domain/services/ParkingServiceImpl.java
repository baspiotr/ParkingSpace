package com.baspiotr.parkingspaces.domain.services;

import com.baspiotr.parkingspaces.domain.model.Parking;
import com.baspiotr.parkingspaces.domain.model.User;
import com.baspiotr.parkingspaces.domain.repository.ParkingRepository;
import com.baspiotr.parkingspaces.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ParkingServiceImpl implements ParkingService {

    private final ParkingRepository parkingRepository;
    private final UserRepository userRepository;

    //todo 2) As a parking operator, I want to check if the vehicle has started the parking meter

    public boolean isCarStartedParkingMeterByUserId(int userId) {

        User user = userRepository.findOne(userId);
        return user.getDriverParkingTime().isStarted();
    }

    //todo 5) As a parking owner, I want to know how much money was earned during a given day.

    public double allDayEarnings() {

//        BigDecimal sumOfEarnings = new BigDecimal(0);
//
//        for (User user : userRepository.findAll()) {
//            long hours = user.getDriverParkingTime().getHours();
//            double fee = Fee.calculateFee(user.getRole(), hours);
//
//        sumOfEarnings.add(fee);
//        }
//
//
//        return sumOfEarnings;
        return 0;
    }

}
