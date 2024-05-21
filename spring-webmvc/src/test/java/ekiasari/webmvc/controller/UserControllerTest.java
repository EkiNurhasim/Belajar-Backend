package ekiasari.webmvc.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import ekiasari.webmvc.model.User;
import jakarta.servlet.http.Cookie;

import static org.springframework.test.web.servlet.MockMvcBuilder.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.hamcrest.Matchers;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetUserSession() throws Exception {

        mockMvc.perform(
                get("/user/current")
                        .sessionAttr("user", new User("Eki"))
                        .cookie(new Cookie("username", "Asari")))
                .andExpectAll(
                        status().isOk(),
                        content().string(Matchers.containsString("Hello Eki Asari")));
    }
}
