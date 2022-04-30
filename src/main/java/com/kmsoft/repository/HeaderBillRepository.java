package com.kmsoft.repository;

import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.kmsoft.model.HeaderBill;

public interface HeaderBillRepository extends JpaRepository<HeaderBill, Integer> {

	@Query(value = "SELECT * FROM Header_bill WHERE date >= :startDate AND date <= :endDate ORDER BY date DESC", nativeQuery = true)
	Page<HeaderBill> getAllBetweenDates(@Param("startDate") Date startDate, @Param("endDate") Date endDate,Pageable pageable);
	
	@Query(value = "SELECT * FROM Header_bill WHERE date >= :startDate AND date <= :endDate AND "+" customer LIKE %:title%"
			, nativeQuery = true)
	Page<HeaderBill> getAllBetweenDatesContaining(@Param("startDate") Date startDate, @Param("endDate") Date endDate,String title,Pageable pageable);
	
	@Query(value="SELECT * FROM Header_bill WHERE isdraft=1",nativeQuery=true)
	List<HeaderBill> getDraftBill();

	@Query(value="select  p.product_name as name,sum(b.amount) as amount ,sum(b.converted_quantity*p.unitconversion) as quantity, p.secondaryunit as unit from header_bill h  join( billproduct b join  product p on b.product_fk=p.product_id)   on b.headerbill_fk=h.header_bill_id where h.date>= :startDate AND h.date <= :endDate AND h.isdraft=0 group by p.product_name",nativeQuery=true)
	List<Map<String, Object>> getbillbydate(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
	
	 Page<HeaderBill> findAllByOrderByHeaderBillIdDesc(Pageable pageable);
		
	 @Query(value="SELECT * FROM header_bill WHERE customer LIKE %:title%"+" OR invoice LIKE %:title% "
	 +" OR subtotal LIKE %:title% "
			 +" OR total LIKE %:title% "
	 +" OR phone LIKE %:title%  or status like  %:title%  or balance like %:title% or billed_by like %:title% ORDER BY header_bill_id DESC"
				 ,nativeQuery = true)
	 Page<HeaderBill> findByInvoiceContaining(String title,Pageable pageable);
	
	 @Query(value="SELECT ifnull(MAX(invoice),0) FROM header_bill WHERE isdraft=0",nativeQuery=true)
	 int getHeaderbillInvNo();
	 
	 @Query(value="select count(*) as totalbill,sum(totalquantity) as totalqty,sum(total) as total,count(distinct customer_fk) as cust,ifnull(sum(balance) ,0)as balance from header_bill "
	 		+ "where date >= :startDate AND date <= :endDate AND isdraft=0",nativeQuery=true)
	 Map<String,Object> getHeaderbillDetailsDate(Date startDate,Date endDate);
	 
	 @Query(value="select count(*) as totalbill,sum(totalquantity) as totalqty,sum(total) as total,count(distinct customer_fk) as cust from header_bill "
		 		+ "where isdraft=0",nativeQuery=true)
		 Map<String,Object> getHeaderbillDetails();

	 
	
	
}