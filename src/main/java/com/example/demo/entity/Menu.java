package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="Menu")
public class Menu {
	
	@Column (name = "VID")
	public Integer VID;
	
	@Id
	@Column(name = "MID")
	public Integer MID;
	
	@Column(name = "MPrice")
	public Integer MPrice;
	
	@Column(name = "MName")
	public String MName;
	
	@Column(name = "Pic")
	public String Pic;
	
//-------------------------------------------------------
	
	public Integer getVID() {
		return VID;
	}

	public void setVID(Integer VID) {
		this.VID = VID;
	}

	public Integer getMID() {
		return MID;
	}

	public void setMID(Integer MID) {
		this.MID = MID;
	}

	public Integer getMPrice() {
		return MPrice;
	}

	public void setMPrice(Integer MPrice) {
		this.MPrice = MPrice;
	}

	public String getMName() {
		return MName;
	}

	public void setMName(String MName) {
		this.MName = MName;
	}
	
	public String getPic() {
		return Pic;
	}
	
	public void setPic(String Pic) {
		this.Pic=Pic;
	}
	
}
