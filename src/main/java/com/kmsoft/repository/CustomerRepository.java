package com.kmsoft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kmsoft.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
	@Query(value="SELECT * FROM  customer WHERE customer_name like %:custlike%",nativeQuery = true)
	List<Customer> getCustomerLike(@Param("custlike")  String custlike);

}
