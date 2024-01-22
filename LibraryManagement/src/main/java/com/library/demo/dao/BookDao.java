package com.library.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.library.demo.model.Book;

public interface BookDao extends JpaRepository<Book,String>{
	@Query("from Book order by bookName")
	List<Book> findByBookNameSorted();
}
