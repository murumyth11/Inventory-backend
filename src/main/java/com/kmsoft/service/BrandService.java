package com.kmsoft.service;

import com.kmsoft.model.Brand;

import java.util.List;

public interface BrandService {

	public Brand createBand(Brand brand);
	
	public List<Brand> findallbrand();
	
	public void deleteBrand(int id);
	
	
	
	
}
