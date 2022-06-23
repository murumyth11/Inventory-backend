package com.kmsoft.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

	@Override
	public Page<SalesReturn> findBySalesReturnContaining(String title, Pageable paging) {
		// TODO Auto-generated method stub
		return salesReturnRepo.findBySalesReturnContaining(title,paging);
	}

	@Override
	public SalesReturn getSalesReturnByid(int id) {
		// TODO Auto-generated method stub
		return salesReturnRepo.getSalesReturnById(id);
	}

}
