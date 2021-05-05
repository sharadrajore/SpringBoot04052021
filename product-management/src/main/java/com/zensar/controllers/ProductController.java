package com.zensar.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.entities.Product;

@RestController
@RequestMapping("/api/v1/productapi")
public class ProductController {

	// CRUD C -> Create R -> Read U -> Update D -> Delete

	List<Product> products = new ArrayList<Product>();

	public ProductController() {
		products.add(new Product(1, "HDD", 3500));
		products.add(new Product(3, "RAM", 3000));
		products.add(new Product(2, "Laptop", 35000));

	}

	// http://localhost:8080/api/v1/productapi/products - GET

	// @RequestMapping("/products")
	@GetMapping("/products")
	public List<Product> getAllProducts() {
		return products;
	}

	// http://localhost:8080/api/v1/productapi/products/2 GET
	// @RequestMapping("/products/{productId}")
	@GetMapping("/products/{productId}")
	public Product getProduct(@PathVariable("productId") int productId) {

		// return products.stream().filter(product ->
		// product.getProductId()==id).findAny().get();

		for (Product product : products) {
			if (product.getProductId() == productId) {
				return product;
			}
		}
		return null;

	}

	// http://localhost:8080/api/v1/productapi/products - POST

	// @RequestMapping(value = "/products", method=RequestMethod.POST)
	@PostMapping("/products")
	public Product insertProduct(@RequestBody Product product) {
		products.add(product);
		return product;
	}

	// http://localhost:8080/api/v1/productapi/2     Delete
	
	@DeleteMapping("/products/{productId}")
	public boolean deleteProduct(@PathVariable("productId") int productId) {

		for (Product product : products) {
			if (product.getProductId() == productId) {
				return products.remove(product);
			}
		}
		return false;
	}
	
	
	@PatchMapping("/products/{productId}")
	public Product updateProduct(@PathVariable("productId")int productId,@RequestBody Product product) {
		
		Product availableProduct = getProduct(productId);
		
		availableProduct.setProductName(product.getProductName());
		availableProduct.setProductCost(product.getProductCost());
		
		//products.add(availableProduct);
		
		return availableProduct;
		
	}

}










