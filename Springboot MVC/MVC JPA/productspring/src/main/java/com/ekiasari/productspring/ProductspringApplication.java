package com.ekiasari.productspring;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ProductspringApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ProductspringApplication.class, args);

		ProductService service = context.getBean(ProductService.class);
		List<Product> products = service.getAllProducts();
		for (var item : products) {
			System.out.println(item);
		}
	}

}
