package ekiasari.webmvc.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.MockMvcBuilder.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import jakarta.servlet.http.Cookie;
import org.hamcrest.Matchers;

@SpringBootTest
@AutoConfigureMockMvc
public class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testLoginSuccess() throws Exception {
        mockMvc.perform(
                post("/auth/login")
                        .param("username", "eki")
                        .param("password", "rahasia")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpectAll(
                        status().isOk(),
                        content().string(Matchers.containsString("ok")),
                        cookie().value("username", Matchers.is("eki")));
    }

    @Test
    void testLoginFailed() throws Exception {
        mockMvc.perform(
                post("/auth/login")
                        .param("username", "eki")
                        .param("password", "salah")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpectAll(
                        status().isUnauthorized(),
                        content().string(Matchers.containsString("ko")),
                        cookie().value("username", Matchers.is("eki")));
    }

    @Test
    void getAuthUserCookie() throws Exception {
        mockMvc.perform(
                get("/auth/user").cookie(new Cookie("username", "eki"))).andExpectAll(
                        status().isOk(),
                        content().string(Matchers.containsString("Hello eki")));
    }

}
