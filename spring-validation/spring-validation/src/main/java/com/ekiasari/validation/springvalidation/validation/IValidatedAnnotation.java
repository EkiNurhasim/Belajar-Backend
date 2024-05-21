package com.ekiasari.validation.springvalidation.validation;

import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.NotBlank;

@Validated
public interface IValidatedAnnotation {

    public String validate(@NotBlank String name);
}
