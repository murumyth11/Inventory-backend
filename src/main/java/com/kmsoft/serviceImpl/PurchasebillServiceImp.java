package com.kmsoft.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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



	@Override
	public Page<PurchaseBill> findAllByOrderByPurchaseBillIdDesc(Pageable paging) {
		// TODO Auto-generated method stub
		return pbRepo.findAllByOrderByPurchaseBillIdDesc(paging);
	}



	@Override
	public Page<PurchaseBill> findBypurchasebillContaining(String title, Pageable paging) {
		// TODO Auto-generated method stub
		return pbRepo.findByPurchaseBillContaining(title, paging);
	}



	@Override
	public PurchaseBill getpurchasebillbyid(int id) {
		// TODO Auto-generated method stub
		return pbRepo.getpurchasebillbyid(id);
	}
}
