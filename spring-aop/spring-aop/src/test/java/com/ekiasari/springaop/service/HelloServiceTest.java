package com.ekiasari.springaop.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class HelloServiceTest {

    @Autowired
    HelloService helloService;

    @Test
    void testHelloService() {
        assertEquals("Hello Orange", helloService.hello("Orange"));
        assertEquals("Bye Orange", helloService.bye("Orange"));
    }
}
