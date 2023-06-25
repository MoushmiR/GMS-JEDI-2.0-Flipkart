/**
 * 
 */
package com.flipkart.service;
import com.flipkart.bean.*;

/**
 * 
 */
public class BookingSlotService {
	/**
	 * Checks the availability of a slot.
	 * @param slot The slot to check availability for
	 * @return true if the slot is available, false otherwise
	 */
	public boolean checkAvailability(Slots slot) {
		return true;
	}

	/**
	 * Checks if there is another slot booked by the user at the same time.
	 * @param userData The user's data
	 * @param slot The slot to check
	 * @return true if there is another slot booked by the user at the same time, false otherwise
	 */
	public boolean anotherSlotInSameTime(User userData, Slots slot) {
		return true;
	}

	/**
	 * Books a slot for the user.
	 * @param userData The user's data
	 * @param slot The slot to book
	 * @return true if the slot is successfully booked, false otherwise
	 */
	public boolean bookSlot(User userData, Slots slot) {
		return true;
	}

	/**
	 * Cancels a slot booking for the user.
	 * @param userData The user's data
	 * @param slot The slot to cancel
	 * @return true if the slot is successfully canceled, false otherwise
	 */
	public boolean cancelSlot(User userData, Slots slot) {
		return true;
	}

}
