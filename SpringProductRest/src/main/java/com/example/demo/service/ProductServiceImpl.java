package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Product;

public interface ProductServiceImpl {
	public Product saveProduct(Product p);
	public List<Product> getProducts();
	public Product updateProduct(Product p);
	public void deleteProduct(String pid);
	public Product getProduct(String pid);
}
