package com.kmsoft.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.kmsoft.model.Billproduct;
import com.kmsoft.model.PurchaseBillProduct;
import com.kmsoft.service.PurchaseBillProductService;

public class PurchaseBillProductController {
	
	@Autowired
	PurchaseBillProductService pbservice;
	
	@CrossOrigin("*")
	@PostMapping("/purchasebillproduct")
	public PurchaseBillProduct createPurchaseBillBody(@RequestBody PurchaseBillProduct billProduct) {
		return pbservice.createpbp(billProduct);
		}


}
