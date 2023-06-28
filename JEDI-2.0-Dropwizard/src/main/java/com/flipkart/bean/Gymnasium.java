/**
 * 
 */
package com.flipkart.bean;

/**
 * 
 */
public class Gymnasium {
	private int gymId;
	private String gymOwnerEmail;
	
	private String name;
	private String address;
	private double totalArea;
	private int numItem;
	private int numSeatsPerSlot;
	private boolean isApproved;
	
	
	public int getNumSeatsPerSlot() {
		return numSeatsPerSlot;
	}

	public void setNumSeatsPerSlot(int numSeatsPerSlot) {
		this.numSeatsPerSlot = numSeatsPerSlot;
	}

	public boolean getIsApproved() {
		return isApproved;
	}

	public void setIsApproved(int isApproved) {
		if(isApproved == 1)
		{
			this.isApproved = true;
		}
		
		else
		{
			this.isApproved = false;
		}
	}
	
	public int getGymId() {
		return gymId;
	}
	
	public void setGymId(int gymId) {
		this.gymId = gymId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public double getTotalArea() {
		return totalArea;
	}
	
	public void setTotalArea(double totalArea) {
		this.totalArea = totalArea;
	}
	
	public String getGymOwnerEmail() {
		return gymOwnerEmail;
	}

	public void setGymOwnerEmail(String gymOwnerEmail) {
		this.gymOwnerEmail = gymOwnerEmail;
	}

	public int getNumItem() {
		return numItem;
	}
	
	public void setNumItem(int numItem) {
		this.numItem = numItem;
	}
	

//	public String toString() {
//		return gymId + " " + ownerUserName + " " + name + " " + address + " " + totalArea + " " + numItem + " ";
//		
//	}
}