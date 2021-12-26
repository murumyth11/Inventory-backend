package com.kmsoft.api;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kmsoft.model.BalanceUpdateHistory;
import com.kmsoft.service.BalanceUpdateHistoryService;

@RestController
public class BalanceUpdateController {
	
	@Autowired
	BalanceUpdateHistoryService balanceUpdateHistoryService;
	
	@CrossOrigin("*")
	@PostMapping("/balanceupdate")
	public  BalanceUpdateHistory saveBalanceUpdate(@RequestBody BalanceUpdateHistory balanceupdatehistory)
	{ 
		return balanceUpdateHistoryService.CreateBalanceUpdate(balanceupdatehistory);
	}
	@CrossOrigin("*")
	@GetMapping("/balanceupdate")
	public Page<List<Map<String,Object>>> getBalanceUpdateHistory(@RequestParam(required = false) String title, @RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size)
	{
		
		Page<List<Map<String,Object>>> data;
		 Pageable paging = PageRequest.of(page, size);
		if(title==null) {
			data=balanceUpdateHistoryService.findAllBuh(paging);
		}
		else {
			data=balanceUpdateHistoryService.getBysearch(title, paging);
			
		}
		return data;
	}

}
