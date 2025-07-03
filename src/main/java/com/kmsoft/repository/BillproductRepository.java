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
import com.kmsoft.model.Product;

@Repository
public interface BillproductRepository  extends JpaRepository<Billproduct, Integer>{

	
	@Query(value="select sum(b.amount) as totalsaleamount,\r\n"
			+ "sum(b.converted_quantity*p.unitconversion) as totalsoldquantity ,\r\n"
			+ "sum(b.converted_quantity*p.unitconversion)+(p.product_quantity*p.unitconversion) as tpq,\r\n"
			+ "(sum(b.converted_quantity)+p.product_quantity)*p.cost_price as tpp from billproduct b, product p where product_fk=:id and product_id=:id",nativeQuery=true)
	Map<String,Number> getTotalSoldQuantity(int id);
	
	 @Query(value="select sum(b.amount) as tsa,sum(b.converted_quantity*p.unitconversion) as tsq,sum(b.quantity*b.rate-b.amount) as dis,p.product_name,\r\n"
		 		+ "sum(b.amount-b.converted_quantity*p.cost_price) as totalgain ,g.product_group_name as pg , p.brand as brand from billproduct b join product p on p.product_id=b.product_fk "
		 		+ " left join product_group g on g.product_group_id=p.product_group_fk where headerbill_fk in(select header_bill_id from header_bill where date"
		 		+ ">= :startDate AND date <= :endDate) and (p.product_name like :title or p.brand like :title or g.product_group_name like :title ) group by b.product_fk ",
		 		countQuery =  "select count(*) from (select count(*) from billproduct  where headerbill_fk in(select header_bill_id from header_bill where date >= :startDate AND date <= :endDate) group by product_fk) as tab",nativeQuery=true)
		 Page<List<Map<String,Object>>> getSaleByDateProductTitle(@Param("startDate") Date startDate, @Param("endDate") Date endDate,String title,Pageable pageable);

	@Query(value="select sum(b.amount) as tsa,sum(b.converted_quantity) as tsq,sum(b.quantity*b.rate-b.amount) as dis,p.product_name,\r\n"
	 		+ "sum(b.amount-b.converted_quantity*p.cost_price) as totalgain,g.product_group_name as pg , p.brand as brand  from billproduct b left join product p on p.product_id=b.product_fk "
	 		+ " left join product_group g on g.product_group_id=p.product_group_fk where headerbill_fk in(select header_bill_id from header_bill where date"
	 		+ ">= :startDate AND date <= :endDate)  group by b.product_fk ",
	 		countQuery = "select count(*) from (select count(*) from billproduct  where headerbill_fk in(select header_bill_id from header_bill where date >= :startDate AND date <=:endDate) group by product_fk) as tab;",nativeQuery=true)
	Page<List<Map<String,Object>>> getSaleByDateProduct(@Param("startDate") Date startDate, @Param("endDate") Date endDate,Pageable pageable);

	@Query(value = "select * from product where product_id in(select * from(select product_fk from billproduct group by product_fk order by count( product_fk) desc limit 5) temp)",nativeQuery = true)
	List<Product> getTopMovingproducts();

	@Query(value = "select count( b.product_fk) as noOfBills, b.product_fk ,concat(sum(b.quantity),' ',b.unit) as soldqty,p.product_name,concat(p.product_quantity*p.unitconversion,' ',p.secondaryunit) as instock from (billproduct b join product p on b.product_fk=p.product_id ) join header_bill h on b.headerbill_fk=h.header_bill_id where h.date >=:startDate and h.date <= :endDate "
			+ " and (p.product_name like :title) group by b.product_fk order by count( b.product_fk) desc ",nativeQuery = true)
	Page<List<Map<String, Object>>> getTopMovingProductBydate(Date startDate, Date endDate, String title,
			Pageable paging);
	
	@Query(value = "select count( b.product_fk) as noOfBills, b.product_fk ,concat(sum(b.quantity),' ',b.unit) as soldqty,p.product_name,concat(p.product_quantity*p.unitconversion,' ',p.secondaryunit) as instock from (billproduct b join product p on b.product_fk=p.product_id ) join header_bill h on b.headerbill_fk=h.header_bill_id where "
			+ " (p.product_name like :title) group by b.product_fk order by count( b.product_fk) desc ",nativeQuery = true)
	Page<List<Map<String, Object>>> getTopMovingProduct(String title,Pageable paging);

	
 }
