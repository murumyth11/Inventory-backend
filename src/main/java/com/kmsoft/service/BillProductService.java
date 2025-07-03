package com.kmsoft.service;

import com.kmsoft.model.Billproduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;
import java.util.Map;


public interface BillProductService {

	public Billproduct createbillproduct(Billproduct billproduct);
	
	public List<Billproduct> findall();
	
	public Page<List<Map<String, Object>>> getSaleByDateProduct(Date startDate, Date endDate,Pageable paging);
	
	public Page<List<Map<String, Object>>> getSaleByDateProductTitle(Date startDate, Date endDate,String title,Pageable paging);
	
	public Map<String,Number> getTotalSoldQuantity(int id);

	public Page<List<Map<String, Object>>> getTopMovingProductsBydate(Date startDate, Date endDate, String title,
			Pageable paging);

	public Page<List<Map<String, Object>>> getTopMovingProducts(String title, Pageable paging);

	
}
