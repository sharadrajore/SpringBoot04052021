package com.zensar.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.entities.Product;

@RestController
public class ProductController {
	
	List<Product> products=new ArrayList<Product>();
	
	public ProductController() {
		products.add(new Product(1,"HDD",3500));
		products.add(new Product(3,"RAM",3000));
		products.add(new Product(2,"Laptop",35000));
		
	}
	
	
	// http://localhost:8080/products  - GET
	
	@RequestMapping("/products")
	public List<Product> getProduct() {
		return products;
	}

}
