package com.library.demo.dao;



import org.springframework.data.jpa.repository.JpaRepository;

import com.library.demo.model.Librarian;

public interface LibrarianDao extends JpaRepository<Librarian,String>  {

}
