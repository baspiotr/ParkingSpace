package com.baspiotr.parkingspaces.domain.repository;

import com.baspiotr.parkingspaces.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
