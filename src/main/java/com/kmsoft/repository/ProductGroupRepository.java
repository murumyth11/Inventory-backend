package com.kmsoft.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.kmsoft.model.ProductGroup;

public interface ProductGroupRepository extends JpaRepository<ProductGroup, Integer>{

	
	@Modifying
	@Transactional
	@Query(value = "update product_group set isalivegroup=0 where product_group_id=:id",nativeQuery = true)
	void deletegroupbyId(int id);

	@Query(value = "select * from product_group where isalivegroup=1",nativeQuery = true)
	List<ProductGroup> findAllgroup();

}
