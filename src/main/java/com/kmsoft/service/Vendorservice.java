package com.kmsoft.service;

import com.kmsoft.model.Vendors;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface Vendorservice {

	public Vendors createVendors(Vendors vendors);
	public Vendors fetchByVendorMobile(String vendorMobile);
	public Page<Vendors> getAllVendors(Pageable paging);
	public Page<Vendors> findByVendorNameContaining(String title, Pageable paging);
	public void deleteById(int id);
	public List<Vendors> getVendorLike(String namelike);
	public void deleteVendorsById(int id);
	
}
