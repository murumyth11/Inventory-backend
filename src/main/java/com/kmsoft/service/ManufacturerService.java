package com.kmsoft.service;

import java.util.List;
import com.kmsoft.model.Manufacturer;

public interface ManufacturerService {

	public Manufacturer createManufacturer(Manufacturer manufacturer);
	
	public List<Manufacturer> getManufacturer();
	
	public void deleteManufacturer(int id);
}
