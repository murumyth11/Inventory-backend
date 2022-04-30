package com.kmsoft.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.kmsoft.model.Customer;
import com.kmsoft.model.Vendors;

public interface Vendorservice {

	public Vendors createVendors(Vendors vendors);
	public Vendors fetchByVendorMobile(String vendorMobile);
	public Page<Vendors> getAllVendors(Pageable paging);
	public Page<Vendors> findByVendorNameContaining(String title, Pageable paging);
	public void deleteById(int id);
	public List<Vendors> getVendorLike(String namelike);
	public void deleteVendorsById(int id);
	
}
