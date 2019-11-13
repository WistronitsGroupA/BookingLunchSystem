package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity(name="Orders")
public class Orders {

	@Id
	@Column (name = "OID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer OID;
	
	@Column(name = "CID")
	public Integer CID;
	
	@Column(name = "ordertime")
	public Date OrderTime;
	
	@Column(name = "Status")
	public Integer Status;

	//------------------------------------------------
	
	public Integer getOID() {
		return OID;
	}

	public void setOID(Integer OID) {
		this.OID = OID;
	}

	public Integer getCID() {
		return CID;
	}

	public void setCID(Integer CID) {
		this.CID = CID;
	}

	public Date getOrderTime() {
		return OrderTime;
	}

	public void setOrderTime(Date OrderTime) {
		this.OrderTime = OrderTime;
	}

	public Integer getStatus() {
		return Status;
	}

	public void setStatus(Integer Status) {
		this.Status = Status;
	}
}
