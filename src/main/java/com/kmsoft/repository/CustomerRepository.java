package com.kmsoft.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.kmsoft.model.Customer;
import com.kmsoft.model.Product;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
	@Query(value="SELECT * FROM  customer WHERE (customer_name LIKE %:custlike% OR customer_phone LIKE %:custlike%) and is_alive=1 ",nativeQuery = true)
	List<Customer> getCustomerLike(String custlike);
	
	@Query(value = "select * from customer where is_alive=1",nativeQuery = true)
	 Page<Customer> findAll(Pageable pageable);
	 
	 @Query(value="SELECT * FROM customer WHERE (customer_name LIKE %:title%"+" OR customer_phone LIKE %:title% "
			 +" OR customer_email LIKE %:title% "
					 +" OR customer_address LIKE %:title%) and is_alive=1 "
							 ,nativeQuery = true)
	 Page<Customer> findByCustomerNameContaining(String title,Pageable pageable);

	 @Query(value="select * from customer where customer_phone=:custPhone",nativeQuery=true)
	Customer getCustomerPhone(String custPhone);

	 @Modifying
	    @Transactional 
	 @Query(value = "update customer set is_alive=0 where customer_id=:id",nativeQuery = true)
	void deletecustomers(String id);

	

}
