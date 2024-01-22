package com.example.demo.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.model.Ticket;

public interface TicketDao extends JpaRepository<Ticket,String>{
	List<Ticket> findByTclass(String tc);
	
	List<Ticket> findByOrderByTfare();
}
