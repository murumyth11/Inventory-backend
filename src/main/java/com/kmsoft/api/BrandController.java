package com.kmsoft.api;

import com.kmsoft.model.Brand;
import com.kmsoft.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
