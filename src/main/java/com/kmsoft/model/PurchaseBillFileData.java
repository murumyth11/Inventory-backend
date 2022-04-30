package com.kmsoft.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="pbfiledata")
public class PurchaseBillFileData {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int pbfiledataId;
	
	@Column(name="filename")
	String filename;
	
	@Column(name="filetype")
	String filetype;
	
	@Lob
	@Basic(fetch = FetchType.LAZY)
	@Column(name="purchaseimage")
	byte[] purchaseimage;

	public int getPbfiledataId() {
		return pbfiledataId;
	}

	public void setPbfiledataId(int pbfiledataId) {
		this.pbfiledataId = pbfiledataId;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getFiletype() {
		return filetype;
	}

	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}

	public byte[] getPurchaseimage() {
		return purchaseimage;
	}

	public void setPurchaseimage(byte[] purchaseimage) {
		this.purchaseimage = purchaseimage;
	}

	public PurchaseBillFileData(int pbfiledataId, String filename, String filetype, byte[] purchaseimage) {
		super();
		this.pbfiledataId = pbfiledataId;
		this.filename = filename;
		this.filetype = filetype;
		this.purchaseimage = purchaseimage;
	}

	public PurchaseBillFileData() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	

}
