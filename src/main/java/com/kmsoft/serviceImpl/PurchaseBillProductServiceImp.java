package com.kmsoft.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kmsoft.model.ProductUpdateHistory;
import com.kmsoft.model.PurchaseBillProduct;
import com.kmsoft.repository.PurchaseBillProductRepository;
import com.kmsoft.service.PurchaseBillProductService;

@Service
public class PurchaseBillProductServiceImp implements PurchaseBillProductService {

	@Autowired
	PurchaseBillProductRepository pbpRepo;
	
	@Override
	public PurchaseBillProduct createpbp(PurchaseBillProduct billProduct) {
		// TODO Auto-generated method stub
		return pbpRepo.save(billProduct) ;
	}

	@Override
	public List<PurchaseBillProduct> getpbpbyid(int id) {
		// TODO Auto-generated method stub
		return pbpRepo.findAllbyid(id);
		
	}

	@Override
	public List<PurchaseBillProduct> getbatchcode(int id) {
		// TODO Auto-generated method stub
		return pbpRepo.getbatchcode(id);
	}

	@Override
	public Page<PurchaseBillProduct> findAllBatchById(int id, Pageable paging) {
		// TODO Auto-generated method stub
		return pbpRepo.findAllBatchById(id,paging);
	}

	@Override
	public Page<PurchaseBillProduct> findByBatchContaining(String title, int id, Pageable paging) {
		// TODO Auto-generated method stub
		return pbpRepo.findByIdContaining(title,id,paging);
	}

	@Override
	public PurchaseBillProduct getavailableqty(int id) {
		// TODO Auto-generated method stub
		return pbpRepo.getavailableqty(id);
	}

	@Override
	public Map<String, Number> gettotalstockinfo() {
		// TODO Auto-generated method stub
		return pbpRepo.gettotalstockinfo();
	}

}
