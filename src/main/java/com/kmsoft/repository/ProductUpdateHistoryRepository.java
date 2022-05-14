package com.kmsoft.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kmsoft.model.ProductUpdateHistory;

public interface ProductUpdateHistoryRepository extends JpaRepository<ProductUpdateHistory, Integer>{

	@Query(value="SELECT sum(update_quantity) FROM product_update_history where updatefrom='sales'",nativeQuery=true)
	int getSTockSold();
	
	@Query(value="select * from product_update_history where product_fk=:id order by update_history_id desc ",
			countQuery =  "SELECT count(*) from product_update_history where product_fk=:id ",nativeQuery=true)
	Page<List<ProductUpdateHistory>> findAllById(int id,Pageable pageable);
	
	@Query(value="select * from product_update_history where product_fk=:id and (update_date like %:title% or update_data like %:title%  or updatefrom like %:title% or update_by like %:title%)order by  update_history_id desc",
			countQuery =  "SELECT count(*) from product_update_history where product_fk=:id",nativeQuery=true)
	Page<List<ProductUpdateHistory>> findByUpdateDateContaining(String title,int id,Pageable pageable);
}
