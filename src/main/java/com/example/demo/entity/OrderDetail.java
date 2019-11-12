package com.example.demo.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="OrderDetail")
public class OrderDetail {
	
	@Id
	@Column (name = "OID")
	public Integer OID;
	
	@Id
	@Column(name = "MID")
	public Integer MID;
	
	@Column(name = "Amount")
	public Integer Amount;
	
	//-----------------------------------------------
	
	public Integer getOID() {
		return OID;
	}

	public void setOID(Integer OID) {
		this.OID = OID;
	}

	public Integer getMID() {
		return MID;
	}

	public void setMID(Integer MID) {
		this.MID = MID;
	}

	public Integer getAmount() {
		return Amount;
	}

	public void setAmount(Integer Amount) {
		this.Amount = Amount;
	}
}
