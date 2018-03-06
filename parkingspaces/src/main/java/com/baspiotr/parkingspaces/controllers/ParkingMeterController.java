package com.baspiotr.parkingspaces.controllers;

import com.baspiotr.parkingspaces.domain.services.UserService;
import com.baspiotr.parkingspaces.domain.services.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/parking")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ParkingMeterController {

    final UserService userService;

    @RequestMapping(value = "/start", method = RequestMethod.POST)
    public HttpStatus start(@RequestParam(value = "userId") int userId) {

        System.out.println("jestem w start");

        return userService.startParkingMeter(userId) ? HttpStatus.OK : HttpStatus.FORBIDDEN;
    }

    @RequestMapping("/stop")
    public HttpStatus stop(@RequestParam(value = "userId") int userId) {
        return userService.stopParkingMeter(userId) ? HttpStatus.OK : HttpStatus.FORBIDDEN;
    }

    @RequestMapping("/money")
    public String userMoney(@RequestParam(value = "userId") int userId) {
        return userService.getFeeFor(userId);
    }

}
