package com.kmsoft.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.kmsoft.model.BalanceUpdateHistory;

public interface BalanceUpdateHistoryService {

	
	public BalanceUpdateHistory CreateBalanceUpdate(BalanceUpdateHistory balanceupdatehistory);
	
	public  Page<List<Map<String,Object>>> findAllBuh(Pageable pageable);
	
	public Page<List<Map<String,Object>>> getBysearch(String title,Pageable pageable);

	public Page<List<Map<String, Object>>> getBysearchPurchase(String title, Pageable paging);

	public Page<List<Map<String, Object>>> getBysearchSalesReturn(String title, Pageable paging);
}
