package com.library.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.library.demo.model.IssueBook;

public interface IssueBookDao extends JpaRepository<IssueBook,String>{
	
}
