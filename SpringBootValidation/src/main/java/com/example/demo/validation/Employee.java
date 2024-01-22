package com.example.demo.validation;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Max;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
@Entity
public class Employee {
	@Id
	@NotBlank(message="this should not be blank")
	private String name;
	@Size(min=8,message="Password must be 8 characters long")
	private String pass;
	@Min(value=20000) @Max(value=40000)
	private int salary;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	
}