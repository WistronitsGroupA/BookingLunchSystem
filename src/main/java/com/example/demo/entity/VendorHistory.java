package com.example.demo.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="Vendorhistory")
public class VendorHistory {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "VHID")
	public Integer VHID;

	@Column(name = "VID")
	public Integer VID;

	@Column(name = "datetime")
	public Timestamp datetime;
	
	@Column(name = "CID")
	public Integer CID;

	// ---------------------------------------

	public Integer getCID() {
		return CID;
	}

	public void setCID(Integer cID) {
		CID = cID;
	}

	public Integer getVHID() {
		return VHID;
	}

	public void setVHID(Integer VHID) {
		this.VHID = VHID;
	}

	public Integer getVID() {
		return VID;
	}

	public void setVID(Integer VID) {
		this.VID = VID;
	}

	public Date getdatetime() {
		return datetime;
	}

	public void setdatetime(Timestamp datetime) {
		this.datetime = datetime;
	}
}
