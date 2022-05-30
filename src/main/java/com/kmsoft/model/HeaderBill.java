package com.kmsoft.model;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
import javax.persistence.UniqueConstraint;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;


@Entity
@Table(name="HeaderBill",uniqueConstraints={@UniqueConstraint(columnNames={"invoice"})})
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
	
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@Column(name="date" ,columnDefinition="DATETIME")
	//DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("hh:mm a");
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm a")
	LocalDateTime date;
	
	@Column(name="subtotal")
	BigDecimal subtotal;
	
	@Column(name="adjustment")
	BigDecimal adjustment;
	
	@Column(name="billnotes")
	String billnotes;
	
	
	@Column(name="totalitems")
	int totalitems;
	
	@Column(name="totalquantity")
	int totalquantity;
	
	@Column(name="isdraft")
    int isdraft;
	
	@Column(name="creditAmount")
	BigDecimal creditAmount;
	
	@Column(name="balance")
	BigDecimal balance;
	
	@Column(name="status")
	String status;
	
	@Column(name="billedBy")
	String billedBy;
	
	@Column(name="paymentmethod")
	String paymentmethod;
	
	
	
	public String getPaymentmethod() {
		return paymentmethod;
	}

	public void setPaymentmethod(String paymentmethod) {
		this.paymentmethod = paymentmethod;
	}

	public String getBilledBy() {
		return billedBy;
	}

	public void setBilledBy(String billedBy) {
		this.billedBy = billedBy;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	

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

	

	@Column(name="total")
	BigDecimal total;
	
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

	
	public List<Billproduct> getBilldetails() {
		return billdetails;
	}

	public void setBilldetails(List<Billproduct> billdetails) {
		this.billdetails = billdetails;
	}

	@OneToMany(cascade = { CascadeType.ALL })
	@JoinColumn(name="headerbillFk")
	public List<Billproduct> billdetails=new ArrayList<Billproduct>();
	
	@ManyToOne()
	@JoinColumn(name="customerFk",referencedColumnName = "customerId")
	Customer customer;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	

	

	public BigDecimal getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	public BigDecimal getAdjustment() {
		return adjustment;
	}

	public void setAdjustment(BigDecimal adjustment) {
		this.adjustment = adjustment;
	}

	public BigDecimal getCreditAmount() {
		return creditAmount;
	}

	public void setCreditAmount(BigDecimal creditAmount) {
		this.creditAmount = creditAmount;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}
 
	
	

	public HeaderBill(int headerBillId, String customerName, String customerPhone, String invoice, LocalDateTime date,
			BigDecimal subtotal, BigDecimal adjustment, String billnotes, int totalitems, int totalquantity,
			int isdraft, BigDecimal creditAmount, BigDecimal balance, String status, String billedBy,
			String paymentmethod, BigDecimal total, List<Billproduct> billdetails, Customer customer) {
		super();
		this.headerBillId = headerBillId;
		this.customerName = customerName;
		this.customerPhone = customerPhone;
		this.invoice = invoice;
		this.date = date;
		this.subtotal = subtotal;
		this.adjustment = adjustment;
		this.billnotes = billnotes;
		this.totalitems = totalitems;
		this.totalquantity = totalquantity;
		this.isdraft = isdraft;
		this.creditAmount = creditAmount;
		this.balance = balance;
		this.status = status;
		this.billedBy = billedBy;
		this.paymentmethod = paymentmethod;
		this.total = total;
		this.billdetails = billdetails;
		this.customer = customer;
	}

	public HeaderBill() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
