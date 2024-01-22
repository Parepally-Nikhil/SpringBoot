package com.libraryrest.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.libraryrest.demo.model.Librarian;

public interface LibrarianDao extends JpaRepository<Librarian,String>  {

}
