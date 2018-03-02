package com.baspiotr.parkingspaces.configuration;

import com.baspiotr.parkingspaces.domain.model.Parking;
import com.baspiotr.parkingspaces.domain.model.Role;
import com.baspiotr.parkingspaces.domain.model.User;
import com.baspiotr.parkingspaces.domain.repository.ParkingRepository;
import com.baspiotr.parkingspaces.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.transaction.Transactional;
import java.util.Arrays;

@Configuration
public class DatabaseConfiguration {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ParkingRepository parkingRepository;

    @PostConstruct
    @Transactional
    public void initDB() {
        User driver = User.builder().firstName("Piotr").lastName("Basinski").role(Role.DRIVER_REGULAR).build();
        User operator = User.builder().firstName("Jan").lastName("Kowalski").role(Role.OPERATOR).build();
        User owner = User.builder().firstName("Forest").lastName("Gryn").role(Role.OWNER).build();

        Parking parking = Parking.builder().name("Koszykowa").operator(operator).owner(owner).build();

        userRepository.save(Arrays.asList(driver,operator,owner));
        userRepository.flush();

        parkingRepository.save(parking);
        parkingRepository.flush();
    }

    @PreDestroy
    @Transactional
    public void cleanDB() {
       userRepository.deleteAll();
       parkingRepository.deleteAll();
    }

}
