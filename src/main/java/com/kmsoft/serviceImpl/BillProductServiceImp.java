package com.kmsoft.serviceImpl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kmsoft.model.Billproduct;
import com.kmsoft.repository.BillproductRepository;
import com.kmsoft.service.BillProductService;

@Service
public class BillProductServiceImp implements BillProductService{

	@Autowired
	BillproductRepository billproductRepo;
	
	@Override
	public Billproduct createbillproduct(Billproduct billproduct) {
		// TODO Auto-generated method stub
		return billproductRepo.save(billproduct);
	}

	@Override
	public List<Billproduct> findall() {
		// TODO Auto-generated method stub
		return billproductRepo.findAll();
	}

	@Override
	public Page<List<Map<String, Object>>> getSaleByDateProduct(Date startDate, Date endDate, Pageable paging) {
		// TODO Auto-generated method stub
		return billproductRepo.getSaleByDateProduct(startDate, endDate, paging);
	}

	@Override
	public Page<List<Map<String, Object>>> getSaleByDateProductTitle(Date startDate, Date endDate, String title,
			Pageable paging) {
		// TODO Auto-generated method stub
		return billproductRepo.getSaleByDateProductTitle(startDate, endDate, title, paging);
	}

	@Override
	public Map<String, Number> getTotalSoldQuantity(int id) {
		// TODO Auto-generated method stub
		return billproductRepo.getTotalSoldQuantity(id);
	}

}
