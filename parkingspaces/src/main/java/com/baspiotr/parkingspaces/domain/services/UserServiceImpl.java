package com.baspiotr.parkingspaces.domain.services;

import com.baspiotr.parkingspaces.domain.model.Parking;
import com.baspiotr.parkingspaces.domain.model.User;
import com.baspiotr.parkingspaces.domain.repository.ParkingRepository;
import com.baspiotr.parkingspaces.domain.repository.UserRepository;
import com.baspiotr.parkingspaces.domain.utils.Fee;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl implements UserService {

    private final ParkingRepository parkingRepository;
    private final UserRepository userRepository;

    //todo 1) As a driver, I want to start the parking meter, so I don’t have to pay the fine for the invalid parking.

    public boolean startParkingMeter(int userId) {

        User user = userRepository.findOne(userId);

        if (user == null) {
            return false;
        }

        Parking parking = parkingRepository.findAll().get(0);

        user.getDriverParkingTime().start();

        if (!parking.getDrivers().contains(user)) {
            parking.getDrivers().add(user);
        }

        return true;
    }

    //todo 3) As a driver, I want to stop the parking meter, so that I pay only for the actual parking time

    public boolean stopParkingMeter(int userId) {

        User user = userRepository.findOne(userId);

        if (user == null) {
            return false;
        } else if (user.getDriverParkingTime().isStarted() == false) {
            return false;
        }

        user.getDriverParkingTime().end();

        return true;
    }

    //todo 4) As a driver, I want to know how much I have to pay for parking.

    public String getFeeFor(int userId) {

        User user = userRepository.findOne(userId);

        if (user == null) {
            throw new RuntimeException();
        }

        long hours = user.getDriverParkingTime().getHours();

        BigDecimal feeAmount = Fee.calculateFee(user.getRole(), new BigDecimal(hours));

        String result = "Opłata dla użytkownika o id: " + userId + " wynosi: " + feeAmount.toString();

        return result;
    }

}
