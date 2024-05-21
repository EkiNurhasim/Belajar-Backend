package com.ekiasari.springaop.service;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class HelloService {

    public String hello(String name) {
        log.info("Hello fom HelloService.hello()");
        return "Hello " + name;
    }

    public String bye(String name) {
        log.info("Hello from HelloService.bye()");
        return "Bye " + name;
    }
}
