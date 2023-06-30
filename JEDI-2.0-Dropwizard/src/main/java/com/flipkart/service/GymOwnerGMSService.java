/**
 * 
 */
package com.flipkart.service;
import com.flipkart.bean.*;
import com.flipkart.dao.GymOwnerGMSDaoImpl;
import com.flipkart.exception.DataEntryException;
import com.flipkart.exception.GymDetailsNotFoundException;
import com.flipkart.exception.NoDataFoundException;
import com.flipkart.exception.NoGymOwnerIdFoundException;
import com.flipkart.dao.GymOwnerGMSDao;
import java.util.ArrayList;
import java.util.List;
/**
 * 
 */
public class GymOwnerGMSService implements GymOwnerGMSInterface{

	GymOwnerGMSDao gymOwnerGMSDao = new GymOwnerGMSDaoImpl();
	
	
	/**

	This method fetches the details of a gym owner based on the gym owner ID.
	@param gymOwnerId The ID of the gym owner
	@return The GymOwner object representing the gym owner details
	*/
	public GymOwner fetchOwnerDetails(String gymOwnerId) {
	return gymOwnerGMSDao.fetchOwnerDetails(gymOwnerId);
	}

	@Override
	public Gymnasium getGymInfo(int gymId) {
		return gymOwnerGMSDao.getGymInfo(gymId);
	}

	/**

	This method fetches all the possible slots that a gym owner can select from.
	@return The list of Slots objects representing the possible slots
	@throws NoDataFoundException if no slot data is found
	*/
	public List<Slots> fetchPossibleSlots() throws NoDataFoundException {
	try {
	return gymOwnerGMSDao.fetchPossibleSlots();
	} catch (Exception ex) {
	throw new NoDataFoundException();
	}
	}
	/**

	This method checks if a gym is already booked based on the gym ID.
	@param gymId The ID of the gym
	@return true if the gym is already booked, false otherwise
	*/
	public boolean checkIfAlreadyBooked(int gymId) {
	return gymOwnerGMSDao.checkIfAlreadyBooked(gymId);
	}
	/**

	This method allows a gym owner to add a particular slot for their gym.
	@param gymId The ID of the gym
	@param chosenSlots The chosen slots for the gym
	@param slotInfo The list of Slots objects representing the slot details
	*/
	public void addSlots(int gymId, String chosenSlots, List<Slots> slotInfo) {
	gymOwnerGMSDao.addSlots(gymId, chosenSlots, slotInfo);
	}
	
//	This method fetches the gym details that belong to a gym owner.
//	@param gymOwnerId The ID of the gym owner
//	@return The list of Gymnasium objects representing the gym details
//	@throws NoGymOwnerIdFoundException if the gym owner ID is not found
//	@throws NoDataFoundException if no gym data is found
	
	public List<Gymnasium> fetchGymDetails(String gymOwnerId) throws NoGymOwnerIdFoundException, NoDataFoundException {
	List<Gymnasium> gymList = new ArrayList<Gymnasium>();
	if (gymOwnerId == null) {
	throw new NoGymOwnerIdFoundException();
	}
	try {
	gymList = gymOwnerGMSDao.fetchGymDetails(gymOwnerId);
	} catch (Exception ex) {
	throw new NoDataFoundException();
	}
	return gymList;
	}
	/**

	This method allows a gym owner to add details of a particular gym.
	@param gymDetails The Gymnasium object representing the gym details
	@throws GymDetailsNotFoundException if the gym details are not found
	@throws DataEntryException if an error occurs while entering the gym details
	*/
	public void addGymDetails(Gymnasium gymDetails) throws GymDetailsNotFoundException, DataEntryException {
	if (gymDetails == null) {
	throw new GymDetailsNotFoundException();
	}
	try {
	gymOwnerGMSDao.addGymDetails(gymDetails);
	} catch (Exception ex) {
	throw new DataEntryException();
	}
	}
	/**

	This method checks if a gym owner is approved based on the email address.
	@param email The email address of the gym owner
	@return true if the gym owner is approved, false otherwise
	*/
	public boolean checkOwnerApproval(String email) {
	return gymOwnerGMSDao.checkOwnerApproval(email);
	}
	/**

	This method checks if a gym is approved based on the gym ID.
	@param gymId The ID of the gym
	@return true if the gym is approved, false otherwise
	*/
	public boolean checkGymApproval(int gymId) {
	return gymOwnerGMSDao.checkGymApproval(gymId);
	}
}