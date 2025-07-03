package com.kmsoft.api;

import com.kmsoft.model.Warehouse;
import com.kmsoft.repository.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WarehouseController {
	
	@Autowired
	WarehouseRepository warehouseRepo;
	
	@CrossOrigin("*")
	@PostMapping("/warehouse")
	public Warehouse createWarehouse(@RequestBody Warehouse warehouse)
	{
		return warehouseRepo.save(warehouse);
	}

	
	@CrossOrigin("*")
	@GetMapping("/warehouse")
	public List<Warehouse> getAllWarehouse()
	{
		return warehouseRepo.findAll();
		
	}
}
