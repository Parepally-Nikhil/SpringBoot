package com.example.demo.controller;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.ProductDao;
import com.example.demo.model.Product;
import com.example.demo.service.ProductService;

@RestController
//@RequestMapping("product")
public class ProductController {
	@Autowired
	private ProductService ps;
	
	Logger l=LoggerFactory.getLogger(ProductController.class);
	
	@PostMapping("insertproduct")	
	public ResponseEntity<Product> insertProduct(@RequestBody Product p){
	
		Product product=ps.saveProduct(p);
		return new ResponseEntity<Product>(product,HttpStatus.CREATED);
	}
	
//	public Product insertProduct(@RequestBody Product p){
//		
//		Product product=ps.saveProduct(p);
//		return product;
//	}
	
	@GetMapping("getproduct/{pid}")	
	public ResponseEntity<Product> getProduct(@PathVariable("pid") String pid){
	
		Product product=ps.getProduct(pid);
		
		return new ResponseEntity<Product>(product,HttpStatus.OK);
	}
	
	@GetMapping("getproducts")	
	public ResponseEntity<List<Product>> getProducts(){
	
		List<Product> productlist=ps.getProducts();
		
		return new ResponseEntity<List<Product>>(productlist,HttpStatus.ACCEPTED);
	}
	
	@PutMapping("updateproduct")	
	public ResponseEntity<Product> updateProduct(@RequestBody Product p){
	
		Product product=ps.updateProduct(p);
		
		return new ResponseEntity<Product>(product,HttpStatus.CREATED);
	}
	
	@DeleteMapping("deleteproduct/{pid}")	
	public ResponseEntity<String> deleteProduct(@PathVariable("pid") String pid){
	
		ps.deleteProduct(pid);
		
		return new ResponseEntity<String>("deleted",HttpStatus.ACCEPTED);
	}
	@RequestMapping("hellomapping")
	public String hello(){
		l.trace("Hi");
		l.debug("debug");
		l.info("info");
		l.warn("warn");
		l.error("error");
		return "Hello World";
	}
	
	
}
