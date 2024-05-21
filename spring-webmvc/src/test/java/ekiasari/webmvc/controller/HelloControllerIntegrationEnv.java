package ekiasari.webmvc.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

// @SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT) // test with random port?
public class HelloControllerIntegrationEnv {

    // @Value("${local.server.port}")
    // @LocalServerPort
    // private Integer port;

    // @Autowired
    // private TestRestTemplate template;

    // @Test
    // void testRestTemplateGuest() {
    // ResponseEntity<String> responseEntity =
    // template.getForEntity("http://localhost:" + port + "/hello",
    // String.class);
    // String response = responseEntity.getBody();

    // assertNotNull(response);
    // assertEquals(responseEntity, "Hello Guest");
    // }

    // @Test
    // void testRestTemplateName() {
    // ResponseEntity<String> responseEntity =
    // template.getForEntity("http://localhost:" + port + "/hello?name=Eki",
    // String.class);
    // String response = responseEntity.getBody();

    // assertNotNull(response);
    // assertEquals(responseEntity, "Hello Eki");
    // }

}
