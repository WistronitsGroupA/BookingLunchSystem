package com.example.demo.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {

	@Id
	@Column (name = "CID")
	public Integer CID;
	
	@Column(name = "CName")
	public String CName;
	
	@Column(name = "CTel")
	public String CTel;
	
	@Column(name = "Account")
	public String Account;
	
	@Column(name = "Password")
	public String Password;
	
	@Column(name = "Power")
	public Integer Power;
	
	//-----------------------------------------------------------
	
	public Integer getCID() {
		return CID;
	}

	public void setCID(Integer CID) {
		this.CID = CID;
	}

	public String getCName() {
		return CName;
	}

	public void setCName(String CName) {
		this.CName = CName;
	}

	public String getCTel() {
		return CTel;
	}

	public void setCTel(String CTel) {
		this.CTel = CTel;
	}

	public String getAccount() {
		return Account;
	}

	public void setAccount(String Account) {
		this.Account = Account;
	}
	
	public String getPassword() {
		return Password;
	}
	
	public void setPassword(String Password) {
		this.Password=Password;
	}
	
	public Integer getPower() {
		return Power;
	}
	
	public void setPower(Integer Power) {
		this.Power=Power;
	}
	
}
