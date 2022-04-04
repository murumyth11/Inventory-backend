package com.kmsoft.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kmsoft.model.Vendors;
import com.kmsoft.repository.VendorRepository;
import com.kmsoft.service.Vendorservice;

@Service
public class VendorServiceImp implements Vendorservice{

	@Autowired
	VendorRepository vendorRepo;
	
	@Override
	public Vendors fetchByVendorMobile(String vendorMobile) {
		// TODO Auto-generated method stub
		return vendorRepo.findByVendorMobile(vendorMobile);
	}

	@Override
	public Vendors createVendors(Vendors vendors) {
		// TODO Auto-generated method stub
		return vendorRepo.save(vendors);
	}

	@Override
	public Page<Vendors> getAllVendors(Pageable paging) {
		// TODO Auto-generated method stub
		return vendorRepo.findAll(paging);
	}

	@Override
	public Page<Vendors> findByVendorNameContaining(String title, Pageable paging) {
		// TODO Auto-generated method stub
		return vendorRepo.findByVendorNameContaining(title, paging);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		 vendorRepo.deleteById(id);;
		
	}

	@Override
	public List<Vendors> getVendorLike(String namelike) {
		// TODO Auto-generated method stub
		return vendorRepo.getvendorsLike(namelike);
	}

	

}
