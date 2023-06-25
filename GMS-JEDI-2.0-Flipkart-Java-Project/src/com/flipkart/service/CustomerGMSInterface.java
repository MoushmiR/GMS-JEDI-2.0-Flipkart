package com.flipkart.service;

import java.time.LocalDate;
import java.util.List;

import com.flipkart.bean.Customer;
import com.flipkart.bean.Gymnasium;
import com.flipkart.bean.Slots;
import com.flipkart.exception.NoSlotsFoundException;

public interface CustomerGMSInterface {
	public Customer fetchCustomerDetails(String customerId);
	
	public List<Gymnasium> fetchGymList();
	
	public boolean fetchAvilableSlots(int gymId);
	
	public int bookSlots(int gymId, String slotId,String customerId,String date);
	
	public boolean alreadyBooked(String slotId,String customerId,String date);
	
	public boolean isFull(String slotId,String date);
	
//	public boolean bookSlot(String slotId,String customerId,String date);

	public boolean checkSlotExists(String slotId, int gymId);
	
	public void fetchBookedSlots(String email);
	
	public void cancelBookedSlots(String email, int bookingId);
	
	public boolean checkGymApprove(int gymId);
	
	
}
