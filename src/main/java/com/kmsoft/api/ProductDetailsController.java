package com.kmsoft.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kmsoft.model.Product;
import com.kmsoft.model.ProductGroup;
import com.kmsoft.repository.ProductGroupRepository;
import com.kmsoft.service.ProductService;

@RestController
public class ProductDetailsController {

	@Autowired
	ProductService productservice;
	
	@Autowired
	ProductGroupRepository pgRepo;

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/products")
	public List<Product> getAllProducts() {
		return productservice.getAllProducts();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/products/{id}")
	public List<Product> getProductsById(@PathVariable Integer id) {
		return productservice.getoneById(id);
	}

	// save product
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/products")
	public Product createProduct(@RequestBody Product product) {
		return productservice.createProduct(product);

	}

	// update product
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/products/{id}")
	public Product updateProduct(@PathVariable Integer id, @RequestBody Product product) {
		return productservice.updateProduct(id,product);

	}

	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/products/{id}")
	
	public void deleteProduct(@PathVariable Integer id)
	{
	  productservice.deleteProduct(id);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/productgroup")
	public List<ProductGroup> getAllProductGroup(){
		return pgRepo.findAll();
	}
}

