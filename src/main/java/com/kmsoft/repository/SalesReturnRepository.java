package com.kmsoft.repository;

import com.kmsoft.model.SalesReturn;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesReturnRepository extends JpaRepository<SalesReturn, Integer> {

	@Query(value = "SELECT ifnull(MAX(salesreturnno),'SR000000') FROM sales_return",nativeQuery = true)
	String getRefNo();

	@Query(value ="select * from sales_return where date like :title or billed_by like :title or salesreturnno like :title or paymentmethod like :title or "
			+ " customer_fk in(select customer_id from customer where customer_name like :title or customer_phone like :title) order by sales_return_id desc",nativeQuery = true)
	Page<SalesReturn> findBySalesReturnContaining(String title, Pageable paging);

	@Query(value = "select * from sales_return where sales_return_id=:id",nativeQuery = true)
	SalesReturn getSalesReturnById(int id);

}
