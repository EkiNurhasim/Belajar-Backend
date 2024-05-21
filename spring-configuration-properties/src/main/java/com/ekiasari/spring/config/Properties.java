package com.ekiasari.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import lombok.Getter;

@Component
public class Properties {

    @Autowired
    private Environment environment;

    @Value("${spring.application.name}")
    @Getter
    private String name;

    @Value("${JAVA_HOME}")
    @Getter
    private String javaHome;

    @Value("${info.name}")
    @Getter
    private String infoName;

    @Value("${info.version}")
    @Getter
    private String infoVersion;

    @Value("${sample.name}")
    @Getter
    private String sampleName;

    @Value("${sample.version}")
    @Getter
    private String sampleVersion;

    public String getEnvironment() {
        String property = environment.getProperty("spring.application.name");
        return property;
    }
}
