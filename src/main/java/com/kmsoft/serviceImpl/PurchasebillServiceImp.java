package com.kmsoft.serviceImpl;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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



	@Override
	public byte[] getimage(int id) {
		// TODO Auto-generated method stub
		PurchaseBill pb = pbRepo.findById(id).get();
		byte[] image = pb.getPurchaseimage();
		
	    
	    return image;
	}
	@Override
	public PurchaseBill createPurchaseBill(PurchaseBill h) {
		// TODO Auto-generated method stub
		return pbRepo.save(h);
	}







	@Override
	public void updatePurchaseBill(int id, BigDecimal balance, BigDecimal amountdebit, String status) {
		
//		PurchaseBill pb=pbRepo.findById(id).get();
//		System.out.println(pb.getPbNo());
//		pb.setAmountdebit(amountdebit);
//		pb.setBalance(balance);
//		pb.setStatus(status);
		System.out.println(id+" "+balance+" "+amountdebit+" "+status);
		pbRepo.updatePurchaseBill(id,balance,amountdebit,status);
		
		
	}
	
}
