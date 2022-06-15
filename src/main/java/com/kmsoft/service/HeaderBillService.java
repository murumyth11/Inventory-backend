package com.kmsoft.service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.kmsoft.model.HeaderBill;


public interface HeaderBillService {
	
	public HeaderBill createHeaderBill(HeaderBill headerbill);
	
	public  Page<HeaderBill> findAllByOrderByHeaderBillIdDesc(Pageable paging);
	
	public  Page<HeaderBill> findByInvoiceContaining(String title,Pageable paging);
	
	public Page<HeaderBill> getAllBetweenDates(Date startDate,Date endDate,Pageable paging);
	
	public Page<HeaderBill> getAllBetweenDatesContaining(Date startDate,Date endDate,String title,Pageable paging);
	
	public List<HeaderBill> getDraftBill();
	
	public void deleteDraftbillByid(int id);
	
	public List<Map<String, Object>> getbillbydates(Date startDate,Date endDate);
	
	public int getHeaderbillInvNo();
	
	public Map<String,Object> getHeaderbillDetails();
	
	public Map<String,Object> getHeaderbillDetailsDate(Date startdate,Date enddate);
	
	public HeaderBill updateHeaderBill(HeaderBill headerBill);

	public Page<List<Map<String, Object>>> getHeaderbillCustomers(String title,int cId, Pageable paging);

	public Map<String, Object> customerbilldetails(int id);

	public List<Map<String, Object>> getcustomerbatchproduct(int cid, int pid);

	

}
