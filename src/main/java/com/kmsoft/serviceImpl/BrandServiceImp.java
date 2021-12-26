package com.kmsoft.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kmsoft.model.Brand;
import com.kmsoft.repository.BrandRepository;
import com.kmsoft.service.BrandService;

@Service
public class BrandServiceImp implements BrandService {
    
	@Autowired 
	BrandRepository brandRepo;
	@Override
	public Brand createBand(Brand brand) {
		// TODO Auto-generated method stub
		return brandRepo.save(brand);
	}

	@Override
	public List<Brand> findallbrand() {
		// TODO Auto-generated method stub
		return brandRepo.findAll();
	}

	@Override
	public void deleteBrand(int id) {
		// TODO Auto-generated method stub
		brandRepo.deleteById(id);
		
	}

}
