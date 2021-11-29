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
	List<Product> findById(int id);
	
	//Product findByProductName(String name);
	
	@Query(value="SELECT * FROM product WHERE product_name LIKE :productlike%",nativeQuery = true)
	List<Product> getProductLike(@Param("productlike") String productlike);
	
	@Query(value="SELECT * FROM product WHERE product_quantity <=10",nativeQuery=true)
	List<Product> getLowStock();
	
	@Query(value="SELECT SUM(product_quantity) FROM product",nativeQuery=true)
	int getStockinHand();
	
	@Query(value="SELECT COUNT(*) FROM product",nativeQuery=true)
	int getTotalproduct();
	
	 Page<Product> findAll(Pageable pageable);
	
	 @Query(value="SELECT * FROM product WHERE product_name LIKE %:title%"+" OR product_quantity LIKE %:title% "
	 +" OR product_group_fk LIKE %:title% "
			 +" OR primaryunit LIKE %:title% "
	 +" OR entry_date LIKE %:title% "
			 +" OR selling_price LIKE %:title% "+" OR cost_price LIKE %:title% "+" OR manufacturer LIKE %:title% "+
			 " OR brand LIKE %:title% "
	 
			 ,nativeQuery = true)
	 Page<Product> findByProductNameContaining(String title,Pageable pageable);

	List<Product> findByProductName(String name);
	
	@Modifying
  @Transactional 
	@Query(value="update product set product_quantity=product_quantity-:qty where product_id=:id",nativeQuery=true)
	void updateProductQuantity(int id,String qty);
	@Query(value="select p.product_name as PNAME,concat(ifnull((sum(b.converted_quantity)+p.product_quantity),p.product_quantity),' ',p.primaryunit) as tpq,p.primaryunit as unit,concat(ifnull(round(sum(b.converted_quantity*p.unitconversion)),0),' ',p.secondaryunit) as"
			+ " tqs,concat(round(p.product_quantity*p.unitconversion),' ',p.secondaryunit) as instock from product p left join billproduct b on p.product_id=b.product_fk group by product_id",countQuery =  "SELECT count(*) FROM product",nativeQuery=true)
	Page<List<Map<String,Object>>> getInventoryReport(Pageable pageable);
	
	@Query(value="select p.product_name as PNAME,concat(ifnull((sum(b.converted_quantity)+p.product_quantity),p.product_quantity),' ',p.primaryunit) as tpq,p.primaryunit as unit,concat(ifnull(round(sum(b.converted_quantity*p.unitconversion)),0),' ',p.secondaryunit) as"
			+ " tqs,concat(round(p.product_quantity*p.unitconversion),' ',p.secondaryunit) as instock from product p left join billproduct b on p.product_id=b.product_fk where p.product_name like %:title% group by product_id"
			,countQuery =  "SELECT count(*) FROM product",nativeQuery=true)
	Page<List<Map<String,Object>>> getInventoryReportTitle(String title,Pageable pageable);
	
	
	
	
}
