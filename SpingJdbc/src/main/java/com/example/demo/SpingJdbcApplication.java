package com.example.demo;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpingJdbcApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx=
		SpringApplication.run(SpingJdbcApplication.class, args);
		
	AddressJdbc addj=(AddressJdbc)ctx.getBean(AddressJdbc.class);
	Address add=(Address)ctx.getBean(Address.class);
	add.setCity("Miryalaguda");
	add.setCountry("India");
	int r=addj.saveEmployee(add);
	if(r>0) {
		System.out.println("Data stored successfully..");
	}
//	add.setCity("Nlg");
//	add.setCountry("India");
//	int m=addj.updateEmployee(add);
//	if(m>0) {
//		System.out.println("Data stored successfully..");
//	}
//	else {
//		System.out.println("Data not stored successfully..");
//	}
	
	add.setCity("Miryalaguda");
	int m=addj.deleteEmployee(add);
	if(m>0) {
		System.out.println("Deleted successfully..");
	}
	else {
		System.out.println("Data not stored successfully..");
	}
	
	List<Address> list=addj.retrieval();
	for(Address a:list) {
		System.out.println("city: "+a.getCity()+"country: "+a.getCountry());
	}
	}

}
