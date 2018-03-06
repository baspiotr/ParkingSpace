package com.baspiotr.parkingspaces;

import com.baspiotr.parkingspaces.controllers.ParkingMeterController;
import com.baspiotr.parkingspaces.domain.model.Parking;
import com.baspiotr.parkingspaces.domain.model.Role;
import com.baspiotr.parkingspaces.domain.model.User;
import com.baspiotr.parkingspaces.domain.repository.ParkingRepository;
import com.baspiotr.parkingspaces.domain.repository.UserRepository;
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
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.Arrays;

import static org.springframework.http.RequestEntity.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ParkingspacesApplicationTests {

}
