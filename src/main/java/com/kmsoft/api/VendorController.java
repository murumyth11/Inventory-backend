package com.kmsoft.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kmsoft.model.Customer;
import com.kmsoft.model.Vendors;
import com.kmsoft.repository.VendorRepository;
import com.kmsoft.service.Vendorservice;

@RestController
public class VendorController {
	
	@Autowired
	Vendorservice vendorservice;
	
	@CrossOrigin("*")
	@PostMapping("/vendors")
	public Vendors createVendors(@RequestBody Vendors vendors) throws Exception {
		vendors.setIsalivevendor(1);
		try {return vendorservice.createVendors(vendors);}
		catch (Exception e) {
			throw new Exception("vendor with phone already exists");
		}
		
	}
	
	@CrossOrigin("*")
	  @GetMapping("/vendors")
	  public Page<Vendors> getAllVendors(
	        @RequestParam(required = false) String title,
	        @RequestParam(defaultValue = "0") int page,
	        @RequestParam(defaultValue = "2") int size
	      ) {
		  List<Vendors> tutorials = new ArrayList<Vendors>();
	      Pageable paging = PageRequest.of(page, size);
	      Page<Vendors> pageTuts;
	      
	      
	      if(title==null)
	      {pageTuts = vendorservice.getAllVendors(paging);
	      System.out.println(title);
	      }
	      else
	      {pageTuts=vendorservice.findByVendorNameContaining(title, paging);}
	      return pageTuts;
	     
	  }
	
	@CrossOrigin("*")
	@PutMapping("/deletevendors")
	public void deleteCustomer(@RequestParam int id)
	{
		vendorservice.deleteVendorsById(id);
	}
	@CrossOrigin("*")
	@GetMapping("/vendors/{namelike}")
	public List<Vendors> getVendorLike(@PathVariable String namelike){
		return vendorservice.getVendorLike(namelike);
	}
	


}
