package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dao.ProductDao;
import com.example.demo.exception.EmptyInputException;
import com.example.demo.model.Product;

@Service
public class ProductService implements ProductServiceImpl {
	@Autowired
	private ProductDao pd;
	
	public Product saveProduct(Product p) {
		if(p.getProductName().isEmpty() || p.getProductName().length()==0)
			throw new EmptyInputException("601","Input fields cannot be empty");
		
			//throw new EmptyInputException();
			return pd.save(p);
		
	}
	public Product getProduct(String pid) {
		return pd.findById(pid).get();
	}
	public List<Product> getProducts() {
		return pd.findAll();		
	}
	
	public Product updateProduct(Product p) {
		return pd.save(p);
		
	}

	public void deleteProduct(String pid) {
		pd.deleteById(pid);	
	}
}
