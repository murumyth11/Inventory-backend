package com.kmsoft.service;

import com.kmsoft.model.PurchaseBill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;

public interface PurchasebillService {

	public String getRefNo();

	public PurchaseBill createPurchaseBill(PurchaseBill h);

	public Page<PurchaseBill> findAllByOrderByPurchaseBillIdDesc(Pageable paging);

	public Page<PurchaseBill> findBypurchasebillContaining(String title, Pageable paging);

	public PurchaseBill getpurchasebillbyid(int id);

	public byte[] getimage(int id);

	

	

	public void updatePurchaseBill(int id, BigDecimal balance, BigDecimal amountdebit, String status);

	
}
