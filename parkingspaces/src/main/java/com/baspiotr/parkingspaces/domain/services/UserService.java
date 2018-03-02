package com.baspiotr.parkingspaces.domain.services;

import com.baspiotr.parkingspaces.domain.model.Parking;
import com.baspiotr.parkingspaces.domain.model.User;
import com.baspiotr.parkingspaces.domain.repository.ParkingRepository;
import com.baspiotr.parkingspaces.domain.repository.UserRepository;
import com.baspiotr.parkingspaces.domain.utils.Fee;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserService {

    private final ParkingRepository parkingRepository;
    private final UserRepository userRepository;

    //todo 1) As a driver, I want to start the parking meter, so I don’t have to pay the fine for the invalid parking.

    public void startParkingMeter(int userId) {

        User user = userRepository.findOne(userId);
        Parking parking = parkingRepository.findAll().get(0);

        user.getDriverParkingTime().startTime();

        if (!parking.getDrivers().contains(user)) {
            parking.getDrivers().add(user);
        }
    }

    //todo 3) As a driver, I want to stop the parking meter, so that I pay only for the actual parking time

    public void stopParkingMeter(int userId) {
        User user = userRepository.findOne(userId);
        user.getDriverParkingTime().endTime();
    }

    //todo 4) As a driver, I want to know how much I have to pay for parking.

    public String getFeeFor(int userId) {

        User user = userRepository.findOne(userId);
        long hours = user.getDriverParkingTime().getHours();

        double fee = Fee.calculateFee(user.getRole(), hours);

        String result = "Opłata dla użytkownika o id: " + userId + " wynosi: " + fee;

        return result;
    }

}
