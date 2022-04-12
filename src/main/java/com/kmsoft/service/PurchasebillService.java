package com.kmsoft.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.kmsoft.model.PurchaseBill;

public interface PurchasebillService {

	public String getRefNo();

	public void createPurchaseBill(PurchaseBill h);

	public Page<PurchaseBill> findAllByOrderByPurchaseBillIdDesc(Pageable paging);

	public Page<PurchaseBill> findBypurchasebillContaining(String title, Pageable paging);

	public PurchaseBill getpurchasebillbyid(int id);

	
}
