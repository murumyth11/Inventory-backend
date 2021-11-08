package com.kmsoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kmsoft.model.ProductUpdateHistory;

public interface ProductUpdateHistoryRepository extends JpaRepository<ProductUpdateHistory, Integer>{

	@Query(value="SELECT sum(update_quantity) FROM product_update_history where update_from='bill'",nativeQuery=true)
	int getSTockSold();
}
