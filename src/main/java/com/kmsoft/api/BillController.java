package com.kmsoft.api;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kmsoft.model.Billproduct;
import com.kmsoft.model.HeaderBill;
import com.kmsoft.model.Product;
import com.kmsoft.repository.BillproductRepository;
import com.kmsoft.repository.HeaderBillRepository;

@RestController
public class BillController {

	@Autowired
	BillproductRepository billproductRepo;

	@Autowired
	HeaderBillRepository headerbillRepo;

	@CrossOrigin("*")
	@PostMapping("/billproduct")
	public Billproduct createBillBody(@RequestBody Billproduct billProduct) {
		return billproductRepo.save(billProduct);

	}

	@CrossOrigin("*")
	@GetMapping("/billproduct")
	public List<Billproduct> getBillProduct() {
		return billproductRepo.findAll();
	}

	@CrossOrigin("*")
	@PostMapping("/headerbill")
	public HeaderBill createheaderBill(@RequestBody HeaderBill headerbill) {
		return headerbillRepo.save(headerbill);

	}

	@CrossOrigin("*")
	@GetMapping("/headerbill")
	public Page<HeaderBill> getAllHeaderbills(@RequestParam(required = false) String title,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "2") int size) {

		Pageable paging = PageRequest.of(page, size);
		Page<HeaderBill> pageTuts;

		if (title == null) {
			System.out.println("null");
			pageTuts = headerbillRepo.findAllByOrderByHeaderBillIdDesc(paging);

		} else {
			System.out.println("have ttl");
			pageTuts = headerbillRepo.findByInvoiceContaining(title, paging);
		}
		return pageTuts;

	}

	@CrossOrigin("*")
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
			System.out.println("null");
			pageTuts = headerbillRepo.getAllBetweenDates(startDate, endDate, paging);

		} else {
			System.out.println("havr title");
			pageTuts = headerbillRepo.getAllBetweenDatesContaining(startDate, endDate, title, paging);
		}
		return pageTuts;
	}

	@CrossOrigin("*")
	@GetMapping("/headerbill/draft")
	public List<HeaderBill> getdraftbill() {

		return headerbillRepo.getDraftBill();
	}

	@CrossOrigin("*")
	@DeleteMapping("/headerbill/draft/{id}")
	public void deleteCustomer(@PathVariable Integer id) {
		headerbillRepo.deleteById(id);
	}

	@CrossOrigin("*")
	@GetMapping("/headerbill/bydate/{date}")
	public List<HeaderBill> getbillbydate(@PathVariable String date) {
		return headerbillRepo.getbillbydate(date);
	}

	@CrossOrigin("*")
	@GetMapping("/headerbill/invoiceNo")
	public int getInvoiceNumber() {

		return headerbillRepo.getHeaderbillInvNo();
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
				System.out.println("null");
				
				data= billproductRepo.getSaleByDateProduct(startDate, endDate,paging);
				

			} else {
				System.out.println("havr title");
				data = billproductRepo.getSaleByDateProductTitle(startDate, endDate, title,paging);
				
			

		} 
		return data;

	}
}
