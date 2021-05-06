package com.zensar.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.entities.Product;
import com.zensar.services.ProductService;

@RestController
@RequestMapping("/api/v1/productapi")
public class ProductController {

	// CRUD C -> Create R -> Read U -> Update D -> Delete

	
	// private ProductService productService=new ProductServiceImpl();
	
	@Autowired
	private ProductService service;
	
	
	// http://localhost:8080/api/v1/productapi/products - GET

	// @RequestMapping("/products")
	@GetMapping("/products")
	public List<Product> getAllProducts() {
		return service.getAllProducts();
	}

	// http://localhost:8080/api/v1/productapi/products/2 GET
	// @RequestMapping("/products/{productId}")
	
	@GetMapping(value = "/products/{productId}",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public Product getProduct(@PathVariable("productId") int productId) {
		return service.getProduct(productId);
	}

	// http://localhost:8080/api/v1/productapi/products - POST

	// @RequestMapping(value = "/products", method=RequestMethod.POST)
	@PostMapping(value = "/products",consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public Product insertProduct(@RequestBody Product product) {
		return service.insertProduct(product);
	}

	// http://localhost:8080/api/v1/productapi/2     Delete
	
	@DeleteMapping("/products/{productId}")
	public void deleteProduct(@PathVariable("productId") int productId) {
		 service.deleteProduct(productId);
	}
	
	
	@PatchMapping("/products/{productId}")
	public Product updateProduct(@PathVariable("productId")int productId,@RequestBody Product product) {
		return service.updateProduct(productId, product);
		
	}

}










