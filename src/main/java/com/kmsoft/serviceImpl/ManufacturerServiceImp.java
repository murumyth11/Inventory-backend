package com.kmsoft.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kmsoft.model.Manufacturer;
import com.kmsoft.repository.ManufacturerRepository;
import com.kmsoft.service.ManufacturerService;

@Service
public class ManufacturerServiceImp implements ManufacturerService {
    
	@Autowired
	ManufacturerRepository manuRepo;
	
	@Override
	public Manufacturer createManufacturer(Manufacturer manufacturer) {
		// TODO Auto-generated method stub
		return manuRepo.save(manufacturer);
	}

	@Override
	public List<Manufacturer> getManufacturer() {
		// TODO Auto-generated method stub
		return manuRepo.findAll();
	}

	@Override
	public void deleteManufacturer(int id) {
		// TODO Auto-generated method stub
		manuRepo.deleteById(id);
	}

}
