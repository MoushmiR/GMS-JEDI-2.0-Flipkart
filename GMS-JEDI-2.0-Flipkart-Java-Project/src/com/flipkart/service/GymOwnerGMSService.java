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

	GymOwnerGMSDao gymOwnerGMSDao = new GymOwnerGMSDaoImpl();
	
	public GymOwner fetchOwnerDetails(String gymOwnerId) {
		
		return gymOwnerGMSDao.fetchOwnerDetails(gymOwnerId);
	}
	
	
	public List<Slots> fetchPossibleSlots(){
		return gymOwnerGMSDao.fetchPossibleSlots();
	}
	
	public void addSlots(int gymId, String chosenSlots, List<Slots> slotInfo) {
		gymOwnerGMSDao.addSlots(gymId,chosenSlots,slotInfo);
	}
	
	
	public List<Gymnasium> fetchGymDetails(String gymOwnerId) {
		
		return gymOwnerGMSDao.fetchGymDetails(gymOwnerId);
	}
	
	public void addGymDetails(Gymnasium gymDetails) {
		
		gymOwnerGMSDao.addGymDetails(gymDetails);
	}
}