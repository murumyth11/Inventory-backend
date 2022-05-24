package com.kmsoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kmsoft.model.Shop;

public interface ShopRepository extends JpaRepository<Shop, Integer> {

}
