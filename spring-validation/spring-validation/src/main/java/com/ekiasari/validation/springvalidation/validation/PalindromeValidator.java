package com.ekiasari.validation.springvalidation.validation;

import org.springframework.beans.factory.annotation.Autowired;

import com.ekiasari.validation.springvalidation.helper.StringHelper;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PalindromeValidator implements ConstraintValidator<Palindrome, String> {

    @Autowired
    private StringHelper stringHelper;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return stringHelper.isPalindrome(value);
    }

}
