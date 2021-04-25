package com.vminventory.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vminventory.model.Product;
import com.vminventory.model.ProductGroup;



public interface ProductService {
		
	public Product createProduct(Product product);
	
	public Product updateProduct(int id,Product product);

	public List<Product> getAllProducts();
	
	public void deleteProduct(int id);

	public List<Product> getoneById(int id);

	public ProductGroup createProductGroup(ProductGroup productgroup);
}
