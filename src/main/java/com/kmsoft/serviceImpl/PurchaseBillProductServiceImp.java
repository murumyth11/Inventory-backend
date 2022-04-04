package com.kmsoft.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
