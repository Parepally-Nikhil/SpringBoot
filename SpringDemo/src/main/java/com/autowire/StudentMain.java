package com.autowire;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.autowire.model.Address;
import com.autowire.model.Employee;
import com.autowire.model.Student;
import com.example1.ProductMainApp;
@SpringBootApplication
public class StudentMain {

	public static void main(String[] args) {
		ConfigurableApplicationContext context=
				SpringApplication.run(StudentMain.class, args);
		
//		Student stud=(Student)context.getBean(Student.class);
//		Address add=stud.getAddress();
//		add.setCity("Hyd");
//		add.setCountry("India");
//		System.out.println(add.getCity());
//		System.out.println(add.getCountry());

		
		Employee emp=(Employee)context.getBean(Employee.class);
		Address add=emp.getAddress();
		add.setCity("Hyd");
		add.setCountry("India");
		System.out.println(add.getCity());
		System.out.println(add.getCountry());		//Example to understand scope
		
		Employee emp2=(Employee)context.getBean(Employee.class);
		Address add1=emp2.getAddress();
		System.out.println(add1.getCity());
		System.out.println(add1.getCountry());
	}

}
