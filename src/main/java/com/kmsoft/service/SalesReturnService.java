package com.kmsoft.service;

import com.kmsoft.model.SalesReturn;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface SalesReturnService {

	String getRefNo();

	public SalesReturn createSalesReturn(SalesReturn h);

	public Page<SalesReturn> findBySalesReturnContaining(String title, Pageable paging);

	public SalesReturn getSalesReturnByid(int id);

}
