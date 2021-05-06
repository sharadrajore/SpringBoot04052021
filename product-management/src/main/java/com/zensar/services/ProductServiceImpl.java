package com.zensar.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.entities.Product;
import com.zensar.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	
	//private ProductRepository repository=new ProductRepositoryImpl();
	
	@Autowired
	private ProductRepository repository;
	
	
	
	public List<Product> getAllProducts() {
		return repository.getAllProducts();
	}

	
	
	public Product getProduct(int productId) {
		return repository.getProduct(productId);
	}

	

	public Product insertProduct(Product product) {
		return repository.insertProduct(product);
	}


	public boolean deleteProduct(int productId) {
		return repository.deleteProduct(productId);
	}
	
	
	
	public Product updateProduct(int productId,Product product) {
		return repository.updateProduct(productId, product);
	}



}
