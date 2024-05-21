package com.ekiasari.spring.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
public class ProfilesTest {

    @Autowired
    private Profiles profiles;

    @Test
    void testProfile() {
        assertEquals("HELLO ORANGE FROM DEVELOPMENT", profiles.printProfile("ORANGE"));
    }
}
