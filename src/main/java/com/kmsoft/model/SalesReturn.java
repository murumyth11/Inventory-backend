package com.kmsoft.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "salesReturn")
public class SalesReturn {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int salesReturnId;
	
	@Column(name="salesreturnno")
	String salesReturnNumber;
	
	@ManyToOne()
	@JoinColumn(name="customerFk",referencedColumnName = "customerId")
	Customer customer;
	
	@Column(name="amountdebit")
	BigDecimal amountdebit;
	
	@Column(name="balance")
	BigDecimal balance;
	
	@Column(name="status")
	String status;
	
	@Column(name="billedBy")
	String billedBy;
	
	@Column(name="paymentmethod")
	String paymentmethod;
	
	@Column(name="subtotal")
	BigDecimal subtotal;
	
	@Column(name="total")
	BigDecimal total;
	
	@Column(name="billnotes")
	String billnotes;
	
	@Column(name="adjustments")
	BigDecimal adjustments;
	
	
	
	

	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@Column(name="date" )
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm a")
	LocalDateTime date;
	
	@OneToMany(cascade = { CascadeType.ALL })
	@JoinColumn(name="salesreturn_fk")
	List<SalesReturnProduct> salesreturnproduct =new ArrayList<SalesReturnProduct>();
	
	public BigDecimal getAdjustments() {
		return adjustments;
	}

	public void setAdjustments(BigDecimal adjustments) {
		this.adjustments = adjustments;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public int getSalesReturnId() {
		return salesReturnId;
	}

	public void setSalesReturnId(int salesReturnId) {
		this.salesReturnId = salesReturnId;
	}

	public String getSalesReturnNumber() {
		return salesReturnNumber;
	}

	public void setSalesReturnNumber(String salesReturnNumber) {
		this.salesReturnNumber = salesReturnNumber;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public BigDecimal getAmountdebit() {
		return amountdebit;
	}

	public void setAmountdebit(BigDecimal amountdebit) {
		this.amountdebit = amountdebit;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getBilledBy() {
		return billedBy;
	}

	public void setBilledBy(String billedBy) {
		this.billedBy = billedBy;
	}

	public String getPaymentmethod() {
		return paymentmethod;
	}

	public void setPaymentmethod(String paymentmethod) {
		this.paymentmethod = paymentmethod;
	}

	public BigDecimal getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public String getBillnotes() {
		return billnotes;
	}

	public void setBillnotes(String billnotes) {
		this.billnotes = billnotes;
	}

	

	

	public List<SalesReturnProduct> getSalesreturnproduct() {
		return salesreturnproduct;
	}

	public void setSalesreturnproduct(List<SalesReturnProduct> salesreturnproduct) {
		this.salesreturnproduct = salesreturnproduct;
	}



	public SalesReturn(int salesReturnId, String salesReturnNumber, Customer customer, BigDecimal amountdebit,
			BigDecimal balance, String status, String billedBy, String paymentmethod, BigDecimal subtotal,
			BigDecimal total, String billnotes, BigDecimal adjustments, LocalDateTime date,
			List<SalesReturnProduct> salesreturnproduct) {
		super();
		this.salesReturnId = salesReturnId;
		this.salesReturnNumber = salesReturnNumber;
		this.customer = customer;
		this.amountdebit = amountdebit;
		this.balance = balance;
		this.status = status;
		this.billedBy = billedBy;
		this.paymentmethod = paymentmethod;
		this.subtotal = subtotal;
		this.total = total;
		this.billnotes = billnotes;
		this.adjustments = adjustments;
		this.date = date;
		this.salesreturnproduct = salesreturnproduct;
	}

	public SalesReturn() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	

	
}
