package com.kmsoft.model;


import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.Nullable;

@Entity
@Table(name="HeaderBill")
public class HeaderBill {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int headerBillId;
	
	@Column(name="customer")
	String customerName;
	
	@Column(name="phone")
	String customerPhone;
	
	@Column(name="invoice")
	String invoice;
	
	@Column(name="date" ,columnDefinition="DATETIME")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm a")
	LocalDateTime date;
	
	@Column(name="subtotal")
	int subtotal;
	
	@Column(name="adjustment")
	int adjustment;
	
	@Column(name="billnotes")
	String billnotes;
	
	
	@Column(name="totalitems")
	int totalitems;
	
	@Column(name="totalquantity")
	int totalquantity;
	
	@Column(name="isdraft")
    int isdraft;
	
	public int getIsdraft() {
		return isdraft;
	}

	public void setIsdraft(int isdraft) {
		this.isdraft = isdraft;
	}

	public int getTotalquantity() {
		return totalquantity;
	}

	public void setTotalquantity(int totalquantity) {
		this.totalquantity = totalquantity;
	}

	public int getTotalitems() {
		return totalitems;
	}

	public void setTotalitems(int totalitems) {
		this.totalitems = totalitems;
	}

	public String getBillnotes() {
		return billnotes;
	}

	public void setBillnotes(String billnotes) {
		this.billnotes = billnotes;
	}

	public int getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(int subtotal) {
		this.subtotal = subtotal;
	}

	public int getAdjustment() {
		return adjustment;
	}

	public void setAdjustment(int adjustment) {
		this.adjustment = adjustment;
	}

	@Column(name="total")
	int total;
	
	public int getHeaderBillId() {
		return headerBillId;
	}

	public void setHeaderBillId(int headerBillId) {
		this.headerBillId = headerBillId;
	}

	

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getcustomerPhone() {
		return customerPhone;
	}

	public void setcustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public String getInvoice() {
		return invoice;
	}

	public void setInvoice(String invoice) {
		this.invoice = invoice;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<Billproduct> getBilldetails() {
		return billdetails;
	}

	public void setBilldetails(List<Billproduct> billdetails) {
		this.billdetails = billdetails;
	}

	@OneToMany(cascade = { CascadeType.ALL })
	@JoinColumn(name="headerbillFk")
	public List<Billproduct> billdetails=new ArrayList<Billproduct>();
	
	@ManyToOne
	@JoinColumn(name="customerFk",referencedColumnName = "customerId")
	Customer customer;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
