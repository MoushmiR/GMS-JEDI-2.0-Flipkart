package com.flipkart.dao;

public interface CustomerGMSDao {

	public void fetchGymList();
	
	public void fetchSlotList(int gymId);
	
	public void fetchBookedSlots(String email);
	
	public void bookSlots(int gymId, String slotId,String customerId,String date);
	
	public boolean isFull(String slotId,String date);

	public boolean alreadyBooked(String slotId, String email, String date);

	public void cancelBooking(String slotId, String email, String date);

	public boolean checkSlotExists(String slotId, int gymId);

}