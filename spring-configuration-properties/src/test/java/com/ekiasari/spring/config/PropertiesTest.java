package com.ekiasari.spring.config;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.TestPropertySources;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
@TestPropertySources({
        @TestPropertySource("classpath:/info.properties"),
        @TestPropertySource("classpath:/sample.properties")
})
public class PropertiesTest {

    @Autowired
    Properties properties;

    @Test
    void testProperties() {
        log.info(properties.getEnvironment());
        log.info(properties.getName());
        log.info(properties.getJavaHome());
        assertEquals(properties.getEnvironment(), "dev profile");
        assertEquals(properties.getName(), "dev profile");
        assertEquals(properties.getJavaHome(), "C:\\Program Files\\Java\\jdk-17");
        assertEquals(properties.getInfoName(), "info");
        assertEquals(properties.getInfoVersion(), "1");
        assertEquals(properties.getSampleName(), "sample");
        assertEquals(properties.getSampleVersion(), "1");
    }

}
