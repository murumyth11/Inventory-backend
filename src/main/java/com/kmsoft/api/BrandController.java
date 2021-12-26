package com.kmsoft.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kmsoft.model.Brand;
import com.kmsoft.service.BrandService;

@RestController
public class BrandController {
     
	@Autowired
	BrandService brandService;
	
	@CrossOrigin("*")
	@PostMapping("/brand")
	public Brand createBand(@RequestBody Brand brand ) {
		
		return brandService.createBand(brand);
		
	}
	
	@CrossOrigin("*")
	@GetMapping("/brand")
	public List<Brand> getBrand(){
		return brandService.findallbrand();
		}
	
	@CrossOrigin("*")
	@DeleteMapping("/brand/{id}")
	public void deleteBrand(@PathVariable Integer id) {
		brandService.deleteBrand(id);
	}
}
