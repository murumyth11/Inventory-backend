package com.kmsoft.api;

import com.kmsoft.model.Billproduct;
import com.kmsoft.service.BillProductService;
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
public class BillproductController {
	
	@Autowired
	BillProductService billproductService;
	
	
	@CrossOrigin("*")
	@PostMapping("/billproduct")
	public Billproduct createBillBody(@RequestBody Billproduct billProduct) {
		return billproductService.createbillproduct(billProduct);
		

	}

	@CrossOrigin("*")
	@GetMapping("/billproduct")
	public List<Billproduct> getBillProduct() {
		return billproductService.findall();
	}
	
	@CrossOrigin("*")
	@GetMapping("/salesByDate/{startDate}/{endDate}")
	public Page<List<Map<String, Object>>> getProductSaleByDate(
			@PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy hh:mm a") Date startDate,
			@PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy hh:mm a") Date endDate,
			@RequestParam(required = false) String title, @RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size) {

		 Page<List<Map<String, Object>>> data;
		
			 Pageable paging = PageRequest.of(page, size);
			
			
			if (title == null) {
				
				
				data= billproductService.getSaleByDateProduct(startDate, endDate,paging);
				

			} else {
				
				data = billproductService.getSaleByDateProductTitle(startDate, endDate, title,paging);
				
			

		} 
		return data;

	}
	
	@CrossOrigin("*")
	@GetMapping("/soldquantity")
	public Map<String,Number> getTotalSoldQuantity(@RequestParam() int id) {
		
		return  billproductService.getTotalSoldQuantity(id);
	}
	
	
	@CrossOrigin("*")
	@GetMapping("/topMovingProductsByDate")
	public Page<List<Map<String, Object>>> getTopMovingByDate(
			@RequestParam(required =false) @DateTimeFormat(pattern = "dd-MM-yyyy hh:mm a") Date startDate,
			@RequestParam(required = false) @DateTimeFormat(pattern = "dd-MM-yyyy hh:mm a") Date endDate,
			@RequestParam(required = false) String title, @RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size) {

		 Page<List<Map<String, Object>>> data;
		
			 Pageable paging = PageRequest.of(page, size);
			
			
			
				if(startDate==null && endDate==null) {
					data=billproductService.getTopMovingProducts(title, paging);
				}
				else {
				data = billproductService.getTopMovingProductsBydate(startDate, endDate, title,paging);
				}
				
			

		
		return data;

	}

	
	
	
	
	
	


}
