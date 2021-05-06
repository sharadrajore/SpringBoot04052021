package com.zensar.services;

import java.util.List;

import com.zensar.entities.Product;

public interface ProductService {

	public List<Product> getAllProducts();
	
	public Product getProduct(int productId);

	public Product insertProduct( Product product);
	
	public boolean deleteProduct(int productId);
	
	public Product updateProduct(int productId,Product product);
}
