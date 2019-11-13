package com.example.demo.entity;


import java.io.Serializable;


public class OrderDetailPK implements Serializable{

	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;

	public Integer OID;
	public Integer MID;
	
	public Integer getOID() {
		return OID;
	}

	public Integer getMID() {
		return MID;
	}
}
