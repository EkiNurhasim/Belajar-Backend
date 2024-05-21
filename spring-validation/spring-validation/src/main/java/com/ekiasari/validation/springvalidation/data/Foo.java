package com.ekiasari.validation.springvalidation.data;

import com.ekiasari.validation.springvalidation.validation.Palindrome;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Foo {

    @Palindrome
    private String bar;
}
