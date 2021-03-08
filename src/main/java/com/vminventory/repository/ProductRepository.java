package com.vminventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vminventory.model.Product;



@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
