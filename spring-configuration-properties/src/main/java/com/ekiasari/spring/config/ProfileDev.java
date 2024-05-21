package com.ekiasari.spring.config;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile({ "dev" })
public class ProfileDev implements Profiles {

    @Override
    public String printProfile(String name) {
        return "HELLO " + name + "FROM DEVELOPMENT";
    }

}
