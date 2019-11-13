package com.example.demo.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="VendorHistory")
public class VendorHistory {

	@Id
	@Column(name = "VHID")
	public Integer VHID;

	@Column(name = "VID")
	public Integer VID;

	@Column(name = "datetime")
	public Timestamp datetime;

	// ---------------------------------------

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
