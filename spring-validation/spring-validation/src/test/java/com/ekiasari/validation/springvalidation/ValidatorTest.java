package com.ekiasari.validation.springvalidation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ekiasari.validation.springvalidation.data.Person;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;

@SpringBootTest
public class ValidatorTest {

    @Autowired
    private Validator validator;

    @Test
    void testPerson() {
        Person person = new Person("", "");
        Set<ConstraintViolation<Person>> constraintViolations = validator.validate(person);

        assertFalse(constraintViolations.isEmpty());
        assertEquals(2, constraintViolations.size());
    }

    @Test
    void testValidator() {
        Person person = new Person("1", "Orange");
        Set<ConstraintViolation<Person>> constraintViolations = validator.validate(person);

        assertTrue(constraintViolations.isEmpty());
    }

}
