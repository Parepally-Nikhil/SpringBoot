package com.example1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example1.model.Product;
@SpringBootApplication
public class ProductMainApp {

	public static void main(String[] args) {
		ConfigurableApplicationContext context=
		SpringApplication.run(ProductMainApp.class, args);
		Product p1=(Product)context.getBean(Product.class);
		p1.setPname("horlicks");
		System.out.println(p1.getPname());
		Product p2=(Product)context.getBean(Product.class);
		System.out.println(p2.getPname());
	}

}
