package com.kmsoft.api;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.kmsoft.model.Billproduct;
import com.kmsoft.service.BillProductService;

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
		System.out.println(id);
		return  billproductService.getTotalSoldQuantity(id);
	}
	

}
