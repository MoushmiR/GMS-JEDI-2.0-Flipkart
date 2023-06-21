/**
 * 
 */
package com.flipkart.bean;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * 
 */
public class Slots {
	private String slotId;
	private String gymId;

	private int capacity;
	private LocalDate date;
	private LocalTime time;
	
	private String guestId[]; // To be made ArrayList
	
	
	public String getSlotId() {
		return slotId;
	}
	
	public void setSlotId(String slotId) {
		this.slotId = slotId;
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	public LocalDate getDate() {
		return date;
	}
	
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	public LocalTime getTime() {
		return time;
	}
	
	public void setTime(LocalTime time) {
		this.time = time;
	}
	
	public String getGymId() {
		return gymId;
	}

	public void setGymId(String gymId) {
		this.gymId = gymId;
	}
}
