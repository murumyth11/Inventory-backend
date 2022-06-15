package com.kmsoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kmsoft.model.SalesReturn;

@Repository
public interface SalesReturnRepository extends JpaRepository<SalesReturn, Integer> {

	@Query(value = "SELECT ifnull(MAX(salesreturnno),'SR000000') FROM sales_return",nativeQuery = true)
	String getRefNo();

}
