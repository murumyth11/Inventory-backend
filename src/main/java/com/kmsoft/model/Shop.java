package com.kmsoft.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="shop")
public class Shop {
	
	@Id
	int shopid;
	
	@Column(name="shopname")
	String shopName;
	
	@Column(name="phone1")
	String phone1;
	
	@Column(name="phone2")
	String phone2;
	
	@Column(name="email")
	String email;
	
	@Column(name="address")
	String address;
	
	@Column(name="shopno")
	String shopno;
	
	@Column(name="gstin")
	String gstin;
	
	@Lob
	@Basic(fetch = FetchType.LAZY)
	@Column(name="shoplogo")
	byte[] shoplogo;

	
	
	public byte[] getShoplogo() {
		return shoplogo;
	}

	public void setShoplogo(byte[] shoplogo) {
		this.shoplogo = shoplogo;
	}

	public int getShopid() {
		return shopid;
	}

	public void setShopid(int shopid) {
		this.shopid = shopid;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getShopno() {
		return shopno;
	}

	public void setShopno(String shopno) {
		this.shopno = shopno;
	}

	public String getGstin() {
		return gstin;
	}

	public void setGstin(String gstin) {
		this.gstin = gstin;
	}

	public Shop(int shopid, String shopName, String phone1, String phone2, String email, String address, String shopno,
			String gstin, byte[] shoplogo) {
		super();
		this.shopid = shopid;
		this.shopName = shopName;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.email = email;
		this.address = address;
		this.shopno = shopno;
		this.gstin = gstin;
		this.shoplogo = shoplogo;
	}

	public Shop() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
