package com.kmsoft.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kmsoft.model.HeaderBill;
import com.kmsoft.model.ProductUpdateHistory;
import com.kmsoft.service.HeaderBillService;
import com.kmsoft.service.ProductService;
import com.kmsoft.service.ProductUpdateHistoryService;
import jakarta.transaction.Transactional;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;


@RestController
public class BillController  {

	@Autowired
	HeaderBillService headerbillService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	ProductUpdateHistoryService productUpdateHistoryService;
	
	
	//@CrossOrigin("*")
	@PostMapping("/headerbill")
	public HeaderBill createheaderBill(@RequestBody HeaderBill headerbill) {
		return headerbillService.createHeaderBill(headerbill);
		

	}

	//@CrossOrigin("*")
	@GetMapping("/headerbill")
	public Page<HeaderBill> getAllHeaderbills(@RequestParam(required = false) String title,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "2") int size) {

		Pageable paging = PageRequest.of(page, size);
		Page<HeaderBill> pageTuts;

		if (title == null) {
			
			pageTuts = headerbillService.findAllByOrderByHeaderBillIdDesc(paging);

		} else {
			
			pageTuts = headerbillService.findByInvoiceContaining(title, paging);
		}
		return pageTuts;

	}

	//@CrossOrigin("*")
	@GetMapping("/headerbill/{startDate}/{endDate}")
	public Page<HeaderBill> getData_between(
			@PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy hh:mm a") Date startDate,
			@PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy hh:mm a") Date endDate,
			@RequestParam(required = false) String title, @RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "2") int size) {
		Pageable paging = PageRequest.of(page, size);
		Page<HeaderBill> pageTuts;
		// System.out.println(title);
		if (title == null) {
			
			pageTuts = headerbillService.getAllBetweenDates(startDate, endDate, paging);

		} else {
			
			pageTuts = headerbillService.getAllBetweenDatesContaining(startDate, endDate, title, paging);
		}
		return pageTuts;
	}

	//@CrossOrigin("*")
	@GetMapping("/headerbill/draft")
	public List<HeaderBill> getdraftbill() {

		return headerbillService.getDraftBill();
	}

	//@CrossOrigin("*")
	@DeleteMapping("/headerbill/draft/{id}")
	public void deletedraftbill(@PathVariable Integer id) {
		headerbillService.deleteDraftbillByid(id);
	}

	//@CrossOrigin("*")
	@GetMapping("/headerbill/bydate/{startDate}/{endDate}")
	public List<Map<String,Object>> getbillbydate(@PathVariable  @DateTimeFormat(pattern = "dd-MM-yyyy hh:mm a") Date startDate,
			@PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy hh:mm a") Date endDate ) {
		return headerbillService.getbillbydates(startDate,endDate);
	}

	
	
	//@CrossOrigin("*")
	@GetMapping("/headerbill/invoiceNo")
	public int getInvoiceNumber() {

		return headerbillService.getHeaderbillInvNo();
	}

	
	//@CrossOrigin("*")
	@GetMapping("/headerbill/details")
	public Map<String,Object> getHeaderBillDetails(@RequestParam(required = false)  @DateTimeFormat(pattern = "dd-MM-yyyy hh:mm a") Date startdate, @RequestParam(required = false
	)  @DateTimeFormat(pattern = "dd-MM-yyyy hh:mm a") Date enddate){
		if(startdate==null && enddate==null) {
			return headerbillService.getHeaderbillDetails();
		}
		else {
		return headerbillService.getHeaderbillDetailsDate(startdate, enddate);
		}
	}
	
	//@CrossOrigin("*")
	@PutMapping("/headerbill/{id}")
	public HeaderBill updateHeaderBill(@PathVariable int id,@RequestBody HeaderBill headerbill) {
		return headerbillService.updateHeaderBill(headerbill);
	}
	
	//@CrossOrigin("*")
	@PostMapping("/submitBill")
	@Transactional(rollbackOn = { Exception.class})
	public HeaderBill submitBill(@RequestBody String sb) throws Exception{
	
	ObjectMapper objectMapper=new ObjectMapper();
	JSONObject jsonObject=new JSONObject(sb);
	
	JSONArray updateQtyArray=jsonObject.getJSONArray("updateQtyArray");
	JSONArray  updateHistroryArray=jsonObject.getJSONArray("updateHistroryArray");
     HeaderBill h=new HeaderBill();
	try {
		 h=objectMapper.readValue(jsonObject.get("headerData").toString(), HeaderBill.class);
		
		
		int i=0,j=0;
		for(Object qtyData:updateQtyArray)
		{
			i++;
			int id;
			String qty;
			String updatefrom;
			int batch;
			String batchqty;
			JSONObject o=(JSONObject) qtyData;
			id=o.getInt("id");
			
		    qty=o.get("q").toString();
		    updatefrom=o.get("updatefrom").toString();
		    batch=(int) o.get("batchid");
		    batchqty=o.get("batchqty").toString();
		    productService.updateProductQuantity(id, qty,updatefrom);
		    productService.updatebatchQuantity(id,batchqty,batch);
		    
			}
		for(Object updatehistory:updateHistroryArray) {
			
		j++;
			ProductUpdateHistory productUpdateHistory=objectMapper.readValue(updatehistory.toString(), ProductUpdateHistory.class);
			productUpdateHistoryService.createProductUpdateHistory(productUpdateHistory);
		}
		 return  headerbillService.createHeaderBill(h);
		
	} catch (Exception e) {
		
		throw new Exception(e);
	}
	 
	
	} 
	
	//@CrossOrigin("*")
	@GetMapping("/customerproducts")
	
	public Page<List<Map<String, Object>>> getHeaderbillsCustomer(@RequestParam(required = false,defaultValue = " ") String title,
			@RequestParam int page, @RequestParam int size,
			@RequestParam int id){
		
		Pageable paging = PageRequest.of(page, size);
		Page<List<Map<String, Object>>> pageTuts;

		
           if (title == null) {
			
			pageTuts = headerbillService.getHeaderbillCustomers(title,id, paging);

		} else {
			
			pageTuts =headerbillService.getHeaderbillCustomers(title,id, paging);
		}
		
		return pageTuts;
	}
	
	//@CrossOrigin("*")
	@GetMapping("/customerbilldetails")
	public Map<String,Object> getCustomerbilldetails(@RequestParam int id){
		return headerbillService.customerbilldetails(id);
	}
	
	//@CrossOrigin("*")
	@GetMapping("/customerbatchproduct")
	public List<Map<String,Object>> getCustomerBatchProduct(@RequestParam int cid,@RequestParam int pid){
		return headerbillService.getcustomerbatchproduct(cid,pid);
	}

	@GetMapping("/testService")
	public String getTestService()
	{
		return  "test_successfully";
	}

	
	
	
}
