package com.baspiotr.parkingspaces.components;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TimeComponent {

    private LocalDateTime time = LocalDateTime.now();

    public LocalDateTime getTime() {
        return time;
    }
}
