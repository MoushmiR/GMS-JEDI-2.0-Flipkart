/**
 * 
 */
package com.flipkart.bean;

/**
 * 
 */
public class Gymnasium {
	private String gymId;
	private String ownerId;
	
	private String name;
	private String address;
	private double totalArea;
	private int numItem;
	
	private Slots availableSlots[]; // To be made ArrayList
	
	
	public String getGymId() {
		return gymId;
	}
	
	public void setGymId(String gymId) {
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
	
	public int getNumItem() {
		return numItem;
	}
	
	public void setNumItem(int numItem) {
		this.numItem = numItem;
	}
	
	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}
}
