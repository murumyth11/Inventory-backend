package com.kmsoft.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Fetch;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

@Entity
@Table(name="PurchaseBill",uniqueConstraints={@UniqueConstraint(columnNames={"pbNo"})})
public class PurchaseBill {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int purchaseBillId;
	
	@Column(name="pbno")
	String pbNo;
	
	@Column(name="pbinvoice")
	String pbInvoice;
	
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@Column(name="pbinvoicedate" ,columnDefinition="DATETIME")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm a")
	LocalDateTime pbInvoiceDate;
	
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@Column(name="pbentrydate" ,columnDefinition="DATETIME")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm a")
	LocalDateTime pbEntryDate;
	
	@Column(name="taxamount")
	BigDecimal taxAmount;
	
	@Column(name="subtotal")
	BigDecimal subtotal;
	
	@Column(name="total")
	BigDecimal total;
	
	@OneToMany(cascade = { CascadeType.ALL })
	@JoinColumn(name="purchasebillFk")
	List<PurchaseBillProduct> purchaseBillProduct =new ArrayList<PurchaseBillProduct>();
	
	@ManyToOne()
	@JoinColumn(name="vendorFk",referencedColumnName = "vendorId")
	Vendors vendors;
	
//	@OneToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name="purchaseimagedata",referencedColumnName = "pbfiledataId")
//	PurchaseBillFileData pbfiledata;
	
	@Column(name="billedby")
	String billedBy;
	
	@Column(name="charges")
	BigDecimal charges;
	
	@Column(name="billnotes")
	String billnotes;
	
	@Column(name="amountdebit")
	BigDecimal amountdebit;
	
	@Column(name="balance")
	BigDecimal balance;
	
	@Column(name="status")
	String status;
	
	@Lob
	@Basic(fetch = FetchType.LAZY)
	@Column(name="purchaseimage")
	byte[] purchaseimage;
	
	@Column(name="paymentmethod")
	String paymentmethod;

	
	public PurchaseBill(int purchaseBillId, String pbNo, String pbInvoice, LocalDateTime pbInvoiceDate,
			LocalDateTime pbEntryDate, BigDecimal taxAmount, BigDecimal subtotal, BigDecimal total,
			List<PurchaseBillProduct> purchaseBillProduct, Vendors vendors, String billedBy, BigDecimal charges,
			String billnotes, BigDecimal amountdebit, BigDecimal balance, String status, byte[] purchaseimage,String paymentmethod) {
		super();
		this.purchaseBillId = purchaseBillId;
		this.pbNo = pbNo;
		this.pbInvoice = pbInvoice;
		this.pbInvoiceDate = pbInvoiceDate;
		this.pbEntryDate = pbEntryDate;
		this.taxAmount = taxAmount;
		this.subtotal = subtotal;
		this.total = total;
		this.purchaseBillProduct = purchaseBillProduct;
		this.vendors = vendors;
		this.billedBy = billedBy;
		this.charges = charges;
		this.billnotes = billnotes;
		this.amountdebit = amountdebit;
		this.balance = balance;
		this.status = status;
		this.purchaseimage = purchaseimage;
		this.paymentmethod=paymentmethod;
	}

	


	public PurchaseBill() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	
	public String getPaymentmethod() {
		return paymentmethod;
	}




	public void setPaymentmethod(String paymentmethod) {
		this.paymentmethod = paymentmethod;
	}




	public String getStatus() {
		return status;
	}




	public void setStatus(String status) {
		this.status = status;
	}




	public byte[] getPurchaseimage() {
		return purchaseimage;
	}
	public void setPurchaseimage(byte[] purchaseimage) {
		this.purchaseimage = purchaseimage;
	}
	public int getPurchaseBillId() {
		return purchaseBillId;
	}



	public void setPurchaseBillId(int purchaseBillId) {
		this.purchaseBillId = purchaseBillId;
	}



	public String getPbNo() {
		return pbNo;
	}



	public void setPbNo(String pbNo) {
		this.pbNo = pbNo;
	}



	public String getPbInvoice() {
		return pbInvoice;
	}



	public void setPbInvoice(String pbInvoice) {
		this.pbInvoice = pbInvoice;
	}



	public LocalDateTime getPbInvoiceDate() {
		return pbInvoiceDate;
	}



	public void setPbInvoiceDate(LocalDateTime pbInvoiceDate) {
		this.pbInvoiceDate = pbInvoiceDate;
	}



	public LocalDateTime getPbEntryDate() {
		return pbEntryDate;
	}



	public void setPbEntryDate(LocalDateTime pbEntryDate) {
		this.pbEntryDate = pbEntryDate;
	}



	public BigDecimal getTaxAmount() {
		return taxAmount;
	}



	public void setTaxAmount(BigDecimal taxAmount) {
		this.taxAmount = taxAmount;
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



	public List<PurchaseBillProduct> getPurchaseBillProduct() {
		return purchaseBillProduct;
	}



	public void setPurchaseBillProduct(List<PurchaseBillProduct> purchaseBillProduct) {
		this.purchaseBillProduct = purchaseBillProduct;
	}



	public Vendors getVendors() {
		return vendors;
	}



	public void setVendors(Vendors vendors) {
		this.vendors = vendors;
	}



	public String getBilledBy() {
		return billedBy;
	}



	public void setBilledBy(String billedBy) {
		this.billedBy = billedBy;
	}



	public BigDecimal getCharges() {
		return charges;
	}



	public void setCharges(BigDecimal charges) {
		this.charges = charges;
	}



	public String getBillnotes() {
		return billnotes;
	}



	public void setBillnotes(String billnotes) {
		this.billnotes = billnotes;
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
	
	
	
	
	

}
