package com.ekiasari.spring.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @PropertySources({
// 		@PropertySource("classpath:/info.properties"),
// 		@PropertySource("classpath:/sample.properties")
// })
@SpringBootApplication
public class SpringConfigurationPropertiesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringConfigurationPropertiesApplication.class, args);
	}

}
