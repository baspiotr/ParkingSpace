package com.baspiotr.parkingspaces.configuration;

import com.baspiotr.parkingspaces.domain.model.Parking;
import com.baspiotr.parkingspaces.domain.model.Role;
import com.baspiotr.parkingspaces.domain.model.User;
import com.baspiotr.parkingspaces.domain.repository.ParkingRepository;
import com.baspiotr.parkingspaces.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Arrays;

@Transactional
@Component
public class DataLoader implements ApplicationRunner{

    @Autowired
    UserRepository userRepository;

    @Autowired
    ParkingRepository parkingRepository;

    @Override
    public void run(ApplicationArguments applicationArguments) {
        User driver = User.builder().firstName("Piotr").lastName("Basinski").role(Role.DRIVER_REGULAR).build();
        User operator = User.builder().firstName("Jan").lastName("Kowalski").role(Role.OPERATOR).build();
        User owner = User.builder().firstName("Forest").lastName("Gryn").role(Role.OWNER).build();

        Parking parking = Parking.builder().operator(operator).owner(owner).build();

        parking.setDrivers(Arrays.asList(driver));

        userRepository.save(Arrays.asList(driver, operator, owner));
        parkingRepository.save(parking);

        userRepository.flush();
        parkingRepository.flush();
  }
}
