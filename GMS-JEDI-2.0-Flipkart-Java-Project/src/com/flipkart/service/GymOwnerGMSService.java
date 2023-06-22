/**
 * 
 */
package com.flipkart.service;
import com.flipkart.bean.*;
import com.flipkart.dao.GymOwnerGMSDaoImpl;
import com.flipkart.dao.GymOwnerGMSDao;
import java.util.ArrayList;
import java.util.List;
/**
 * 
 */
public class GymOwnerGMSService implements GymOwnerGMSInterface{
//	List<GymOwner> gymOwners = new ArrayList<GymOwner>();
//	List<Gymnasium> gymnasiums = new ArrayList<Gymnasium>();;
	GymOwnerGMSDao gymOwnerGMSDao = new GymOwnerGMSDaoImpl();
	
	public GymOwner fetchOwnerDetails(String gymOwnerId) {
//		GymOwner gymOwnerDetails = null;
//		for(GymOwner gymOwner: gymOwners) {
//			if(gymOwner.getOwnerUserName().equals(gymOwnerUserName)) {
//				gymOwnerDetails = gymOwner;
//			}
//		}
//		return gymOwnerDetails;
		
		return gymOwnerGMSDao.fetchOwnerDetails(gymOwnerId);
	}
	
//	public void addGymOwnerDetails(GymOwner gymOwnerDetails) {
////		gymOwners.add(gymOwnerDetails);
//		
//		gymOwnerGMSDao.addGymOwnerDetails(gymOwnerDetails);
//	}
	
	public List<Gymnasium> fetchGymDetails(String gymOwnerId) {
//		List<Gymnasium> gymnasiumDetails = new ArrayList<Gymnasium>();
//		for(Gymnasium gymDetails: gymnasiums) {
//			if(gymDetails.getOwnerUserName().equals(gymOwnerUserName)) {
//				gymnasiumDetails.add(gymDetails);
//			}
//		}
//		return gymnasiumDetails;
		
		return gymOwnerGMSDao.fetchGymDetails(gymOwnerId);
	}
	
	public List<Gymnasium> fetchAllGymDetails() {
//		List<Gymnasium> gymnasiumDetails = new ArrayList<Gymnasium>();
//		for(Gymnasium gymDetails: gymnasiums) {
//			if(gymDetails.getOwnerUserName().equals(gymOwnerUserName)) {
//				gymnasiumDetails.add(gymDetails);
//			}
//		}
//		return gymnasiumDetails;
		
		return gymOwnerGMSDao.fetchAllGymDetails();
	}
	
	public void addGymDetails(Gymnasium gymDetails) {
//		gymnasiums.add(gymDetails);
		
		gymOwnerGMSDao.addGymDetails(gymDetails);
	}
}