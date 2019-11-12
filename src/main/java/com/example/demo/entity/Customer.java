package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Customer")
public class Customer {

	@Id
	@Column(name = "CID")
	private int cID;
	
	@Column(name = "CName")
	private String cName;
	
	@Column(name = "CTel")
	private String cTel;
	
	@Column(name = "Account")
	private String account;
	
	@Column(name = "Password")
	private String password;
	
	@Column(name = "Power")
	private int power;

	public int getcID() {
		return cID;
	}

	public void setcID(int cID) {
		this.cID = cID;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getcTel() {
		return cTel;
	}

	public void setcTel(String cTel) {
		this.cTel = cTel;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

}
=======
package com.example.demo.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="Customer")
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
>>>>>>> origin/yeh
