package com.flipkart.service;

import java.time.LocalDate;

import com.flipkart.bean.Customer;
import com.flipkart.bean.Slots;

public interface CustomerGMSInterface {
	public Customer fetchCustomerDetails(String customerId);
	
	public void fetchGymList();
	
	public void fetchAvilableSlots(int gymId);
	
	public int bookSlots(int gymId, String slotId,String customerId,String date);
	
	public boolean alreadyBooked(String slotId,String customerId,String date);
	
	public boolean isFull(String slotId,String date);
	
//	public boolean bookSlot(String slotId,String customerId,String date);

	public boolean checkSlotExists(String slotId, int gymId);
	
	public void fetchBookedSlots(String email);
	
	
}
