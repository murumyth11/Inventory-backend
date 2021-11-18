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

import com.kmsoft.model.Product;



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
	 +" OR product_key LIKE %:title% "
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
}
