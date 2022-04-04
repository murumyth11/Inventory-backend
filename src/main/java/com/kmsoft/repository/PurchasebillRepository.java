package com.kmsoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kmsoft.model.PurchaseBill;

@Repository
public interface PurchasebillRepository extends JpaRepository<PurchaseBill, Integer> {

	 @Query(value="SELECT ifnull(MAX(pbno),'R000000') FROM purchasebill",nativeQuery=true)
	 String getHeaderbillInvNo();
}
