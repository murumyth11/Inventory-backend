package com.kmsoft.service;

import java.util.List;

import com.kmsoft.model.Product;



public interface ProductService {
		
public Product createProduct(Product product);
	
	public Product updateProduct(int id,Product product);

	public List<Product> getAllProducts();
	
	public void deleteProduct(int id);

	public List<Product> getoneById(int id);

}
