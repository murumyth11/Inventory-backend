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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kmsoft.model.BalanceUpdateHistory;
import com.kmsoft.model.Billproduct;
import com.kmsoft.model.HeaderBill;
import com.kmsoft.model.Product;
import com.kmsoft.repository.BalanceUpdateHistoryRepository;
import com.kmsoft.repository.BillproductRepository;
import com.kmsoft.repository.HeaderBillRepository;
import com.kmsoft.service.HeaderBillService;

@RestController
public class BillController {

	@Autowired
	HeaderBillService headerbillService;
	
	@CrossOrigin("*")
	@PostMapping("/headerbill")
	public HeaderBill createheaderBill(@RequestBody HeaderBill headerbill) {
		return headerbillService.createHeaderBill(headerbill);

	}

	@CrossOrigin("*")
	@GetMapping("/headerbill")
	public Page<HeaderBill> getAllHeaderbills(@RequestParam(required = false) String title,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "2") int size) {

		Pageable paging = PageRequest.of(page, size);
		Page<HeaderBill> pageTuts;

		if (title == null) {
			System.out.println("null");
			pageTuts = headerbillService.findAllByOrderByHeaderBillIdDesc(paging);

		} else {
			System.out.println("have ttl");
			pageTuts = headerbillService.findByInvoiceContaining(title, paging);
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
			pageTuts = headerbillService.getAllBetweenDates(startDate, endDate, paging);

		} else {
			System.out.println("havr title");
			pageTuts = headerbillService.getAllBetweenDatesContaining(startDate, endDate, title, paging);
		}
		return pageTuts;
	}

	@CrossOrigin("*")
	@GetMapping("/headerbill/draft")
	public List<HeaderBill> getdraftbill() {

		return headerbillService.getDraftBill();
	}

	@CrossOrigin("*")
	@DeleteMapping("/headerbill/draft/{id}")
	public void deletedraftbill(@PathVariable Integer id) {
		headerbillService.deleteDraftbillByid(id);
	}

	@CrossOrigin("*")
	@GetMapping("/headerbill/bydate/{startDate}/{endDate}")
	public List<HeaderBill> getbillbydate(@PathVariable  @DateTimeFormat(pattern = "dd-MM-yyyy hh:mm a") Date startDate,
			@PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy hh:mm a") Date endDate ) {
		return headerbillService.getbillbydates(startDate,endDate);
	}

	@CrossOrigin("*")
	@GetMapping("/headerbill/invoiceNo")
	public int getInvoiceNumber() {

		return headerbillService.getHeaderbillInvNo();
	}

	
	@CrossOrigin("*")
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
	
	@CrossOrigin("*")
	@PutMapping("/headerbill/{id}")
	public HeaderBill updateHeaderBill(@PathVariable int id,@RequestBody HeaderBill headerbill) {
		return headerbillService.updateHeaderBill(headerbill);
	}
	
	
	
}
