package com.kmsoft.repository;

import java.math.BigDecimal;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kmsoft.model.HeaderBill;
import com.kmsoft.model.PurchaseBill;
import com.kmsoft.model.Vendors;

@Repository
public interface PurchasebillRepository extends JpaRepository<PurchaseBill, Integer> {

	 @Query(value="SELECT ifnull(MAX(pbno),'R000000') FROM purchase_bill",nativeQuery=true)
	 String getHeaderbillInvNo();
	 
	 Page<PurchaseBill> findAllByOrderByPurchaseBillIdDesc(Pageable pageable);
	 
//	 @Query(value="SELECT * FROM purchasebill WHERE pbno LIKE %:title%"+" OR pbentrydate LIKE %:title% "
//			 +" OR pbinvoicedate LIKE %:title% "
//					 +" OR total LIKE %:title% "
//			 +" OR taxamount LIKE %:title%  or charges like  %:title%  or billedby like %:title% or balance like %:title% or amountdebit"
//			 + " like %:title% or  like %:title%  or vendor_fk in (select vendor_id from vendors where vendor_name like %:title% )  ORDER BY header_bill_id DESC"
//						 ,nativeQuery = true)
	 @Query(value="select * from purchase_bill where pbNo like %:title% or pbinvoice like %:title% or billedBy like %:title% or "
	 		+ "pbEntryDate like %:title% or pbInvoiceDate like %:title% or  total like %:title% or balance like %:title% or "
	 		+ "vendor_fk in (select vendor_id from vendors where vendor_name like %:title% ) order by purchase_bill_id desc",nativeQuery =true)
			 Page<PurchaseBill> findByPurchaseBillContaining(String title,Pageable pageable);

	 @Query(value = "select * from purchase_bill where purchase_bill_id=:id",nativeQuery = true)
	PurchaseBill getpurchasebillbyid(int id);

	 
	 @Transactional
	 @Modifying
	 @Query(value = "update purchase_bill set balance=:balance,amountdebit=:amountdebit,status=:status where purchase_bill_id=:id",nativeQuery = true)
	void updatePurchaseBill(int id, BigDecimal balance, BigDecimal amountdebit, String status);
}
