package com.baspiotr.parkingspaces.controllers;

import com.baspiotr.parkingspaces.domain.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@Transactional
@RestController
@RequestMapping("/parking")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ParkingMeterController {

    final UserService userService;

    @PostMapping(value = "/start")
    public HttpStatus start(@RequestParam(value = "userId") int userId) {
        return userService.startParkingMeter(userId) ? HttpStatus.OK : HttpStatus.FORBIDDEN;
    }

    @PostMapping("/stop")
    public HttpStatus stop(@RequestParam(value = "userId") int userId) {
        return userService.stopParkingMeter(userId) ? HttpStatus.OK : HttpStatus.FORBIDDEN;
    }

    @GetMapping("/money")
    public String userMoney(@RequestParam(value = "userId") int userId) {
        return userService.fee(userId).toString();
    }

    @GetMapping("/isTimerStarted")
    public Boolean isTimerStarted(@RequestParam(value = "userId") int userId) {
        return userService.isTimerStartedForUser(userId);
    }

    @GetMapping("/allMoney")
    public String money() {
        return userService.allDayEarnings().toString();
    }

}
