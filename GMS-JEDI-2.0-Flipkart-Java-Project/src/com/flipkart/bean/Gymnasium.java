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