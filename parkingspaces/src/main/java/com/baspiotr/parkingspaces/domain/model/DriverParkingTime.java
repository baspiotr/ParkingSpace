package com.baspiotr.parkingspaces.domain.model;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Embeddable
public class DriverParkingTime {

    private LocalDateTime startTime;
    protected LocalDateTime endTime;

    public void start() {
        this.startTime = LocalDateTime.now();
    }

    public void end() {
        this.endTime = LocalDateTime.now();
    }

    public long getHours() {
        if (endTime == null) {
            end();
        }

        if (startTime == null) {
            throw new RuntimeException();
        }

        long hours = ChronoUnit.HOURS.between(startTime, endTime);
        return hours;
    }

    public boolean isStarted() {
        return (startTime == null) ? false : true;
    }

}
