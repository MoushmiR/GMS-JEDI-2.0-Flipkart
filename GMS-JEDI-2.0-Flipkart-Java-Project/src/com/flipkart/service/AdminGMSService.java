/**
 * 
 */
package com.flipkart.service;

import com.flipkart.bean.*;
import com.flipkart.dao.*;
import java.util.List;

/**
 * 
 */
public class AdminGMSService implements AdminGMSInterface {

	AdminGMSDao adminGMSDao = new AdminGMSDaoImpl();
	
	public List<GymOwner> seeAllGymOwner() {
		return adminGMSDao.seeAllGymOwner();
	}

	public List<Gymnasium> seeAllGyms() {
		return adminGMSDao.seeAllGyms();
	}

	public List<GymOwner> seePendingGymOwnerRequest() {
		return adminGMSDao.seePendingGymOwnerRequest();
	}

	public List<Gymnasium> seePendingGymRequest() {
		return adminGMSDao.seePendingGymRequest();
	}

	
	public void approveSingleOwnerRequest(String email) {
		adminGMSDao.approveSingleOwnerRequest(email);
	}

	public void approveAllOwnerRequest() {
		adminGMSDao.approveAllOwnerRequest();
	}

	
	public void approveSingleGymRequest(int gymId) {
		adminGMSDao.approveSingleGymRequest(gymId);
	}

	
	public void approveAllGymRequest() {
		adminGMSDao.approveAllGymRequest();
	}

}