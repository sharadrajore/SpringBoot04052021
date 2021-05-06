package com.zensar.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.zensar.entities.Product;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

	List<Product> products = new ArrayList<Product>();

	public ProductRepositoryImpl() {
		products.add(new Product(1, "HDD", 3500));
		products.add(new Product(3, "RAM", 3000));
		products.add(new Product(2, "Laptop", 35000));

	}

	
	
	public List<Product> getAllProducts() {
		return products;
	}

	
	
	public Product getProduct(int productId) {

		

		for (Product product : products) {
			if (product.getProductId() == productId) {
				return product;
			}
		}
		return null;

	}

	

	public Product insertProduct(Product product) {
		products.add(product);
		return product;
	}


	public boolean deleteProduct(int productId) {

		for (Product product : products) {
			if (product.getProductId() == productId) {
				return products.remove(product);
			}
		}
		return false;
	}
	
	
	
	public Product updateProduct(int productId,Product product) {
		
		Product availableProduct = getProduct(productId);
		
		availableProduct.setProductName(product.getProductName());
		availableProduct.setProductCost(product.getProductCost());
		
		//products.add(availableProduct);
		
		return availableProduct;
		
	}



}
