package com.kmsoft.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kmsoft.model.Billproduct;
import com.kmsoft.model.Customer;
import com.kmsoft.repository.BillRepository;
import com.kmsoft.repository.CustomerRepository;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerRepository customerRepo;
	
	@Autowired
	BillRepository billRepo;
	
	@CrossOrigin("*")
	@PostMapping("/customers")
	public Customer createCustomer(@RequestBody Customer customer) {
		return customerRepo.save(customer);
	}

	@CrossOrigin("*")
	@GetMapping("/customers")
	public List<Customer> getCustomer() {
		return customerRepo.findAll();
	}
	
	@CrossOrigin("*")
	@DeleteMapping("/customer/{id}")
	public void deleteCustomer(@PathVariable Integer id)
	{
		customerRepo.deleteById(id);
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/customers/{namelike}")
	public List<Customer> getCustomerLike(@PathVariable String namelike){
		return customerRepo.getCustomerLike(namelike);
	}
		
}
