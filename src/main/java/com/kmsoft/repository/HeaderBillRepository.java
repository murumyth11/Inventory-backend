package com.kmsoft.repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kmsoft.model.HeaderBill;

public interface HeaderBillRepository extends JpaRepository<HeaderBill, Integer> {

	@Query(value = "SELECT * FROM Header_bill WHERE date >= :startDate AND date <= :endDate", nativeQuery = true)
	List<HeaderBill> getAllBetweenDates(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
	
	@Query(value="SELECT * FROM Header_bill WHERE isdraft=1",nativeQuery=true)
	List<HeaderBill> getDraftBill();
}
