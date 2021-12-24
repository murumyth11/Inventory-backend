package com.kmsoft.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="balanceUpdateHistory")
public class BalanceUpdateHistory {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int balanceUpdateHistoryId;
	
	@Column(name="balanceUpdateDate")
	String balanceUpdateDate;
	
	@Column(name="cashIn")
	int cashIn;
	
	@Column(name="cashOut")
	int cashOut;
	
	@Column(name="updatedBy")
	String updatedBy;
	
	@ManyToOne
	@JoinColumn(name="headerbillFk",referencedColumnName = "headerBillId")
	HeaderBill headerbill;

	public int getBalanceUpdateHistoryId() {
		return balanceUpdateHistoryId;
	}

	public void setBalanceUpdateHistoryId(int balanceUpdateHistoryId) {
		this.balanceUpdateHistoryId = balanceUpdateHistoryId;
	}

	public String getBalanceUpdateDate() {
		return balanceUpdateDate;
	}

	public void setBalanceUpdateDate(String balanceUpdateDate) {
		this.balanceUpdateDate = balanceUpdateDate;
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

	public BalanceUpdateHistory(int balanceUpdateHistoryId, String balanceUpdateDate, int cashIn, int cashOut,
			String updatedBy, HeaderBill headerbill) {
		super();
		this.balanceUpdateHistoryId = balanceUpdateHistoryId;
		this.balanceUpdateDate = balanceUpdateDate;
		this.cashIn = cashIn;
		this.cashOut = cashOut;
		this.updatedBy = updatedBy;
		this.headerbill = headerbill;
	}

	public BalanceUpdateHistory() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	
}
