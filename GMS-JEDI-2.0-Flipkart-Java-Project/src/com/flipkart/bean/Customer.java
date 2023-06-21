/**
 * 
 */
package com.flipkart.bean;
import java.time.LocalDate;

/**
 * 
 */
public class Customer {
	private int customerId;
	private String name;
	private String mobile;
	private String email;
	private String address;
	private LocalDate dob;
	
	private String myBookingId[]; // To be made ArrayList
	
	
	public int getCustomerId() {
		return customerId;
	}
	
	public void setCustomerId(int i) {
		this.customerId = i;
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
	
	public LocalDate getDob() {
		return dob;
	}
	
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
}
