package com.kmsoft.api;

import com.kmsoft.model.ProductGroup;
import com.kmsoft.service.ProductGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductGroupController {

	@Autowired 
	ProductGroupService pgService;
	
	//@CrossOrigin("*")
	@GetMapping("/productgroup")
	public List<ProductGroup> getAllProductGroup() {
		return pgService.getAllProductGroup();
	}

	//@CrossOrigin("*")
	@PostMapping("/productgroup")
	public ProductGroup createpg(@RequestBody ProductGroup productgroup) {
		productgroup.setIsalivegroup(1);
		return pgService.createpg(productgroup);
	}

	//@CrossOrigin("*")
	@PutMapping("/productgroup")
	public ProductGroup updatepg(@RequestBody ProductGroup productgroup) {
		return pgService.updatepg(productgroup);
	}

	//@CrossOrigin("*")
	@PutMapping("/deleteproductgroup")
	public void deleteProductgroup(@RequestParam int id) {
		pgService.deleteProductgroup(id);
	}
}
