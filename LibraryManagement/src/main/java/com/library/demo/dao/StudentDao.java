package com.library.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.library.demo.model.Student;

public interface StudentDao extends JpaRepository<Student,String> {

}
