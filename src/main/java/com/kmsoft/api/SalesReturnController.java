package com.kmsoft.api;

import javax.transaction.Transactional;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kmsoft.model.ProductUpdateHistory;
import com.kmsoft.model.PurchaseBill;
import com.kmsoft.model.SalesReturn;
import com.kmsoft.service.ProductService;
import com.kmsoft.service.ProductUpdateHistoryService;
import com.kmsoft.service.PurchaseBillProductService;
import com.kmsoft.service.SalesReturnService;

@RestController
public class SalesReturnController {
	
	@Autowired
	SalesReturnService salesReturnService;
	
	@Autowired
	ProductService productservice;
	
	@Autowired
	ProductUpdateHistoryService productUpdateHistoryService;
	
	@Autowired
	PurchaseBillProductService purchaseBillProductService;
	

	

	
	@CrossOrigin("*")
	@GetMapping("/salesreturn/referenceNo")
	@ResponseBody
	public String getReferenceNumber() {

		return salesReturnService.getRefNo();
	}
	
	@CrossOrigin("*")
	@PostMapping("/submitsalesreturn")
	@Transactional(rollbackOn = { Exception.class })
	public SalesReturn submitsalesreturn(@RequestBody String data1) throws Exception{
	
		
		String sb=data1;
		System.out.println(sb);
	ObjectMapper objectMapper=new ObjectMapper();
	JSONObject jsonObject=new JSONObject(sb);
	
	JSONArray updateQtyArray=jsonObject.getJSONArray("updateQtyArray");
	JSONArray  updateHistroryArray=jsonObject.getJSONArray("updateHistroryArray");
	JSONArray updateBatchQty=jsonObject.getJSONArray("updateBatchQty");
	
	SalesReturn h=new SalesReturn();
	
	try {
		 h=objectMapper.readValue(jsonObject.get("headerData").toString(), SalesReturn.class);
		
		
		
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
		
		for(Object batchQty:updateBatchQty) {
		 int id;
		 String qty;
		 JSONObject o=(JSONObject) batchQty;
		 id=o.getInt("pbpid");
		 qty=o.get("availableqty").toString();
		 purchaseBillProductService.updatAvailableQty(id, qty);
		 
		 
		}
		return salesReturnService.createSalesReturn(h);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		throw new Exception(e);
	}
}
}
