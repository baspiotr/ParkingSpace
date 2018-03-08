package com.baspiotr.parkingspaces.domain.model;

import lombok.*;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

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

    private Role role;

    @Setter
    private LocalDateTime startTime;

    @Setter
    private LocalDateTime endTime;

    @Builder
    User(String firstName, String lastName, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }

    public long getHours() {
        if (endTime == null) {
            endTime = LocalDateTime.now();
        }

        if (startTime == null) {
            startTime = LocalDateTime.now();
        }


        System.out.println("GetHours counted from "+startTime+"   "+endTime);


        long hours = ChronoUnit.HOURS.between(startTime, endTime);
        return hours;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", role=" + role +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
