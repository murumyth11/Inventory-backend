package com.kmsoft.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kmsoft.model.Billproduct;
import com.kmsoft.model.PurchaseBillProduct;
import com.kmsoft.service.PurchaseBillProductService;

@RestController
public class PurchaseBillProductController {
	
	@Autowired
	PurchaseBillProductService pbservice;
	
	@CrossOrigin("*")
	@PostMapping("/purchasebillproduct")
	public PurchaseBillProduct createPurchaseBillBody(@RequestBody PurchaseBillProduct billProduct) {
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

}
