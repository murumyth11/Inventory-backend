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

import com.kmsoft.model.Billproduct;

@Repository
public interface BillproductRepository  extends JpaRepository<Billproduct, Integer>{

	
	@Query(value="select sum(b.amount) as totalsaleamount,\r\n"
			+ "sum(b.converted_quantity) as totalsoldquantity ,\r\n"
			+ "sum(b.converted_quantity)+p.product_quantity as tpq,\r\n"
			+ "(sum(b.converted_quantity)+p.product_quantity)*p.cost_price as tpp from billproduct b, product p where product_fk=:id and product_id=:id",nativeQuery=true)
	Map<String,Number> getTotalSoldQuantity(int id);
	
	 @Query(value="select sum(b.amount) as tsa,sum(b.converted_quantity) as tsq,sum(b.quantity*b.rate-b.amount) as dis,p.product_name,\r\n"
		 		+ "sum(b.amount-b.converted_quantity*p.cost_price) as totalgain ,g.product_group_name as pg , p.brand as brand from billproduct b join product p on p.product_id=b.product_fk "
		 		+ " left join product_group g on g.product_group_id=p.product_group_fk where headerbill_fk in(select header_bill_id from header_bill where date"
		 		+ ">= :startDate AND date <= :endDate) and (p.product_name like %:title% or p.brand like %:title% or g.product_group_name like %:title% ) group by b.product_fk ",
		 		countQuery =  "select  count(*) from  (select count(*) from billproduct group by product_fk ) as c",nativeQuery=true)
		 Page<List<Map<String,Object>>> getSaleByDateProductTitle(@Param("startDate") Date startDate, @Param("endDate") Date endDate,String title,Pageable pageable);

	@Query(value="select sum(b.amount) as tsa,sum(b.converted_quantity) as tsq,sum(b.quantity*b.rate-b.amount) as dis,p.product_name,\r\n"
	 		+ "sum(b.amount-b.converted_quantity*p.cost_price) as totalgain,g.product_group_name as pg , p.brand as brand  from billproduct b left join product p on p.product_id=b.product_fk "
	 		+ " left join product_group g on g.product_group_id=p.product_group_fk where headerbill_fk in(select header_bill_id from header_bill where date"
	 		+ ">= :startDate AND date <= :endDate)  group by b.product_fk ",
	 		countQuery =  "select  count(*) from  (select count(*) from billproduct group by product_fk ) as c",nativeQuery=true)
	Page<List<Map<String,Object>>> getSaleByDateProduct(@Param("startDate") Date startDate, @Param("endDate") Date endDate,Pageable pageable);
 }
