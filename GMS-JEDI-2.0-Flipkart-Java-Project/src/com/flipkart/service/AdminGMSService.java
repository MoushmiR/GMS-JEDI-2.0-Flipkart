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
	
	// allows admin to see all the gym owners
	public List<GymOwner> seeAllGymOwner() {
		return adminGMSDao.seeAllGymOwner();
	}

	
	//allows admin to see all the gyms
	public List<Gymnasium> seeAllGyms() {
		return adminGMSDao.seeAllGyms();
	}
	
	
	//allows admin to see pending requests of gym owners to be approved
	public List<GymOwner> seePendingGymOwnerRequest() {
		return adminGMSDao.seePendingGymOwnerRequest();
	}
	
	
	//allows admin to see pending requests of gyms to be approved
	public List<Gymnasium> seePendingGymRequest() {
		return adminGMSDao.seePendingGymRequest();
	}

	
	//allows admin to approve a single gym owner
	public void approveSingleOwnerRequest(String email) {
		adminGMSDao.approveSingleOwnerRequest(email);
	}

	
	//allows admin to approve all the owners who are unappproved
	public void approveAllOwnerRequest() {
		adminGMSDao.approveAllOwnerRequest();
	}

	
	// allows admin to approve a single gym request
	public void approveSingleGymRequest(int gymId) {
		adminGMSDao.approveSingleGymRequest(gymId);
	}

	
	//allows admin to approve all the gym requests which are unapproved
	public void approveAllGymRequest() {
		adminGMSDao.approveAllGymRequest();
	}

}