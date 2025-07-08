package com.kmsoft.api;

import com.kmsoft.model.Manufacturer;
import com.kmsoft.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ManufacturerController {

	@Autowired
	ManufacturerService manufacturerService;
	
	//@CrossOrigin("*")
	@PostMapping("/manufacturer")
	public Manufacturer createManufacturer(@RequestBody Manufacturer manufacturer) {
		return manufacturerService.createManufacturer(manufacturer);
	}
	
	
	//@CrossOrigin("*")
	@GetMapping("/manufacturer")
	public List<Manufacturer> getManufacturer(){
		return  manufacturerService.getManufacturer();
	}
	
	//@CrossOrigin("*")
	@DeleteMapping("/manufacturer/{id}")
	public void deleteManufacturer(@PathVariable Integer id)
	{
		manufacturerService.deleteManufacturer(id);
	}
}
