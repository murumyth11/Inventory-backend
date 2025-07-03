package com.kmsoft.service;

import com.kmsoft.model.Manufacturer;

import java.util.List;

public interface ManufacturerService {

	public Manufacturer createManufacturer(Manufacturer manufacturer);
	
	public List<Manufacturer> getManufacturer();
	
	public void deleteManufacturer(int id);
}
