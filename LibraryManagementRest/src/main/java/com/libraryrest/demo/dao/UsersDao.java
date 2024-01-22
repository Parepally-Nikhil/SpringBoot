package com.libraryrest.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.libraryrest.demo.model.Users;

public interface UsersDao extends JpaRepository<Users,Integer> {
	Users findByUserName(String uname);
}
