package com.kmsoft.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import jakarta.persistence.*;

import java.time.LocalDateTime;



@Entity
@Table(name="BalanceUpdateHistory")
public class BalanceUpdateHistory {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int balanceUpdateHistoryId;
	
	
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@Column(name="balanceUpdateDate" ,columnDefinition="DATETIME")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm a")
	LocalDateTime balanceUpdateDate;
	
	@Column(name="cashIn")
	int cashIn;
	
	@Column(name="cashOut")
	int cashOut;
	
	@Column(name="balance")
	int balance;
	
	@Column(name="updatedBy")
	String updatedBy;
	
	@ManyToOne()
	@JoinColumn(name="headerbillFk",referencedColumnName = "headerBillId")
	
	HeaderBill headerbill;
	
	@ManyToOne
	@JoinColumn(name="purchasebillFk",referencedColumnName = "purchaseBillId")
	PurchaseBill purchaseBill;
	
	@ManyToOne
	@JoinColumn(name="salesreturnFk",referencedColumnName="salesReturnId")
	SalesReturn salesReturn;
	
	@Column(name="paymentmethod")
	String paymentmethod;
	

	
	
	

	public SalesReturn getSalesReturn() {
		return salesReturn;
	}

	public void setSalesReturn(SalesReturn salesReturn) {
		this.salesReturn = salesReturn;
	}

	public PurchaseBill getPurchaseBill() {
		return purchaseBill;
	}

	public void setPurchaseBill(PurchaseBill purchaseBill) {
		this.purchaseBill = purchaseBill;
	}

	public String getPaymentmethod() {
		return paymentmethod;
	}

	public void setPaymentmethod(String paymentmethod) {
		this.paymentmethod = paymentmethod;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	

	public int getBalanceUpdateHistoryId() {
		return balanceUpdateHistoryId;
	}

	public void setBalanceUpdateHistoryId(int balanceUpdateHistoryId) {
		this.balanceUpdateHistoryId = balanceUpdateHistoryId;
	}

	

	public int getCashIn() {
		return cashIn;
	}
	
	

	public void setCashIn(int cashIn) {
		this.cashIn = cashIn;
	}
	

	public int getCashOut() {
		return cashOut;
	}

	public void setCashOut(int cashOut) {
		this.cashOut = cashOut;
	}

	public HeaderBill getHeaderbill() {
		return headerbill;
	}

	public void setHeaderbill(HeaderBill headerbill) {
		this.headerbill = headerbill;
	}
	

	public String getupdatedBy() {
		return updatedBy;
	}

	public void setupdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}


	public LocalDateTime getBalanceUpdateDate() {
		return balanceUpdateDate;
	}

	public void setBalanceUpdateDate(LocalDateTime balanceUpdateDate) {
		this.balanceUpdateDate = balanceUpdateDate;
	}

	public BalanceUpdateHistory(int balanceUpdateHistoryId, LocalDateTime balanceUpdateDate, int cashIn, int cashOut,
			int balance, String updatedBy, HeaderBill headerbill, PurchaseBill purchaseBill, SalesReturn salesReturn,
			String paymentmethod) {
		super();
		this.balanceUpdateHistoryId = balanceUpdateHistoryId;
		this.balanceUpdateDate = balanceUpdateDate;
		this.cashIn = cashIn;
		this.cashOut = cashOut;
		this.balance = balance;
		this.updatedBy = updatedBy;
		this.headerbill = headerbill;
		this.purchaseBill = purchaseBill;
		this.salesReturn = salesReturn;
		this.paymentmethod = paymentmethod;
	}

	public BalanceUpdateHistory() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	
}
