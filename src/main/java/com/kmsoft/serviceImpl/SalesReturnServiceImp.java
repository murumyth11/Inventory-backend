package com.kmsoft.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kmsoft.model.SalesReturn;
import com.kmsoft.repository.SalesReturnRepository;
import com.kmsoft.service.SalesReturnService;

@Service
public class SalesReturnServiceImp implements SalesReturnService {
@Autowired
SalesReturnRepository salesReturnRepo;
	
	@Override
	public String getRefNo() {
		// TODO Auto-generated method stub
		return salesReturnRepo.getRefNo();
	}

	@Override
	public SalesReturn createSalesReturn(SalesReturn h) {
		return salesReturnRepo.saveAndFlush(h);
		
	}

}
