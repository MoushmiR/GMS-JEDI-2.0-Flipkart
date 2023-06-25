package com.flipkart.service;
import java.util.List;

import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Gymnasium;
import com.flipkart.bean.Slots;
import com.flipkart.exception.DataEntryException;
import com.flipkart.exception.GymDetailsNotFoundException;
import com.flipkart.exception.NoDataFoundException;
import com.flipkart.exception.NoGymOwnerIdFoundException;

public interface GymOwnerGMSInterface {
	
	/**
	 * Fetches the details of a gym owner based on the gym owner's username.
	 * @param gymOwnerUserName The username of the gym owner
	 * @return GymOwner object representing the gym owner details
	 */
	public GymOwner fetchOwnerDetails(String gymOwnerUserName);

	/**
	 * Adds the details of a gym to the system.
	 * @param gymDetails The Gymnasium object representing the gym details
	 * @throws GymDetailsNotFoundException if the gym details are not found
	 * @throws DataEntryException if there is an error in the data entry
	 */
	public void addGymDetails(Gymnasium gymDetails) throws GymDetailsNotFoundException, DataEntryException;
		
	/**
	 * Fetches the details of all gyms associated with a gym owner.
	 * @param gymOwnerUserName The username of the gym owner
	 * @return List of Gymnasium objects representing the gym details
	 * @throws NoGymOwnerIdFoundException if the gym owner ID is not found
	 * @throws NoDataFoundException if no gym data is found
	 */
	public List<Gymnasium> fetchGymDetails(String gymOwnerUserName) throws NoGymOwnerIdFoundException, NoDataFoundException;

	/**
	 * Adds slots to a gym for a given gym ID.
	 * @param gymId The ID of the gym
	 * @param chosenSlots The chosen slots for the gym
	 * @param slotInfo List of Slots objects representing the slot details
	 */
	public void addSlots(int gymId, String chosenSlots, List<Slots> slotInfo);

	/**
	 * Fetches the possible slots that can be assigned to a gym.
	 * @return List of Slots objects representing the possible slots
	 * @throws NoDataFoundException if no slot data is found
	 */
	public List<Slots> fetchPossibleSlots() throws NoDataFoundException;

	/**
	 * Checks if a gym owner is approved based on the owner's email.
	 * @param email The email of the gym owner
	 * @return true if the gym owner is approved, false otherwise
	 */
	public boolean checkOwnerApproval(String email);

	/**
	 * Checks if a gym is approved based on the gym ID.
	 * @param gymId The ID of the gym
	 * @return true if the gym is approved, false otherwise
	 */
	public boolean checkGymApproval(int gymId);

	/**
	 * Checks if a gym is already booked based on the gym ID.
	 * @param gymId The ID of the gym
	 * @return true if the gym is already booked, false otherwise
	 */
	public boolean checkIfAlreadyBooked(int gymId);

}