package com.kmsoft.repository;

import java.util.List;

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
}
