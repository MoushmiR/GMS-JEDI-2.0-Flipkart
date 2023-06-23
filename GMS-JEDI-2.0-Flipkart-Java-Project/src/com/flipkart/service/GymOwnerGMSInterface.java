package com.flipkart.service;
import java.util.List;

import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Gymnasium;
import com.flipkart.bean.Slots;

public interface GymOwnerGMSInterface {
	
	public GymOwner fetchOwnerDetails(String gymOwnerUserName);
	
	public void addGymDetails(Gymnasium gymDetails);
		
	public List<Gymnasium> fetchGymDetails(String gymOwnerUserName);
	
	public void addSlots(int gymId, String chosenSlots, List<Slots> slotInfo);
	
	public List<Slots> fetchPossibleSlots();
}