package com.baspiotr.parkingspaces.domain.repository;

import com.baspiotr.parkingspaces.domain.model.Parking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkingRepository extends JpaRepository<Parking, Integer> {

}
