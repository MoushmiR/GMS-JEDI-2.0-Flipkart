package com.flipkart.dao;

import java.util.List;

import com.flipkart.bean.BookedSlot;
import com.flipkart.bean.Gymnasium;
import com.flipkart.bean.SlotsNew;
import com.flipkart.bean.UserBookings;
import com.flipkart.exception.NoSlotsFoundException;

public interface CustomerGMSDao {

	public List<Gymnasium> fetchGymList();
	
	public List<SlotsNew> fetchSlotList(int gymId) throws NoSlotsFoundException;
	
	public List<UserBookings> fetchBookedSlots(String email);
	
	public Object bookSlots(int gymId, String slotId, String customerId, String date);
	
	public boolean isFull(String slotId,String date);

	public boolean alreadyBooked(String slotId, String email, String date);

	public void cancelBooking(String slotId, String email, String date);

	public boolean checkSlotExists(String slotId, int gymId);

	public void cancelBookedSlots(int bookingId);

	public boolean checkGymApprove(int gymId);

}
