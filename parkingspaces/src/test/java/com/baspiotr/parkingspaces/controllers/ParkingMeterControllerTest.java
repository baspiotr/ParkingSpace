package com.baspiotr.parkingspaces.controllers;

import com.baspiotr.parkingspaces.ParkingspacesApplication;
import com.baspiotr.parkingspaces.domain.model.User;
import com.baspiotr.parkingspaces.domain.repository.UserRepository;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ParkingspacesApplication.class)
@PropertySource("application.properties")
@Slf4j
@Transactional
public class ParkingMeterControllerTest extends TestCase {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .build();
    }

    @Test
    public void startTest() throws Exception {
        log.info(mockMvc.perform(post("/parking/start?userId=1")).andExpect(status().isOk()).andReturn().getResponse().getContentAsString());
    }

    @Test
    public void stopTest() throws Exception {
        log.info(mockMvc.perform(post("/parking/stop?userId=1")).andExpect(status().isOk()).andReturn().getResponse().getContentAsString());
    }

    @Test
    public void userMoneyTest() throws Exception {
        User user = userRepository.findOne(1);
        user.setStartTime(LocalDateTime.now());
        user.setEndTime(LocalDateTime.now().plusHours(7));
        log.info(mockMvc.perform(get("/parking/money?userId=1")).andExpect(status().isOk()).andExpect(content().string("127")).andReturn().getResponse().getContentAsString());
    }

    @Test
    public void isTimerStarted() throws  Exception {
        log.info(mockMvc.perform(get("/parking/isTimerStarted?userId=1")).andExpect(status().isOk()).andReturn().getResponse().getContentAsString());
    }

    @Test
    public void moneyTest() throws Exception {
        User user = userRepository.findOne(1);
        user.setStartTime(LocalDateTime.now());
        user.setEndTime(LocalDateTime.now().plusHours(7));
        log.info(mockMvc.perform(get("/parking/allMoney")).andExpect(status().isOk()).andExpect(content().string("127")).andReturn().getResponse().getContentAsString());
    }

}
