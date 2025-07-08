package com.kmsoft.api;

import com.kmsoft.model.Customer;
import com.kmsoft.repository.BillRepository;
import com.kmsoft.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerRepository customerRepo;
	
	@Autowired
	BillRepository billRepo;
	
	//@CrossOrigin("*")
	@PostMapping("/customers")
	public Customer createCustomer(@RequestBody Customer customer) throws Exception {
		customer.setIsalive(1);
		try {return customerRepo.save(customer);}
		catch (Exception e) {
			throw new Exception("customer with phone already exists");
		}
		
	}


	//@CrossOrigin("*")
	  @GetMapping("/customers")
	  public Page<Customer> getAllcustomers(
	        @RequestParam(required = false) String title,
	        @RequestParam(defaultValue = "0") int page,
	        @RequestParam(defaultValue = "2") int size
	      ) {
		  List<Customer> tutorials = new ArrayList<Customer>();
	      Pageable paging = PageRequest.of(page, size);
	      Page<Customer> pageTuts;
	      
	      
	      if(title==null)
	      {pageTuts = customerRepo.findAll(paging);
	      System.out.println(title);
	      }
	      else
	      {   String stitle = "%" + title + "%";
	    	  pageTuts=customerRepo.findByCustomerNameContaining(stitle, paging);}
	      return pageTuts;
	     
	  }
	
	//@CrossOrigin("*")
	@PutMapping("/customerIsAlive")
	public void deleteCustomer(@RequestParam String id)
	{
		customerRepo.deletecustomers(id);
	}
	
	//@CrossOrigin("*")
	@GetMapping("/customers/{namelike}")
	public List<Customer> getCustomerLike(@PathVariable String namelike){
		String snamelike = "%" + namelike + "%";
		return customerRepo.getCustomerLike(snamelike);
	}
	//@CrossOrigin("*")
	@GetMapping("/customersPhone/{custPhone}")
	public Customer getCustomerPhone(@PathVariable String custPhone){
		return customerRepo.getCustomerPhone(custPhone);
	}
	
	//@CrossOrigin("*")
	@GetMapping("/getcustomerbyid/{id}")
	public Optional<Customer> getCustomerById(@PathVariable int id) {
		return customerRepo.findById(id);
	}
		
}
