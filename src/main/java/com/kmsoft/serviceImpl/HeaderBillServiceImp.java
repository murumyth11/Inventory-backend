package com.kmsoft.serviceImpl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kmsoft.model.HeaderBill;
import com.kmsoft.repository.HeaderBillRepository;
import com.kmsoft.service.HeaderBillService;

@Service
public class HeaderBillServiceImp implements HeaderBillService {

	@Autowired 
	HeaderBillRepository headerbillRepo;
	
	
	public HeaderBill createHeaderBill(HeaderBill headerbill) {
		
		return headerbillRepo.saveAndFlush(headerbill);
	}


	public Page<HeaderBill> findAllByOrderByHeaderBillIdDesc(Pageable paging) {
		
		return headerbillRepo.findAllByOrderByHeaderBillIdDesc(paging);
	}


	public Page<HeaderBill> findByInvoiceContaining(String title, Pageable paging) {
		
		return headerbillRepo.findByInvoiceContaining(title, paging);
	}

	
	public Page<HeaderBill> getAllBetweenDates(Date startDate, Date endDate, Pageable paging) {
		
		return headerbillRepo.getAllBetweenDates(startDate, endDate, paging);
	}

	
	public Page<HeaderBill> getAllBetweenDatesContaining(Date startDate, Date endDate, String title, Pageable paging) {
		
		return headerbillRepo.getAllBetweenDatesContaining(startDate, endDate, title, paging);
	}

	
	public List<HeaderBill> getDraftBill() {
		
		return headerbillRepo.getDraftBill();
	}

	
	public void deleteDraftbillByid(int id) {
		
		headerbillRepo.deleteById(id);
		
	}

	
	public List<Map<String, Object>> getbillbydates(Date startDate, Date endDate) {
		
		return headerbillRepo.getbillbydate(startDate, endDate);
	}

	
	public int getHeaderbillInvNo() {
		
		return headerbillRepo.getHeaderbillInvNo();
	}

	
	public Map<String, Object> getHeaderbillDetailsDate(Date startdate, Date enddate) {
		
		return headerbillRepo.getHeaderbillDetailsDate(startdate, enddate);
	}

	
	public HeaderBill updateHeaderBill(HeaderBill headerBill) {
		
		return headerbillRepo.saveAndFlush(headerBill);
	}

	
	public Map<String, Object> getHeaderbillDetails() {
	
		return headerbillRepo.getHeaderbillDetails();
	}


	@Override
	public Page<List<Map<String, Object>>> getHeaderbillCustomers(String title,int cId, Pageable paging) {
		// TODO Auto-generated method stub
		return headerbillRepo.getHeaderbillCustomer(title,cId,paging);
	}


	@Override
	public Map<String, Object> customerbilldetails(int id) {
		// TODO Auto-generated method stub
		return headerbillRepo.customerbilldetails(id);
	}


	

}
