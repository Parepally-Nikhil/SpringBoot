package com.libraryrest.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.libraryrest.demo.model.IssueBook;

public interface IssueBookDao extends JpaRepository<IssueBook,String>{

}
