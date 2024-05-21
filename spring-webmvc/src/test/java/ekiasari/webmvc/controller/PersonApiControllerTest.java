package ekiasari.webmvc.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import ekiasari.webmvc.model.CreatePersonRequest;
import ekiasari.webmvc.model.CreateSocialMediaRequest;

import static org.springframework.test.web.servlet.MockMvcBuilder.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class PersonApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void testPersonApiSuccess() throws Exception {
        CreatePersonRequest person = new CreatePersonRequest();
        person.setFirstName("eki");
        person.setMiddleName("nurhasim");
        person.setLastName("al asai");
        person.setEmail("eki@gmail.com");
        person.setPhone("1234");
        person.setHobbies(List.of("Coding", "Reading", "Gaming"));
        person.setSocialMedia(new ArrayList<>());
        person.getSocialMedia().add(new CreateSocialMediaRequest("Facebook", "facebook.com/eki"));
        person.getSocialMedia().add(new CreateSocialMediaRequest("Twitter", "twitter.com/eki"));

        String jsonReq = mapper.writeValueAsString(person);

        mockMvc.perform(
                post("/api/person")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(jsonReq))
                .andExpectAll(
                        status().isOk(),
                        content().json(jsonReq));
    }

    @Test
    void testPersonApiFailed() throws Exception {
        CreatePersonRequest person = new CreatePersonRequest();
        person.setMiddleName("nurhasim");
        person.setLastName("al asai");
        person.setHobbies(List.of("Coding", "Reading", "Gaming"));
        person.setSocialMedia(new ArrayList<>());
        person.getSocialMedia().add(new CreateSocialMediaRequest("Facebook", "facebook.com/eki"));
        person.getSocialMedia().add(new CreateSocialMediaRequest("Twitter", "twitter.com/eki"));

        String jsonReq = mapper.writeValueAsString(person);

        mockMvc.perform(
                post("/api/person")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(jsonReq))
                .andExpectAll(
                        status().isBadRequest());
    }
}
