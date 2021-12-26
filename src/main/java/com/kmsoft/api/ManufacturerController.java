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

import com.kmsoft.model.Manufacturer;
import com.kmsoft.service.ManufacturerService;

@RestController
public class ManufacturerController {

	@Autowired
	ManufacturerService manufacturerService;
	
	@CrossOrigin("*")	
	@PostMapping("/manufacturer")
	public Manufacturer createManufacturer(@RequestBody Manufacturer manufacturer) {
		return manufacturerService.createManufacturer(manufacturer);
	}
	
	
	@CrossOrigin("*")
	@GetMapping("/manufacturer")
	public List<Manufacturer> getManufacturer(){
		return  manufacturerService.getManufacturer();
	}
	
	@CrossOrigin("*")
	@DeleteMapping("/manufacturer/{id}")
	public void deleteManufacturer(@PathVariable Integer id)
	{
		manufacturerService.deleteManufacturer(id);
	}
}
