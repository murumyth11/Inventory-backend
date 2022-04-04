package com.kmsoft.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kmsoft.model.PurchaseBill;
import com.kmsoft.repository.PurchasebillRepository;
import com.kmsoft.service.PurchasebillService;

@Service
public class PurchasebillServiceImp implements PurchasebillService {

	
	@Autowired
	PurchasebillRepository pbRepo;

	

	@Override
	public String getRefNo() {
		// TODO Auto-generated method stub
		return pbRepo.getHeaderbillInvNo();
	}



	@Override
	public void createPurchaseBill(PurchaseBill h) {
		// TODO Auto-generated method stub
		pbRepo.save(h);
		
	}
}
