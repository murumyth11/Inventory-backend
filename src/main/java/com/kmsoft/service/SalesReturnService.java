package com.kmsoft.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kmsoft.model.PurchaseBill;
import com.kmsoft.model.SalesReturn;


public interface SalesReturnService {

	String getRefNo();

	public SalesReturn createSalesReturn(SalesReturn h);

	public Page<SalesReturn> findBySalesReturnContaining(String title, Pageable paging);

	public SalesReturn getSalesReturnByid(int id);

}
