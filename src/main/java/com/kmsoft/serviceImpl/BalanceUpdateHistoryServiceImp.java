package com.kmsoft.serviceImpl;

import com.kmsoft.model.BalanceUpdateHistory;
import com.kmsoft.repository.BalanceUpdateHistoryRepository;
import com.kmsoft.service.BalanceUpdateHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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
		String stitle = "%" + title + "%";
		return balanceupdateRepo.getbySearch(stitle, pageable);
	}

	@Override
	public Page<List<Map<String, Object>>> getBysearchPurchase(String title, Pageable paging) {
		// TODO Auto-generated method stub
		String stitle = "%" + title + "%";
		return balanceupdateRepo.getbySearchPurchase(stitle, paging);
	}

	@Override
	public Page<List<Map<String, Object>>> getBysearchSalesReturn(String title, Pageable paging) {
		// TODO Auto-generated method stub
		String stitle = "%" + title + "%";
		return balanceupdateRepo.getbySearchSalesReturn(stitle, paging);
	}

}
