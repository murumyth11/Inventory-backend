package com.vminventory.serviceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vminventory.model.Product;
import com.vminventory.model.ProductGroup;
import com.vminventory.repository.ProductGroupRepository;
import com.vminventory.repository.ProductRepository;
import com.vminventory.service.ProductService;

@Service
public class ProductServiceImp implements ProductService {

	@Autowired
	ProductRepository productRepo;
	
	@Autowired
	ProductGroupRepository productgroupRepo;

	@Override
	public List<Product> getAllProducts() {

		return productRepo.findAll();
	}

	public Product createProduct(Product product) {

		return productRepo.save(product);
	}

	public Product updateProduct(int id, Product product) {
		Product prod = (Product) productRepo.findById(id).get(0);
		prod.setProductId(product.getProductId());
		prod.setProductKey(product.getProductKey());
		prod.setProductName(product.getProductName());
		prod.setProductPrice(product.getProductPrice());
		prod.setProductQuantity(product.getProductQuantity());
		prod.setProductType(product.getProductType());

		return productRepo.saveAndFlush(product);
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
	
	public ProductGroup createProductGroup(ProductGroup productgroup)
	{
		return productgroupRepo.save(productgroup);
	}

}
