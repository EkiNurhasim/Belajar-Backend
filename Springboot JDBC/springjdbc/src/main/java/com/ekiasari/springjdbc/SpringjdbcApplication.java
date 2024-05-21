package com.ekiasari.springjdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.ekiasari.springjdbc.model.Alien;
import com.ekiasari.springjdbc.repo.AlienRepo;

@SpringBootApplication
public class SpringjdbcApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringjdbcApplication.class, args);
		
		Alien alien = context.getBean(Alien.class);
		alien.setId(104);
		alien.setName("Migyu");
		alien.setTech("Java");

		AlienRepo repo = context.getBean(AlienRepo.class);
		repo.save(alien);
		System.out.println(repo.findAll());
		
	}

}
