package com.kmsoft.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kmsoft.model.BalanceUpdateHistory;

public interface BalanceUpdateHistoryRepository extends JpaRepository<BalanceUpdateHistory, Integer> {

	
	@Query(value="SELECT bh.balance_update_date,bh.cash_in,bh.updated_by,h.customer,h.phone,h.invoice from balance_update_history bh "
			+ " join header_bill h on bh.headerbill_fk=h.header_bill_id group by balance_update_history_id order by bh.balance_update_history_id desc",
			countQuery="select count(*) from balance_update_history ",nativeQuery=true)
		Page<List<Map<String,Object>>> findAllbuh(Pageable pageable);
		
		@Query(value="SELECT bh.balance_update_date,bh.cash_in,bh.updated_by,h.customer,h.phone,h.invoice "
				+ " from balance_update_history bh join header_bill h on bh.headerbill_fk=h.header_bill_id where bh.balance_update_date like %:title% or "
				+ "bh.cash_in like %:title% or h.customer like %:title% or h.phone like %:title% or h.invoice like %:title%  or bh.updated_by like "
				+ " %:title% "
				+ " group by balance_update_history_id order by bh.balance_update_history_id desc",
				countQuery="select count(*) from balance_update_history",nativeQuery=true)
		
		Page<List<Map<String,Object>>> getbySearch(String title,Pageable pageable);
	
}
