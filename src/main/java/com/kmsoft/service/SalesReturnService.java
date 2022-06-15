package com.kmsoft.service;

import org.springframework.stereotype.Service;

import com.kmsoft.model.SalesReturn;


public interface SalesReturnService {

	String getRefNo();

	public SalesReturn createSalesReturn(SalesReturn h);

}
