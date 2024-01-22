package com.example.demo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface Dao extends CrudRepository<Admin,Integer> {
	List<Admin> findByAdminName(String name);
}
