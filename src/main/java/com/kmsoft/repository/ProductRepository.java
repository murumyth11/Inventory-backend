package com.kmsoft.repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.kmsoft.model.Product;
import com.kmsoft.model.ProductUpdateHistory;



@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	@Query(value="select * from product where product_id=:id ",nativeQuery=true)
	Product findById(int id);
	
	
	//Product findByProductName(String name);
	
	@Query(value="SELECT * FROM product WHERE (product_name LIKE :productlike% or product_key like :productlike%) and isaliveproduct=1",nativeQuery = true)
	List<Product> getProductLike(@Param("productlike") String productlike);
	
	@Query(value="SELECT * FROM product WHERE (product_key LIKE :productKeylike%) and isaliveproduct=1",nativeQuery = true)
	List<Product> getProductKeyLike(@Param("productKeylike") String productKeylike);
	
	@Query(value="SELECT * FROM product WHERE product_quantity*unitconversion <=10 and isaliveproduct=1",nativeQuery=true)
	List<Product> getLowStock();
	
	@Query(value="SELECT ifnull(SUM(availablequantity),0) FROM purchase_bill_product",nativeQuery=true)
	int getStockinHand();
	
	@Query(value="SELECT COUNT(*) FROM product",nativeQuery=true)
	int getTotalproduct();
	
	 Page<Product> findAll(Pageable pageable);
	
	 @Query(value="SELECT * FROM product WHERE (product_name LIKE %:title%"+" OR product_quantity LIKE %:title% "
	 +" OR product_group_fk LIKE %:title% "
			 +" OR primaryunit LIKE %:title% "
	 +" OR entry_date LIKE %:title% "
			 +" OR selling_price LIKE %:title% "+" OR cost_price LIKE %:title% "+" OR manufacturer LIKE %:title% "+
			 " OR brand LIKE %:title% ) and isaliveproduct=1"
	 
			 ,nativeQuery = true)
	 Page<Product> findByProductNameContaining(String title,Pageable pageable);

	List<Product> findByProductName(String name);
	
	@Modifying
    @Transactional 
	@Query(value="update product set product_quantity= if(:updatefrom='sales',product_quantity-:qty,product_quantity+:qty) where product_id=:id",nativeQuery=true)
	void updateProductQuantityLess(int id,String qty,String updatefrom);
	
	@Modifying
    @Transactional 
	@Query(value="update product set product_quantity=product_quantity+:qty where product_id=:id",nativeQuery=true)
	void updateProductQuantityMore(int id,String qty);
	
	
	
	
	@Query(value="select p.product_name as PNAME,concat(ifnull((sum(b.converted_quantity)+p.product_quantity),p.product_quantity),' ',p.primaryunit) as tpq,p.primaryunit as unit,concat(ifnull(round(sum(b.converted_quantity*p.unitconversion)),0),' ',p.secondaryunit) as"
			+ " tqs,concat(round(p.product_quantity*p.unitconversion),' ',p.secondaryunit) as instock from product p left join billproduct b on p.product_id=b.product_fk group by p.product_id",countQuery =  "select count(*) from (SELECT count(*) FROM product p left join billproduct b on p.product_id=b.product_fk group by p.product_id) as c",nativeQuery=true)
	Page<List<Map<String,Object>>> getInventoryReport(Pageable pageable);
	
	@Query(value="select p.product_name as PNAME,g.product_group_name as group1,p.brand as brand,concat(ifnull((sum(b.converted_quantity*p.unitconversion)+p.product_quantity*p.unitconversion),p.product_quantity*p.unitconversion),' ',p.secondaryunit) as tpq,p.primaryunit as unit,(ifnull(round(sum(b.converted_quantity*p.unitconversion)),0)) as"
			+ " tqs,(round(p.product_quantity*p.unitconversion)) as instock from product p left join billproduct b on p.product_id=b.product_fk left join product_group g on g.product_group_id=p.product_group_fk where p.product_name like %:title%  or p.brand like %:title% or g.product_group_name like %:title% group by p.product_id"
			,countQuery =  " select count(*) from (SELECT count(*) FROM product  p left join billproduct b on p.product_id=b.product_fk group by p.product_id) as c",nativeQuery=true)
	Page<List<Map<String,Object>>> getInventoryReportTitle(String title,Pageable pageable);


	
	@Modifying
	@Transactional
	@Query(value = "update product set isaliveproduct=0 where product_id=:id",nativeQuery = true)
	void deleteProductsById(int id);
	
	@Query(value = "select p.* from product p left outer join billproduct b on p.product_id=b.product_fk where p.product_quantity > 0 group by b.product_fk order by count(b.product_fk)desc limit 10;",nativeQuery = true)
	List<Product> getTopMovingproducts();
	
	
	
	
}
