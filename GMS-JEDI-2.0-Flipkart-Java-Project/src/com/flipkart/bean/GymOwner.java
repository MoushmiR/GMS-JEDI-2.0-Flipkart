package com.flipkart.bean;

public class GymOwner {
	private int ownerId;
    private int adhaarNo;
	private int gstNo;
	private String gymOwnerName;
    private String emailId;
    private int contactNo;
    private String status;
    
	public int getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}
	public int getAdhaarNo() {
		return adhaarNo;
	}
	public void setAdhaarNo(int adhaarNo) {
		this.adhaarNo = adhaarNo;
	}
	public int getGstNo() {
		return gstNo;
	}
	public void setGstNo(int gSTNo) {
		this.gstNo = gSTNo;
	}
	public String getGymOwnerName() {
		return gymOwnerName;
	}
	public void setGymOwnerName(String gymOwnerName) {
		this.gymOwnerName = gymOwnerName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public int getContactNo() {
		return contactNo;
	}
	public void setContactNo(int contactNo) {
		this.contactNo = contactNo;
	}
}
