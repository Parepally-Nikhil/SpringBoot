package com.libraryrest.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.libraryrest.demo.model.Student;


public interface StudentDao extends JpaRepository<Student,String> {

}
