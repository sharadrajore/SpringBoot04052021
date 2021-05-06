package com.zensar.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.zensar.entities.Product;
import com.zensar.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	// private ProductRepository repository=new ProductRepositoryImpl();

	@Autowired
	private ProductRepository repository;

	public List<Product> getAllProducts() {
		return repository.findAll();
	}

	public Product getProduct(int productId) {
		return repository.findById(productId).get();
	}

	public Product insertProduct(Product product) {
		return repository.save(product);
	}

	public void deleteProduct(int productId) {
		repository.deleteById(productId);
	}

	public Product updateProduct(int productId, Product product) {
		return repository.save(product);
	}

}
