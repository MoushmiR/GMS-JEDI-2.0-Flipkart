/**
 * 
 */
package com.flipkart.service;

import com.flipkart.bean.*;
import com.flipkart.dao.*;
import java.util.List;

/**
 * This class implements the AdminGMSInterface and provides the functionality for admin operations in the Gym Management System.
 */
public class AdminGMSService implements AdminGMSInterface {

	AdminGMSDao adminGMSDao = new AdminGMSDaoImpl();
	
	/**
	 * Retrieves a list of all gym owners in the system.
	 * @return List of GymOwner objects
	 */
	public List<GymOwner> seeAllGymOwner() {
		return adminGMSDao.seeAllGymOwner();
	}

	/**
	 * Retrieves a list of all gyms in the system.
	 * @return List of Gymnasium objects
	 */
	public List<Gymnasium> seeAllGyms() {
		return adminGMSDao.seeAllGyms();
	}
	
	/**
	 * Retrieves a list of pending gym owner requests.
	 * @return List of GymOwner objects
	 */
	public List<GymOwner> seePendingGymOwnerRequest() {
		return adminGMSDao.seePendingGymOwnerRequest();
	}
	
	/**
	 * Retrieves a list of pending gym requests.
	 * @return List of Gymnasium objects
	 */
	public List<Gymnasium> seePendingGymRequest() {
		return adminGMSDao.seePendingGymRequest();
	}


	public void approveSingleOwnerRequest(String email) {
		adminGMSDao.approveSingleOwnerRequest(email);
	}

	/**
	 * Approves all pending gym owner requests.
	 */
	public void approveAllOwnerRequest() {
		adminGMSDao.approveAllOwnerRequest();
	}

	/**
	 * Approves a single gym request.
	 * @param gymId The ID of the gym request to be approved
	 */
	public void approveSingleGymRequest(int gymId) {
		adminGMSDao.approveSingleGymRequest(gymId);
	}

	/**
	 * Approves all pending gym requests.
	 */
	public void approveAllGymRequest() {
		adminGMSDao.approveAllGymRequest();
	}
}