package com.ekiasari.spring.config;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile({ "prod" })
public class ProfileProd implements Profiles {

    @Override
    public String printProfile(String name) {
        return "HELLO " + name + " FROM PRODUCTION";
    }

}
