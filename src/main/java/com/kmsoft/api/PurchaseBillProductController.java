package com.kmsoft.api;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kmsoft.model.Billproduct;
import com.kmsoft.model.ProductUpdateHistory;
import com.kmsoft.model.PurchaseBillProduct;
import com.kmsoft.service.PurchaseBillProductService;

@RestController
public class PurchaseBillProductController {
	
	@Autowired
	PurchaseBillProductService pbservice;
	
	@CrossOrigin("*")
	@PostMapping("/purchasebillproduct")
	public PurchaseBillProduct createPurchaseBillBody(@RequestBody PurchaseBillProduct billProduct) {
		if(billProduct.getBatch()==null) {
			billProduct.setBatch("");
		}
		return pbservice.createpbp(billProduct);
		}

	
	@CrossOrigin("*")
	@GetMapping("/purchasebillproduct/{id}")
	public List<PurchaseBillProduct> getpbpById(@PathVariable int id){
		return pbservice.getpbpbyid(id);
		
	}
	
	
	
	
	@CrossOrigin("*")
	@GetMapping("/batchcode")
	public List<PurchaseBillProduct> getbatchcode(@RequestParam int id){
		return pbservice.getbatchcode(id);
	}
	
	@CrossOrigin("*")
	@GetMapping("/batchcodePW")
	public Page<PurchaseBillProduct> getBatchDetails(
			 @RequestParam int id,
		 @RequestParam(defaultValue="") String title,
		
	        @RequestParam(defaultValue = "0") int page,
	        @RequestParam(defaultValue = "5") int size
	      ) {
		 Pageable paging = PageRequest.of(page, size);
	      Page<PurchaseBillProduct> pageTuts;
	      
	      if(title=="")
	     
	      { 
	    	  pageTuts = pbservice.findAllBatchById(id,paging);
	      
	      return pageTuts;}
	     
	      else
	      {
	    	  System.out.println("have ttl"+title);
	    	  pageTuts=pbservice.findByBatchContaining(title,id, paging);
	      return pageTuts;}
		
	}

	@CrossOrigin("*")
	@GetMapping("/availableqty")
	public PurchaseBillProduct getAvailableqty(
			@RequestParam int id) {
				return pbservice.getavailableqty(id);
		
	}
	
	@CrossOrigin("*")
	@GetMapping("/totalstockinfo")
	public Map<String, Number> getTotalStockValue(){
		return pbservice.gettotalstockinfo();
		
	}
	
	
	

}
