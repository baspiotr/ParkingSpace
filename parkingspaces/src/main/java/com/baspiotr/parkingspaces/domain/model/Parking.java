package com.baspiotr.parkingspaces.domain.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table
@Getter
@NoArgsConstructor
public class Parking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private Integer id;

    @OneToMany(mappedBy = "parking", cascade = CascadeType.MERGE)
    private List<User> drivers;

    @OneToOne(cascade = CascadeType.MERGE)
    @NotNull
    private User operator;

    @OneToOne
    @NotNull
    private User owner;

    @Builder
    Parking(User operator, User owner) {
        this.operator = operator;
        this.owner = owner;
    }

}
