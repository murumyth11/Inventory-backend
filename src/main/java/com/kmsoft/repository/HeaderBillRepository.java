package com.kmsoft.repository;

import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.kmsoft.model.HeaderBill;

@Repository
public interface HeaderBillRepository extends JpaRepository<HeaderBill, Integer> {

	@Query(value = "SELECT * FROM Header_bill WHERE date >= :startDate AND date <= :endDate ORDER BY date DESC", nativeQuery = true)
	Page<HeaderBill> getAllBetweenDates(@Param("startDate") Date startDate, @Param("endDate") Date endDate,Pageable pageable);
	
	@Query(value = "SELECT * FROM Header_bill WHERE date >= :startDate AND date <= :endDate  and (total like %:title% or status like  %:title% or customer like %:title% or invoice like %:title% or phone like %:title% or date like %:title% ) "
			, nativeQuery = true)
	Page<HeaderBill> getAllBetweenDatesContaining(@Param("startDate") Date startDate, @Param("endDate") Date endDate,String title,Pageable pageable);
	
	@Query(value="SELECT * FROM Header_bill WHERE isdraft=1",nativeQuery=true)
	List<HeaderBill> getDraftBill();

	@Query(value="select  p.product_name as name,sum(b.amount) as amount ,sum(b.converted_quantity*p.unitconversion) as quantity, p.secondaryunit as unit from header_bill h  join( billproduct b join  product p on b.product_fk=p.product_id)   on b.headerbill_fk=h.header_bill_id where h.date>= :startDate AND h.date <= :endDate AND h.isdraft=0 group by p.product_name",nativeQuery=true)
	List<Map<String, Object>> getbillbydate(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
	
	 Page<HeaderBill> findAllByOrderByHeaderBillIdDesc(Pageable pageable);
		
	 @Query(value="SELECT * FROM header_bill WHERE isdraft=0 and ( customer LIKE %:title%"+" OR invoice LIKE %:title% "
	 +" OR subtotal LIKE %:title% "
			 +" OR total LIKE %:title% "
	 +" OR phone LIKE %:title%  or status like  %:title%  or balance like %:title% or billed_by like %:title% or date like %:title% )ORDER BY header_bill_id DESC"
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

	 

	 
	 @Query(value = "select h.invoice,h.date,h.billed_by,p.product_name,b.code,b.batch,b.quantity,b.unit,b.rate,b.discount,b.amount  from header_bill h join (billproduct b join product p on p.product_id=b.product_fk) on h.header_bill_id=b.headerbill_fk where h.customer_fk=:cId and h.isdraft=0 and ( h.invoice like %:title% or h.date like %:title% or p.product_name like %:title% or b.amount like %:title% or h.billed_by like %:title% or b.batch like %:title% ) order by b.billproduct_id desc",countQuery = "select count(*) from billproduct b join (header_bill h join customer c on h.customer_fk=c.customer_id) on b.headerbill_fk=h.header_bill_id where c.customer_id=:cId and h.isdraft=0;",nativeQuery = true)
	 Page<List<Map<String, Object>>> getHeaderbillCustomer(String title,int cId, Pageable paging);

	 @Query(value="select sum(balance) as balance,sum(total) as total, sum(credit_amount) as creditamt,count(distinct invoice) as totalbill,sum(totalquantity) as qty from header_bill where customer_fk=:id",nativeQuery = true)
	Map<String, Object> customerbilldetails(int id);

	 
	 @Query(value="select b.batch,b.quantity,b.unit,b.rate,b.batchid  from header_bill h join (billproduct b join product p on p.product_id=b.product_fk) on h.header_bill_id=b.headerbill_fk where h.customer_fk=:cId and h.isdraft=0 and p.product_id=:pid",nativeQuery = true)
	 List<Map<String, Object>> getCustomerProductBatch(int cId,int pid);
	
	
}