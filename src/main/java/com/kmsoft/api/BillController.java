package com.kmsoft.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kmsoft.model.Billproduct;
import com.kmsoft.model.HeaderBill;
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
	public Billproduct createBillBody( @RequestBody Billproduct billProduct){
		return billproductRepo.save(billProduct);
		
	}
	
	@CrossOrigin("*")
	@GetMapping("/billproduct")
	public List<Billproduct> getBillProduct(){
		return billproductRepo.findAll();
	}

	@CrossOrigin("*")
	@PostMapping("/headerbill")
	public HeaderBill createheaderBill( @RequestBody HeaderBill headerbill){
		return headerbillRepo.save(headerbill);
		
	}
	
	@CrossOrigin("*")
	@GetMapping("/headerbill")
	public List<HeaderBill> getheaderBill(){
		return headerbillRepo.findAll();
	}
}
