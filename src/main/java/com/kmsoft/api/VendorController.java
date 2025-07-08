package com.kmsoft.api;

import com.kmsoft.model.Vendors;
import com.kmsoft.service.Vendorservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class VendorController {
	
	@Autowired
	Vendorservice vendorservice;
	
	//@CrossOrigin("*")
	@PostMapping("/vendors")
	public Vendors createVendors(@RequestBody Vendors vendors) throws Exception {
		vendors.setIsalivevendor(1);
		try {return vendorservice.createVendors(vendors);}
		catch (Exception e) {
			throw new Exception("vendor with phone already exists");
		}
		
	}
	
	//@CrossOrigin("*")
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
	
	//@CrossOrigin("*")
	@PutMapping("/deletevendors")
	public void deleteCustomer(@RequestParam int id)
	{
		vendorservice.deleteVendorsById(id);
	}
	//@CrossOrigin("*")
	@GetMapping("/vendors/{namelike}")
	public List<Vendors> getVendorLike(@PathVariable String namelike){
		return vendorservice.getVendorLike(namelike);
	}
	


}
