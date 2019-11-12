package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Vendor {
	@Id
	@Column (name = "VID")
	public Integer VID;
	
	@Column(name = "VName")
	public String VName;
	
	@Column(name = "Address")
	public String Address;
	
	@Column(name = "VTel")
	public String VTel;
	
	//-------------------------------------------
	
	public Integer getVID() {
		return VID;
	}

	public void setVID(Integer VID) {
		this.VID = VID;
	}

	public String getVName() {
		return VName;
	}

	public void setVName(String VName) {
		this.VName = VName;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String Address) {
		this.Address = Address;
	}

	public String getVTel() {
		return VTel;
	}

	public void setVTel(String VTel) {
		this.VTel = VTel;
	}
}
