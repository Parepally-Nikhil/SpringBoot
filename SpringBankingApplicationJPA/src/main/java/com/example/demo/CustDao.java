package com.example.demo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CustDao extends CrudRepository<Customer,Integer>{

	List<Customer> findByCustomerPassword(String name);

	//List<Customer> findByCustomerName(String name);
	
}
