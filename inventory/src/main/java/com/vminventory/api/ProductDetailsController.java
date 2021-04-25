package com.vminventory.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.vminventory.model.Product;
import com.vminventory.model.ProductGroup;
import com.vminventory.repository.ProductGroupRepository;
import com.vminventory.service.ProductService;

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
	@PostMapping("/productgroup")
	public ProductGroup createProductGroup(@RequestBody ProductGroup productgroup) {
		return productservice.createProductGroup(productgroup);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/productgroup")
	public List<ProductGroup> getAllProductGroup(){
		return pgRepo.findAll();
	}
	
}

