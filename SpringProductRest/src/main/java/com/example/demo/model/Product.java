package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.example.demo.sequencegenerator.StringPrefixedSequenceIdGenerator;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy =GenerationType.SEQUENCE,generator = "P_000")
	@GenericGenerator(name="P_000",
    strategy = "com.example.demo.sequencegenerator.StringPrefixedSequenceIdGenerator",
    parameters = {
            @Parameter(name=StringPrefixedSequenceIdGenerator.INCREMENT_PARAM,value="1"),
            @Parameter(name=StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER,value="P_"),
            @Parameter(name=StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER,value="%04d")
    }
    )
    
	private String productId;
	private String productName;
	private int productPrice;
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	
	
}
