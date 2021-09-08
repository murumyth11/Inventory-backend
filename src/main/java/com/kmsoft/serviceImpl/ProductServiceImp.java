package com.kmsoft.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kmsoft.model.Product;
import com.kmsoft.repository.ProductRepository;
import com.kmsoft.service.ProductService;

 
@Service
public class ProductServiceImp implements ProductService{
	
	@Autowired 
	ProductRepository productRepo;

   @Override
	public List<Product> getAllProducts() {
	
	   return productRepo.findAll();
	}

	
	public Product createProduct(Product product) {
		
		return productRepo.save(product);
	}


	public Product updateProduct(int id,Product product) {
		Product prod= productRepo.findById(id).get(0);
		prod.setProductId(product.getProductId());
		prod.setProductKey(product.getProductKey());
		prod.setProductName(product.getProductName());
		prod.setProductQuantity(product.getProductQuantity()+prod.getProductQuantity());
	
		
		return productRepo.saveAndFlush(prod);
	}


	@Override
	public void deleteProduct(int id) {
	
		 productRepo.deleteById(id);
	}


	@Override
	public List<Product> getoneById(int id) {
		// TODO Auto-generated method stub
		return productRepo.findById(id);
	}

	

}
