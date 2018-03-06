package com.baspiotr.parkingspaces.domain.model;

import lombok.*;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;

@Entity
@Table
@Getter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private Integer id;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @Embedded
    private DriverParkingTime driverParkingTime;

    private Role role;

    @OneToOne(cascade = CascadeType.MERGE)
    @Setter
    private Parking parking;

    @Builder
    User(String firstName, String lastName, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }
}
