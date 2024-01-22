package com.libraryrest.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.libraryrest.demo.model.Admin;

public interface AdminDao extends JpaRepository<Admin,String> {
	Admin findByAdminName(String name);
}
