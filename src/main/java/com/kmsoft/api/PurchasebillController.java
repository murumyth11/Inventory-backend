package com.kmsoft.api;

import javax.transaction.Transactional;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kmsoft.model.HeaderBill;
import com.kmsoft.model.ProductUpdateHistory;
import com.kmsoft.model.PurchaseBill;
import com.kmsoft.service.ProductService;
import com.kmsoft.service.ProductUpdateHistoryService;
import com.kmsoft.service.PurchasebillService;

@RestController
public class PurchasebillController {
	
	@Autowired
	PurchasebillService pbservice;
	
	@Autowired
	ProductService productservice;
	
	@Autowired
	ProductUpdateHistoryService productUpdateHistoryService;
	
	@CrossOrigin("*")
	@GetMapping("/purchasebill/referenceNo")
	@ResponseBody
	public String getReferenceNumber() {

		return pbservice.getRefNo();
	}
	
	@CrossOrigin("*")
	@PatchMapping("/submit")
	@Transactional(rollbackOn = { Exception.class })
	public void submitBill(@RequestBody String sb){
	
	ObjectMapper objectMapper=new ObjectMapper();
	JSONObject jsonObject=new JSONObject(sb);
	
	JSONArray updateQtyArray=jsonObject.getJSONArray("updateQtyArray");
	JSONArray  updateHistroryArray=jsonObject.getJSONArray("updateHistroryArray");
	
	try {
		PurchaseBill h=objectMapper.readValue(jsonObject.get("headerData").toString(), PurchaseBill.class);
		pbservice.createPurchaseBill(h);
		
		int i=0,j=0;
		for(Object qtyData:updateQtyArray)
		{
			i++;
			int id;
			String qty;
			String updatefrom;
			
			JSONObject o=(JSONObject) qtyData;
			id=o.getInt("id");
		    qty=o.get("q").toString();
		    updatefrom=o.getString("updatefrom");
		    productservice.updateProductQuantity(id, qty,updatefrom);
		    
			}
		for(Object updatehistory:updateHistroryArray) {
			
		j++;
			ProductUpdateHistory productUpdateHistory=objectMapper.readValue(updatehistory.toString(), ProductUpdateHistory.class);
			productUpdateHistoryService.createProductUpdateHistory(productUpdateHistory);
		}
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	} 
	

}
