package ekiasari.webmvc.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import ekiasari.webmvc.service.HelloService;

/* 
 * ! ALWAYS IMPORT THIS IF WANT TO TEST CONTROLLER WITH MOCKMVC
*/
import static org.springframework.test.web.servlet.MockMvcBuilder.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.hamcrest.Matchers;

@SpringBootTest
@AutoConfigureMockMvc
public class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HelloService helloService;

    @BeforeEach
    void setUp() {
        Mockito.when(helloService.hello(Mockito.anyString()))
                .thenReturn("Hello Guys");
    }

    @Test
    void testHelloName() throws Exception {
        mockMvc.perform(
                get("/hello").param("name", "Eki")).andExpectAll(
                        status().isOk(),
                        content().string(Matchers.containsString("Hello Guys")));
    }

    @Test
    void testName() throws Exception {
        mockMvc.perform(
                post("/hello").param("name", "Eki")).andExpectAll(
                        status().isMethodNotAllowed());
    }

}
