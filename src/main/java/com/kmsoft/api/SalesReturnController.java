package com.kmsoft.api;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.kmsoft.model.ProductUpdateHistory;
import com.kmsoft.model.SalesReturn;
import com.kmsoft.service.ProductService;
import com.kmsoft.service.ProductUpdateHistoryService;
import com.kmsoft.service.PurchaseBillProductService;
import com.kmsoft.service.SalesReturnService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

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
	@jakarta.transaction.Transactional(rollbackOn = { Exception.class })
	public SalesReturn submitsalesreturn(@RequestBody String data1) throws Exception{
	
		
		String sb=data1;
		
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
	
	@CrossOrigin("*")
	@GetMapping("/salesreturn")
	public Page<SalesReturn> getAllSalesReturn(@RequestParam(required = false) String title,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "2") int size) {

		Pageable paging = PageRequest.of(page, size);
		Page<SalesReturn> pageTuts;

		if (title == null) {
			
			pageTuts = salesReturnService.findBySalesReturnContaining(title,paging);

		} else {
			
			pageTuts = salesReturnService.findBySalesReturnContaining(title,paging);
		}
		return pageTuts;

	}
	
	@CrossOrigin("*")
	@GetMapping("/salesreturnid")
	public SalesReturn getSalesReturnId(@RequestParam int id) {
		return salesReturnService.getSalesReturnByid(id);
	}
}
