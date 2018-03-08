package com.baspiotr.parkingspaces.domain.services;

import com.baspiotr.parkingspaces.domain.model.Role;
import com.baspiotr.parkingspaces.domain.model.User;
import com.baspiotr.parkingspaces.domain.repository.ParkingRepository;
import com.baspiotr.parkingspaces.domain.repository.UserRepository;
import com.baspiotr.parkingspaces.domain.utils.Fee;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
@Transactional
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public boolean startParkingMeter(int userId) {

        User user = userRepository.findOne(userId);

        if (user == null) {
            return false;
        }

        user.setStartTime(LocalDateTime.now());

        return true;
    }

    public boolean stopParkingMeter(int userId) {

        User user = userRepository.findOne(userId);

        if (user == null) {
            return false;
        } else if (user.getStartTime() == null) {
            user.setStartTime(LocalDateTime.now());
        }

        user.setEndTime(LocalDateTime.now());

        return true;
    }

    public BigDecimal fee(int userId) {

        User user = userRepository.findOne(userId);

        if (user == null) {
           new RuntimeException();
        }

        long hours = user.getHours();
        BigDecimal feeAmount = Fee.calculateFee(user.getRole(), (int) hours);

        return feeAmount;
    }

    @Override
    public boolean isTimerStartedForUser(int userId) {
        User user = userRepository.findOne(userId);
        return (user.getStartTime() == null) ? false : true;
    }

    public BigDecimal allDayEarnings() {

        BigDecimal feeAmount = new BigDecimal(0);

        for (Object user : userRepository.findAll().toArray()) {
            if (user instanceof User) {
                User castUser = (User) user;
                if (castUser.getRole().equals(Role.DRIVER_REGULAR) || castUser.getRole().equals(Role.DRIVER_VIP)) {
                    long hours = castUser.getHours();
                    feeAmount = feeAmount.add(Fee.calculateFee(castUser.getRole(), (int) hours));
                }
            }
        }

        return feeAmount;
    }
}
