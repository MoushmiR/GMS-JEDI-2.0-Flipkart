package com.flipkart.service;

import java.util.List;

import com.flipkart.bean.*;
import com.flipkart.exception.NoSlotsFoundException;

public interface CustomerGMSInterface {
	/**
	 * Fetches the details of a customer based on the customer ID.
	 * @param customerId The ID of the customer
	 * @return Customer object representing the customer details
	 */
	public Customer fetchCustomerDetails(String customerId);

	/**
	 * Fetches the list of available gyms.
	 * @return List of Gymnasium objects representing the available gyms
	 */
	public List<Gymnasium> fetchGymList();

	/**
	 * Fetches the availability of slots for a particular gym.
	 * @param gymId The ID of the gym
	 * @return true if slots are available, false otherwise
	 */
	public List<SlotsNew> fetchAvailableSlots(int gymId) throws NoSlotsFoundException;

	/**
	 * Books slots for a customer at a specified gym, date, and slot time.
	 * @param gymId The ID of the gym
	 * @param slotId The ID of the slot
	 * @param date The date of the slot
	 * @return The booking ID if the slots are successfully booked, 0 otherwise
	 */
	public int bookSlots(int gymId, String slotId, String email, String date);

	/**
	 * Checks if a customer has already booked a slot at a specified slot time and date.
	 * @param slotId The ID of the slot
	 * @param customerId The ID of the customer
	 * @param date The date of the slot
	 * @return true if the customer has already booked a slot, false otherwise
	 */
	public boolean alreadyBooked(String slotId, String customerId, String date);

	/**
	 * Checks if a slot is already full for a specified slot time and date.
	 * @param slotId The ID of the slot
	 * @param date The date of the slot
	 * @return true if the slot is full, false otherwise
	 */
	public boolean isFull(String slotId, String date);

	/**
	 * Checks if a slot exists for a specified slot ID and gym ID.
	 * @param slotId The ID of the slot
	 * @param gymId The ID of the gym
	 * @return true if the slot exists, false otherwise
	 */
	public boolean checkSlotExists(String slotId, int gymId);

	/**
	 * Fetches the booked slots for a customer based on the customer's email.
	 * @param email The email of the customer
	 */
	public List<UserBookings> fetchBookedSlots(String email);

	/**
	 * Cancels a booked slot for a customer based on the booking ID.
	 *
	 * @param bookingId The ID of the booking to cancel
	 * @return
	 */
	public Object cancelBookedSlots(int bookingId);

	/**
	 * Checks if a gym is approved for a specified gym ID.
	 * @param gymId The ID of the gym
	 * @return true if the gym is approved, false otherwise
	 */
	public boolean checkGymApprove(int gymId);

	public int findAvailability(int gymId, String slotId, String date);

	public List<SlotsNew> allAvailableSlots(int gymId, String date);
	
}
