package com.kmsoft.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
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
import com.kmsoft.model.Product;
import com.kmsoft.model.ProductValidators;
import com.kmsoft.repository.ProductValidatorsRepository;
import com.kmsoft.service.ProductService;

@RestController

public class ProductDetailsController {

	@Autowired
	ProductService productservice;

	

	@Autowired
	ProductValidatorsRepository pvRepo;

	@CrossOrigin("*")
	@RequestMapping("/products")
	public List<Product> getAllProducts() {
		return productservice.getAllProducts();
	}

	@CrossOrigin("*")
	@GetMapping("/products/{id}")
	public Product getProductsById(@PathVariable Integer id) {
		return productservice.getoneById(id);
	}

	// save product
	@CrossOrigin("*")
	@PostMapping("/products")
	public Product createProduct(@Valid @RequestBody Product product) {
		if (product.getPrimaryUnit() == null) {
			product.setPrimaryUnit("qty");
		}
		if (product.getSecondaryUnit() == null) {
			String su = product.getPrimaryUnit();
			product.setSecondaryUnit("qty");
		}
		if (product.getUnitConversion() == 0) {
			product.setUnitConversion(1);
		}
		
		product.setIsAliveProduct(1);
		return productservice.createProduct(product);

	}

	@CrossOrigin("*")
	@PutMapping("/products/{id}")
	public Product updateProduct( @PathVariable int id,@Valid @RequestBody Product product) {
		return productservice.updateProduct(id, product);

	}

	@CrossOrigin("*")
	@PutMapping("/deleteproducts")

	public void deleteProduct(@RequestParam int id) {
		productservice.deleteProduct(id);
	}

	

	@CrossOrigin("*")
	@GetMapping("/productsLike/{productlike}")
	public List<Product> getproductlike(@PathVariable String productlike) {
		return productservice.getproductlike(productlike);
	}

	@CrossOrigin("*")
	@GetMapping("/products/lowstock")
	public List<Product> getLowStock() {
		return productservice.getLowStock();
	}

	@CrossOrigin("*")
	@GetMapping("/products/stockInHand")
	public int getStockInHand() {
		return productservice.getStockInHand();
	}

	@CrossOrigin("*")
	@GetMapping("/products/totalProductCount")
	public int getTotalproductcount() {
		return productservice.getTotalproductcount();
	}

	@CrossOrigin("*")
	@GetMapping("/prd")
	public Page<Product> getAllProducts(@RequestParam(required = false) String title,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "2") int size) {
		List<Product> tutorials = new ArrayList<Product>();
		Pageable paging = PageRequest.of(page, size);
		Page<Product> pageTuts;

		if (title == null) {
			pageTuts = productservice.getAllproduct(paging);
			System.out.println(title);
		} else {
			pageTuts = productservice.findByProductNameContaining(title, paging);
		}
		return pageTuts;

	}

	@CrossOrigin("*")
	@RequestMapping("/updatequantity/{id}")
	public void updateQuantity(@PathVariable int id, @RequestParam() String qty) {
		productservice.updateProductQuantity(id, qty,"purchase");
	}

	@CrossOrigin("*")
	@GetMapping("/inventoryReports")
	public Page<List<Map<String, Object>>> getInventoryReport(

			@RequestParam(required = false) String title, @RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size) {

		Page<List<Map<String, Object>>> data;

		Pageable paging = PageRequest.of(page, size);

		if (title == null) {
			System.out.println("inventorynull");

			data = productservice.getInventoryReport(paging);

		} else {
			System.out.println("inventory have title");
			data = productservice.getInventoryReportTitle(title, paging);

		}
		return data;

	}

	@CrossOrigin("*")
	@PostMapping("/productValidators")
	public ProductValidators createProductValidators(@RequestBody ProductValidators pv) {
		return pvRepo.save(pv);
	}

	@CrossOrigin("*")
	@GetMapping("/productValidators")
	public Optional<ProductValidators> getPv() {
		return pvRepo.findById(1);
	}

}
