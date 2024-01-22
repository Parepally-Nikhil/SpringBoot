package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dao.ProductDao;
import com.example.demo.model.Product;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;

@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest
class SpringProductRestApplicationTests {
	
	@Autowired
	ProductDao pd;

	@Test
	@Order(1)
	public void testAddProduct() {
		Product p=new Product();
		p.setProductName("Dell");
		p.setProductPrice(50000);
		pd.save(p);
		assertNotNull(pd.findById("P_0015").get());
	}
	
	@Test
	@Order(2)
	public void testGetProducts() {
        List<Product> products = pd.findAll();
        assertThat(products).size().isGreaterThan(0);
    }
	
	@Test
	@Order(3)
	public void testGetProductById() {
        Product p = pd.findById("P_0015").get();
        assertEquals(50000, p.getProductPrice());
	}
	
	@Test
	@Order(4)
	public void testUpdateProduct() {
        Product p = pd.findById("P_0015").get();
        p.setProductName("DELL");
        p.setProductPrice(41000);
        pd.save(p);
        assertEquals(41000, p.getProductPrice());
    }
	
	@Test
	@Order(5)
	public void testDeleteProduct() {
        pd.deleteById("P_0015");
        assertThat(pd.existsById("P_0015")).isFalse();
    }
}
