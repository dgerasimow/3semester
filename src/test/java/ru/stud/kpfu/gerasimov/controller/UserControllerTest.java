package ru.stud.kpfu.gerasimov.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ru.kpfu.gerasimov.Application;
import ru.kpfu.gerasimov.model.User;
import ru.kpfu.gerasimov.repository.UserRepository;

import java.util.Locale;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, classes = Application.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.properties")
//@ActiveProfiles("test")
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    @BeforeAll
    public void init() {
        User user = new User();
        user.setEmail("m@mail.ru");
        user.setName("Ivan");
        user.setPassword("password");
        user.setVerificationCode("wdwef");
        userRepository.save(user);
    }

    @Test
    public void testGet() throws Exception {
        mockMvc.perform(get("/user/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name".toLowerCase(Locale.ROOT)).value("ivan"));
    }

    @Test
    public void testGetAll() throws Exception {
        mockMvc.perform(get("/user")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name".toLowerCase(Locale.ROOT)).value("ivan"));
    }

    @Test
    public void testVerify() throws Exception {
        mockMvc.perform(get("/verification?code=wdwef"))
                .andExpect(status().isOk())
                .andExpect(content().string("verification_failed"));
    }
}