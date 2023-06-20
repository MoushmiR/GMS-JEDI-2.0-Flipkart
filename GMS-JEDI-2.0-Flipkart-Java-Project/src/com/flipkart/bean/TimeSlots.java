/**
 * 
 */
package com.flipkart.bean;

import java.util.Date;

/**
 * 
 */
public class TimeSlots {
	
	private int slotId;
	private int startTime;
	private int gymId;
    private int totalSeats;
	private int availableSeats;
	private Date date;
	
	
	public int getStartTime() {
		return startTime;
	}
	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}
	public int getGymId() {
		return gymId;
	}
	public void setGymId(int gymId) {
		this.gymId = gymId;
	}
	public int getTotalSeats() {
		return totalSeats;
	}
	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}
	public int getAvailableSeats() {
		return availableSeats;
	}
	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}
	
  
}
