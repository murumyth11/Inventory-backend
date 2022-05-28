package com.kmsoft.repository;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kmsoft.model.ProductUpdateHistory;
import com.kmsoft.model.PurchaseBillProduct;

@Repository
public interface PurchaseBillProductRepository extends JpaRepository<PurchaseBillProduct, Integer> {

	
	@Query(value = "select * from purchasebillproduct where purchasebill_fk=:id",nativeQuery = true)
	List<PurchaseBillProduct> findAllbyid(int id);

	
	@Query(value = "select * from purchasebillproduct where product_fk=:id order by pbp_id desc",nativeQuery = true)
	List<PurchaseBillProduct> getbatchcode(int id);

	
	@Modifying
    @Transactional 
	@Query(value = "update purchasebillproduct set availablequantity=availablequantity - :qty where batch=:batch and product_fk=:id",nativeQuery = true)
	void updateBatchQuantity(int id,String qty,String batch);


	@Query(value = "select * from purchasebillproduct where product_fk=:id order by pbp_id desc",nativeQuery = true)
	Page<PurchaseBillProduct> findAllBatchById(int id, Pageable paging);


	@Query(value = "select * from purchasebillproduct where product_fk=:id and batch like %:title% order by pbp_id desc",nativeQuery = true)
	Page<PurchaseBillProduct> findByIdContaining(String title, int id, Pageable paging);

  @Query(value = "select * from purchasebillproduct where pbp_id=:id ",nativeQuery = true)
	PurchaseBillProduct getavailableqty(int id);


  @Query(value = "select ifnull(sum(p.availablequantity),0) as currentstockquantity,ifnull((sum(p.amount)-b.amount),sum(p.amount)) as currentstockvalue from purchasebillproduct p join product pt on p.product_fk=pt.product_id cross join (select sum(amount) as amount from billproduct) b where pt.isaliveproduct=1",nativeQuery = true)
Map<String, Number> gettotalstockinfo();

  @Modifying
  @Transactional 
  @Query(value="update purchasebillproduct set availablequantity=availablequantity + :qty where pbp_id=:id",nativeQuery = true)
void updateAvailableqty(int id, String qty);


  @Modifying
  @Transactional 
	@Query(value = "update purchasebillproduct set rate=:rate where pbp_id=:pbpid1",nativeQuery = true)
	void updateRate(int pbpid1, String rate);
}
