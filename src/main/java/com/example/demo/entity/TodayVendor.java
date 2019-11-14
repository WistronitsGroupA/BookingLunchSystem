package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TodayVendor {
	
	
	private Integer VID;
	
	private String VName;
	@Id
	private Integer MID;
	
	private Integer MPrice;
	
	private String MName;
	
	private String Pic;
	
	public Integer getVID() {
		return VID;
	}
	public void setVID(Integer vID) {
		VID = vID;
	}
	public String getVName() {
		return VName;
	}
	public void setVName(String vName) {
		VName = vName;
	}
	public Integer getMID() {
		return MID;
	}
	public void setMID(Integer mID) {
		MID = mID;
	}
	public Integer getMPrice() {
		return MPrice;
	}
	public void setMPrice(Integer mPrice) {
		MPrice = mPrice;
	}
	public String getMName() {
		return MName;
	}
	public void setMName(String mName) {
		MName = mName;
	}
	public String getPic() {
		return Pic;
	}
	public void setPic(String pic) {
		Pic = pic;
	}
	
	
}
