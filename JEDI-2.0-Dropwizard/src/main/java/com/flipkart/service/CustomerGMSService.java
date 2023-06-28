/**
 * 
 */
package com.flipkart.service;
import com.flipkart.bean.*;

import java.util.List;

import com.flipkart.dao.*;
import com.flipkart.exception.NoSlotsFoundException;
/**
 * 
 */
public class CustomerGMSService implements CustomerGMSInterface{ 
	CustomerGMSDao customerDao = new CustomerGMSDaoImpl();
	
	/**
	 * Fetches the details of a customer based on the customer ID.
	 * @param customerId The ID of the customer
	 * @return Customer object representing the customer details
	 */
	public Customer fetchCustomerDetails(String customerId) {
		return new Customer();
	}

	/**
	 * Fetches the list of available gyms for the customer.
	 * @return List of Gymnasium objects representing the available gyms
	 */
	public List<Gymnasium> fetchGymList() {
		List<Gymnasium> gymList =  customerDao.fetchGymList();
		return gymList;
	}

	/**
	 * Fetches the availability of slots for a particular gym.
	 * @param gymId The ID of the gym
	 * @return true if slots are available, false otherwise
	 */
	public List<SlotsNew> fetchAvailableSlots(int gymId) throws NoSlotsFoundException {
		return customerDao.fetchSlotList(gymId);
	}

	/**
	 * Books slots for a customer at a specified gym, date, and slot time.
	 * @param gymId The ID of the gym
	 * @param slotId The ID of the slot
	 * @param email The email of the customer
	 * @param date The date of the slot
	 * @return The booking ID if the slots are successfully booked, 0 if the slot is already booked and replaced, 1 if the slot is already full, 2 if the slots are successfully booked
	 */
	public int bookSlots(int gymId, String slotId, String email, String date) {
		if(alreadyBooked(slotId, email, date)) {
			customerDao.cancelBooking(slotId, email, date);
			customerDao.bookSlots(gymId, slotId, email, date);
			return 0;
		} else if(isFull(slotId, date)) {
			return 1;
		} else {
			customerDao.bookSlots(gymId, slotId, email, date);
			return 2;
		}
	}

	/**
	 * Checks if a customer has already booked a slot at a specified slot time and date.
	 * @param slotId The ID of the slot
	 * @param email The email of the customer
	 * @param date The date of the slot
	 * @return true if the customer has already booked a slot, false otherwise
	 */
	public boolean alreadyBooked(String slotId, String email, String date) {
		return customerDao.alreadyBooked(slotId, email, date);
	}

	/**
	 * Checks if a slot is already full for a specified slot time and date.
	 * @param slotId The ID of the slot
	 * @param date The date of the slot
	 * @return true if the slot is full, false otherwise
	 */
	public boolean isFull(String slotId, String date) {
		return customerDao.isFull(slotId, date);
	}



	
	
	/**
	 * Fetches the booked slots for a customer based on the customer's email.
	 * @param email The email of the customer
	 */
	public List<BookedSlot> fetchBookedSlots(String email) {
		return customerDao.fetchBookedSlots(email);
	}

	/**
	 * Checks if a slot exists for a specified slot ID and gym ID.
	 * @param slotId The ID of the slot
	 * @param gymId The ID of the gym
	 * @return true if the slot exists, false otherwise
	 */
	public boolean checkSlotExists(String slotId, int gymId) {	
		return customerDao.checkSlotExists(slotId, gymId);
	}

	/**
	 * Cancels a booked slot for a customer based on the booking ID.
	 *
	 * @param email     The email of the customer
	 * @param bookingId The ID of the booking to cancel
	 * @return
	 */
	public Object cancelBookedSlots(String email, int bookingId) {
		customerDao.cancelBookedSlots(email, bookingId);
		return null;
	}

	/**
	 * Checks if a gym is approved for a specified gym ID.
	 * @param gymId The ID of the gym
	 * @return true if the gym is approved, false otherwise
	 */
	public boolean checkGymApprove(int gymId) {
		return customerDao.checkGymApprove(gymId);
	}


}
