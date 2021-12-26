package com.kmsoft.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kmsoft.model.BalanceUpdateHistory;
import com.kmsoft.repository.BalanceUpdateHistoryRepository;
import com.kmsoft.service.BalanceUpdateHistoryService;

@Service
public class BalanceUpdateHistoryServiceImp implements BalanceUpdateHistoryService{

	@Autowired
	BalanceUpdateHistoryRepository balanceupdateRepo;
	
	@Override
	public BalanceUpdateHistory CreateBalanceUpdate(BalanceUpdateHistory balanceupdatehistory) {
		// TODO Auto-generated method stub
		return balanceupdateRepo.save(balanceupdatehistory) ;
	}

	@Override
	public Page<List<Map<String, Object>>> findAllBuh(Pageable pageable) {
		// TODO Auto-generated method stub
		return balanceupdateRepo.findAllbuh(pageable);
	}

	

	@Override
	public Page<List<Map<String, Object>>> getBysearch(String title, Pageable pageable) {
		// TODO Auto-generated method stub
		return balanceupdateRepo.getbySearch(title, pageable);
	}

}
