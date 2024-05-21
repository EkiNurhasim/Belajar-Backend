package com.ekiasari.validation.springvalidation.validation;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.NotBlank;

@Component
public class ValidatedAnnotation implements IValidatedAnnotation {

    public String validate(@NotBlank String name) {
        return "Hello " + name;
    }
}
