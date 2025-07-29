package com.kmsoft.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kmsoft.model.ProductUpdateHistory;
import com.kmsoft.model.PurchaseBill;
import com.kmsoft.service.ProductService;
import com.kmsoft.service.ProductUpdateHistoryService;
import com.kmsoft.service.PurchasebillService;
import jakarta.transaction.Transactional;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

@RestController
public class PurchasebillController {
	
	@Autowired
	PurchasebillService pbservice;
	
	@Autowired
	ProductService productservice;
	
	@Autowired
	ProductUpdateHistoryService productUpdateHistoryService;
	
	//@CrossOrigin("*")
	@GetMapping("/purchasebill/referenceNo")
	@ResponseBody
	public String getReferenceNumber() {

		return pbservice.getRefNo();
	}
	
	//@CrossOrigin("*")
	@PutMapping("/savepurchasebill")
	public void updatepurchasebill(@RequestBody String data) {

	JSONObject jsonObject=new JSONObject(data);
	 int id=jsonObject.getInt("id");
	 BigDecimal balance=jsonObject.getBigDecimal("balance");
	 BigDecimal amountdebit=jsonObject.getBigDecimal("amountdebit");
	 String status=jsonObject.getString("status");
	 pbservice.updatePurchaseBill(id,balance,amountdebit,status);
	 
	}
	
	//@CrossOrigin("*")
	@PatchMapping("/submit")
	@Transactional(rollbackOn = { Exception.class })
	public PurchaseBill submitBill(@RequestPart String data1 ,@RequestPart(required = false) MultipartFile img) throws Exception{
	
		
		String sb=data1;
	ObjectMapper objectMapper=new ObjectMapper();
	JSONObject jsonObject=new JSONObject(sb);
	
	JSONArray updateQtyArray=jsonObject.getJSONArray("updateQtyArray");
	JSONArray  updateHistroryArray=jsonObject.getJSONArray("updateHistroryArray");
	
	PurchaseBill h=new PurchaseBill();
	
	try {
		 h=objectMapper.readValue(jsonObject.get("headerData").toString(), PurchaseBill.class);
		 if(img!=null)
		 { h.setPurchaseimage(img.getBytes());}
		pbservice.createPurchaseBill(h);
		

		for(Object qtyData:updateQtyArray)
		{

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
			

			ProductUpdateHistory productUpdateHistory=objectMapper.readValue(updatehistory.toString(), ProductUpdateHistory.class);
			productUpdateHistoryService.createProductUpdateHistory(productUpdateHistory);
		}
		return pbservice.createPurchaseBill(h);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		throw new Exception(e);
	}
	
	
	
	
	} 
	
	//@CrossOrigin("*")
	@GetMapping("/purchasebill")
	public Page<PurchaseBill> getAllHeaderbills(@RequestParam(required = false) String title,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "2") int size) {

		Pageable paging = PageRequest.of(page, size);
		Page<PurchaseBill> pageTuts;

		if (title == null) {
			
			pageTuts = pbservice.findAllByOrderByPurchaseBillIdDesc(paging);

		} else {
			
			pageTuts = pbservice.findBypurchasebillContaining(title, paging);
		}
		return pageTuts;

	}
	
	//@CrossOrigin("*")
	@GetMapping("/pbid")
	public PurchaseBill getpurchasebillId(@RequestParam int id) {
		return pbservice.getpurchasebillbyid(id);
	}
	
	//@CrossOrigin("*")
	@GetMapping("/purchasehardcopy")
	public byte[] getimage(@RequestParam int id) {
		return pbservice.getimage(id);
		
	}
	

}
