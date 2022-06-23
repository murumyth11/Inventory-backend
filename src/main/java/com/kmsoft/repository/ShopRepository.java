package com.kmsoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kmsoft.model.Shop;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Integer> {

	
	
	@Query(value = "select to_base64(aes_encrypt(':shop','kmsoft123')) as enc;",nativeQuery = true)
	Shop saveshop(Shop shop);
}
