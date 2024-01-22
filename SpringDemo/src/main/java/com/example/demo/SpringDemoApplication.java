package com.example.demo;

import org.springframework.boot.SpringApplication;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.model.HelloWorld;
import com.example.demo.model2.Employee;

@SpringBootApplication
public class SpringDemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx=
		SpringApplication.run(SpringDemoApplication.class, args);
		System.out.println("welcome to spring boot");
//		HelloWorld hw=(HelloWorld)ctx.getBean(HelloWorld.class);
//		Employee emp=(Employee)ctx.getBean(Employee.class);
	}

}
