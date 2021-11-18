package com.kmsoft.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kmsoft.model.Customer;
import com.kmsoft.model.Product;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
	@Query(value="SELECT * FROM  customer WHERE customer_name LIKE %:custlike% OR customer_phone LIKE %:custlike% ",nativeQuery = true)
	List<Customer> getCustomerLike(String custlike);
	
	 Page<Customer> findAll(Pageable pageable);
	 
	 @Query(value="SELECT * FROM customer WHERE customer_name LIKE %:title%"+" OR customer_phone LIKE %:title% "
			 +" OR customer_email LIKE %:title% "
					 +" OR customer_address LIKE %:title% "
							 ,nativeQuery = true)
	 Page<Customer> findByCustomerNameContaining(String title,Pageable pageable);

}
