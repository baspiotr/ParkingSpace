package com.baspiotr.parkingspaces.domain.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
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

    @Setter
    @OneToMany(cascade = CascadeType.ALL)
    private List<User> drivers = new ArrayList<>();

    @OneToOne
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

    @Override
    public String toString() {
        return "Parking{" +
                "id=" + id +
                ", drivers=" + drivers +
                ", operator=" + operator +
                ", owner=" + owner +
                '}';
    }
}
