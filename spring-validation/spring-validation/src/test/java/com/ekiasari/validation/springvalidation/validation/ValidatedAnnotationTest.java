package com.ekiasari.validation.springvalidation.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import jakarta.validation.ConstraintViolationException;

@SpringBootTest
public class ValidatedAnnotationTest {

    @Autowired
    private IValidatedAnnotation valid;

    @Test
    public void testValid() {
        String name = valid.validate("Orange");
        assertEquals("Hello Orange", name);
    }

    @Test
    public void testError() {
        assertThrows(ConstraintViolationException.class, () -> {
            valid.validate("");
        });

    }
}
