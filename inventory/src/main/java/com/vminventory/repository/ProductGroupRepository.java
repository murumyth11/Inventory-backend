package com.vminventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vminventory.model.ProductGroup;

public interface ProductGroupRepository extends JpaRepository<ProductGroup, Integer>{

}
