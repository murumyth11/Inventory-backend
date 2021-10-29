package com.kmsoft.api;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

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

import com.kmsoft.model.Brand;
import com.kmsoft.model.Manufacturer;
import com.kmsoft.model.Product;
import com.kmsoft.model.ProductGroup;
import com.kmsoft.model.ProductUpdateHistory;
import com.kmsoft.repository.BrandRepository;
import com.kmsoft.repository.ManufacturerRepository;
import com.kmsoft.repository.ProductGroupRepository;
import com.kmsoft.repository.ProductRepository;
import com.kmsoft.repository.ProductUpdateHistoryRepository;
import com.kmsoft.service.ProductService;

@RestController
public class ProductDetailsController {

	@Autowired
	ProductService productservice;
	
	@Autowired
	ProductRepository prepo;
	
	@Autowired
	ProductGroupRepository pgRepo;
	
	@Autowired
	ManufacturerRepository manufRepo;
	
	@Autowired
	BrandRepository brandRepo;
	
	@Autowired
	ProductUpdateHistoryRepository PrdtUpdtHstRepo;
	

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
	@CrossOrigin(origins = "*")
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
	
//	@CrossOrigin(origins = "http://localhost:4200")
//	@DeleteMapping("/products/{ids}")
//	
//	public void deleteSProduct(@PathVariable Integer[] ids)
//	{
//		prepo.deleteUsersWithIds(Arrays.asList(ids));
//	}
	
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/productgroup")
	public List<ProductGroup> getAllProductGroup(){
		return pgRepo.findAll();
	}
	 
	@CrossOrigin(origins = "http://localhost:4200")	
	@PostMapping("/productgroup")	
	public ProductGroup createpg(@RequestBody ProductGroup productgroup)
	{
		return pgRepo.save(productgroup);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/productgroup/{id}")
	public void deleteProductgroup(@PathVariable Integer id)
	{
		pgRepo.deleteById(id);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")	
	@PostMapping("/manufacturer")
	public Manufacturer createManufacturer(@RequestBody Manufacturer manufacturer) {
		return manufRepo.save(manufacturer);
	}
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/manufacturer")
	public List<Manufacturer> getManufacturer(){
		return  manufRepo.findAll();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/manufacturer/{id}")
	public void deleteManufacturer(@PathVariable Integer id)
	{
		manufRepo.deleteById(id);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/brand")
	public Brand createBand(@RequestBody Brand brand ) {
		
		return brandRepo.save(brand);
		
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/brand")
	public List<Brand> getBrand(){
		return brandRepo.findAll();
		}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/brand/{id}")
	public void deleteBrand(@PathVariable Integer id) {
		brandRepo.deleteById(id);
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping("/puh")
	public ProductUpdateHistory createProductUpdateHistory(@RequestBody ProductUpdateHistory productupdtHst) {
		return PrdtUpdtHstRepo.save(productupdtHst);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/puh")
	public List<ProductUpdateHistory> getPuh(){
		return PrdtUpdtHstRepo.findAll();
		}
	
	@CrossOrigin("*")
	@GetMapping("/products/{productlike}")
	public List<Product> getproductlike(@PathVariable String productlike){
		return prepo.getProductLike(productlike);
	}
	
	@CrossOrigin("*")
	@GetMapping("/products/lowstock")
	public List<Product> getLowStock(){
		return prepo.getLowStock();
	}
	
}

