/**
 * 
 */
package com.flipkart.bean;

/**
 * 
 */
public class Administrator {
	private String userName;
	private String name;
	private String mobile;
	
	
	public String getAdminId() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
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
}