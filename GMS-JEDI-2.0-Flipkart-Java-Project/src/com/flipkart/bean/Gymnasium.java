/**
 * 
 */
package com.flipkart.bean;

/**
 * 
 */
public class Gymnasium {
	private String gymId;
	private String ownerUserName;
	
	private String name;
	private String address;
	private double totalArea;
	private int numItem;
		
	
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
	
	public String getOwnerUserName() {
		return ownerUserName;
	}

	public void setOwnerId(String ownerUserName) {
		this.ownerUserName = ownerUserName;
	}
	public String toString() {
		return gymId + " " + ownerUserName + " " + name + " " + address + " " + totalArea + " " + numItem + " ";
		
	}
}