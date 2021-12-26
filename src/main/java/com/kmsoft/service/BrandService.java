package com.kmsoft.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.kmsoft.model.Brand;

public interface BrandService {

	public Brand createBand(Brand brand);
	
	public List<Brand> findallbrand();
	
	public void deleteBrand(int id);
	
	
	
	
}
