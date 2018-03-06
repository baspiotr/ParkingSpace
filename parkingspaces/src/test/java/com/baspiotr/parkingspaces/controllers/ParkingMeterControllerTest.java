package com.baspiotr.parkingspaces.controllers;

import com.baspiotr.parkingspaces.domain.model.Parking;
import com.baspiotr.parkingspaces.domain.model.Role;
import com.baspiotr.parkingspaces.domain.model.User;
import com.baspiotr.parkingspaces.domain.repository.ParkingRepository;
import com.baspiotr.parkingspaces.domain.repository.UserRepository;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@PropertySource("application.properties")
public class ParkingMeterControllerTest {

    @Resource
    private UserRepository userRepository;

    @Resource
    private ParkingRepository parkingRepository;

    @Autowired
    private WebApplicationContext context;


    private MockMvc mockMvc;

    ParkingMeterController parkingMeterController;

    @Before
    public void setUp() {
        User driver = User.builder().firstName("Piotr").lastName("Basinski").role(Role.DRIVER_REGULAR).build();
        User operator = User.builder().firstName("Jan").lastName("Kowalski").role(Role.OPERATOR).build();
        User owner = User.builder().firstName("Forest").lastName("Gryn").role(Role.OWNER).build();

        Parking parking = Parking.builder().operator(operator).owner(owner).build();

        userRepository.save(Arrays.asList(driver, operator, owner));
        userRepository.flush();

        parkingRepository.save(parking);
        parkingRepository.flush();

        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .build();

    }

    @Test
    public void test() {


        System.out.println(userRepository.findAll().toArray().toString());


    }

    @Test
    public void startTest() throws Exception {
//        mockMvc.perform(post("/start"))
//                .andExpect(status().isOk());


        mockMvc.perform(post("/parking/start?userId=1"));

    }

    public void stopTest() {

    }

    public void moneyTest() {

    }

    public void isDriverStartMeter() {

    }

}
