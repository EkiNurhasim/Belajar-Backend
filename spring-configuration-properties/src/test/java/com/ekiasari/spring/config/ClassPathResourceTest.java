package com.ekiasari.spring.config;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ClassPathResourceTest {

    @Test
    void testResource() throws IOException {

        var res = new ClassPathResource("/text/readme.txt"); // (resources/text/readme.txt)

        assertNotNull(res);
        assertTrue(res.exists());
        assertNotNull(res.getFile());
        log.info("Running the ClassPathResource");
    }

}
