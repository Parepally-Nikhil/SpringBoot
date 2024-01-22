package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.TicketDao;
import com.example.demo.model.Ticket;


//@RequestBody annotation is used to parse the incoming HTTP request while @ResponseBody annotation is used to convert your object into HTTP response in the form client is expecting like JSON, XML, or simply text. 

@Controller
public class TicketController {
	@Autowired
	TicketDao td;
	
	@RequestMapping("rest")
	@ResponseBody
	public String toRest() {
		return "welcome to rest";
	}
	
	//@RequestMapping("saveticket")
//	@PostMapping("saveticket")
//	@ResponseBody
//	public String saveTicket(Ticket t) {
//		return td.save(t).toString();
//	}
	
	@PostMapping(path="saveticket")
	//@PostMapping(path="saveticket",produces={"application/xml"})
	@ResponseBody 
	public Object saveTicket(Ticket t) {    //Taking data from form in postman client
		return td.save(t);					//displays JSON format on browser 
	}
	
	@GetMapping("viewdetails")
	@ResponseBody
	public List<Ticket> viewDetails(Ticket t) {
		return td.findAll();
	}
	
	@GetMapping("viewdetailbyid")
	@ResponseBody
	public String viewDetailById(Ticket t) {
		return td.findById(t.getTid()).toString();
	}
	
//	@DeleteMapping("deletedetailbyid")
//	@ResponseBody
//	public String deleteDetailById(Ticket t) {
//		td.deleteById(t.getTid());					//it is not working because from browser we can get post and get request but not delete.
//		return "deleted";
//	}
	
	@DeleteMapping("delete/{tid}")
	@ResponseBody
	public String deleteDetailById(@PathVariable("tid") String tid){
		td.deleteById(tid);
		return "deleted";
	}
	
	@PutMapping("updateticket")
	@ResponseBody
	public Ticket updateDetailById(Ticket t) {
		return td.save(t);
	}
	
	@RequestMapping("ticket/{tid}")
	@ResponseBody
	public Object get(@PathVariable("tid") String tid)
	{
		return td.findById(tid);
	}
	
	@PostMapping("rawticket")
	@ResponseBody
	public Ticket insertTicket(@RequestBody Ticket t) {
		return td.save(t);					
	}
	
	@GetMapping(path="gettickets",produces={"application/xml"})
	@ResponseBody
	public List<Ticket> getTickets(){
		return td.findAll();
	}
	
	@GetMapping(path="getticket/{tid}",produces={"application/xml"})
	@ResponseBody
	public Ticket getTicket(@PathVariable("tid")String tid){
		return td.findById(tid).orElse(null);
	}
	
	@PostMapping(path="postticket",consumes={"application/xml"},produces={"application/xml"})
	@ResponseBody
	public Ticket postTicket(@RequestBody Ticket t){
		return td.save(t);
	}
	
	@GetMapping(path="print/{tclass}")
	@ResponseBody
	public List<Ticket> printTicketClass(@PathVariable("tclass")String tc){
		
		return td.findByTclass(tc);
	}
	
	@GetMapping(path="sortbyprice",produces={"application/xml"})
	@ResponseBody
	public List<Ticket> sortByPrice(){
		
		return td.findByOrderByTfare();
	}	}
