/**
 * 
 */
package com.flipkart.service;
import com.flipkart.bean.*;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 */
public class GymOwnerGMSService implements GymOwnerGMSInterface{
	List<GymOwner> gymOwners = new ArrayList<GymOwner>();
	List<Gymnasium> gymnasiums = new ArrayList<Gymnasium>();;
	
	public GymOwner fetchOwnerDetails(String gymOwnerUserName) {
		GymOwner gymOwnerDetails = null;
		for(GymOwner gymOwner: gymOwners) {
			if(gymOwner.getOwnerUserName().equals(gymOwnerUserName)) {
				gymOwnerDetails = gymOwner;
			}
		}
		return gymOwnerDetails;
	}
	
	public void addGymOwnerDetails(GymOwner gymOwnerDetails) {
		gymOwners.add(gymOwnerDetails);
	}
	
	public List<Gymnasium> fetchGymDetails(String gymOwnerUserName) {
		List<Gymnasium> gymnasiumDetails = new ArrayList<Gymnasium>();
		for(Gymnasium gymDetails: gymnasiums) {
			if(gymDetails.getOwnerUserName().equals(gymOwnerUserName)) {
				gymnasiumDetails.add(gymDetails);
			}
		}
		return gymnasiumDetails;
	}
	
	public void addGymDetails(Gymnasium gymDetails) {
		gymnasiums.add(gymDetails);
	}
}