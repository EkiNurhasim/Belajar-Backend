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

import org.hamcrest.Matchers;

@SpringBootTest
@AutoConfigureMockMvc
public class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testCreatePerson() throws Exception {
        mockMvc.perform(
                post("/person")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("firstName", "Eki")
                        .param("middleName", "Nurhasim")
                        .param("lastName", "Al Asari")
                        .param("email", "eki@gmail.com")
                        .param("phone", "123456789")
                        .param("address.street", "Jalan Belum Jadi")
                        .param("address.city", "Jakarta")
                        .param("address.country", "Indonesia")
                        .param("address.postalCode", "1111")
                        .param("hobbies[0]", "Coding")
                        .param("hobbies[1]", "Reading")
                        .param("hobbies[2]", "Gaming")
                        .param("socialMedia[0].name", "Twitter")
                        .param("socialMedia[1].name", "Instagram")
                        .param("socialMedia[0].location", "twitter.com/ekiasari")
                        .param("socialMedia[1].location", "Instagram.com/ekiasari"))
                .andExpectAll(
                        status().isOk(),
                        content().string(Matchers.containsString(
                                "Success create person Eki Nurhasim Al Asari with email eki@gmail.com with phone 123456789 with street Jalan Belum Jadi with city Jakarta with country Indonesia with postalCode 1111")));
    }

    @Test
    void testCreatePersonValidationError() throws Exception {
        mockMvc.perform(
                post("/person")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("middleName", "Nurhasim")
                        .param("lastName", "Al Asari")
                        .param("email", "eki@gmail.com")
                        .param("phone", "123456789")
                        .param("address.street", "Jalan Belum Jadi")
                        .param("address.city", "Jakarta")
                        .param("address.country", "Indonesia")
                        .param("address.postalCode", "1111")
                        .param("hobbies[0]", "Coding")
                        .param("hobbies[1]", "Reading")
                        .param("hobbies[2]", "Gaming")
                        .param("socialMedia[0].name", "Twitter")
                        .param("socialMedia[1].name", "Instagram")
                        .param("socialMedia[0].location", "twitter.com/ekiasari")
                        .param("socialMedia[1].location", "Instagram.com/ekiasari"))
                .andExpectAll(
                        status().isBadRequest(),
                        content().string(Matchers.containsString("you send invalid data")));
    }
}
