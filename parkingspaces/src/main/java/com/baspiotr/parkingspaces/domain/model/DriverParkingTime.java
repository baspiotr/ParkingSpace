package com.baspiotr.parkingspaces.domain.model;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Embeddable
public class DriverParkingTime {

    private LocalDateTime start;
    protected LocalDateTime end;

    public void startTime() {
        this.start = LocalDateTime.now();
    }

    public void endTime() {
        this.end = LocalDateTime.now();
    }

    public long getHours() {
        if (end == null) {
            endTime();
        }
        long hours = ChronoUnit.HOURS.between(start, end);
        return hours;
    }

    public boolean isStarted() {
        return (start == null) ? false : true;
    }

}
