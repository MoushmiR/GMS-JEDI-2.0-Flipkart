/**
 * 
 */
package com.flipkart.bean;
import java.time.LocalDate;

/**
 * 
 */
public class GymOwner {
	private String email;
	private String name;
	private String mobile;
	private String address;
	private String dob;
	
	private String aadhaarNumber;
	private String panNumber;
	private String gstNumber;
	
	private boolean approved;
	
	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getMobile() {
		return mobile;
	}
	
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getDob() {
		return dob;
	}
	
	public void setDob(String string) {
		this.dob = string;
	}
	
	public String getAadhaarNumber() {
		return aadhaarNumber;
	}
	
	public void setAadhaarNumber(String aadhaarNumber) {
		this.aadhaarNumber = aadhaarNumber;
	}
	
	public String getPanNumber() {
		return panNumber;
	}
	
	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}
	
	public String getGstNumber() {
		return gstNumber;
	}
	
	public void setGstNumber(String gstNumber) {
		this.gstNumber = gstNumber;
	}
}