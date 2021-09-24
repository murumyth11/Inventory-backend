package com.kmsoft.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
	
	@Column(name="date")
	String date;
	
	@Column(name="subtotal")
	int subttotal;
	
	@Column(name="adjustment")
	int adjustment;
	
	@Column(name="billnotes")
	String billnotes;

	public String getBillnotes() {
		return billnotes;
	}

	public void setBillnotes(String billnotes) {
		this.billnotes = billnotes;
	}

	public int getSubttotal() {
		return subttotal;
	}

	public void setSubttotal(int subttotal) {
		this.subttotal = subttotal;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
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

}
