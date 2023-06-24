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
	
	public GymOwner fetchOwnerDetails(String gymOwnerUserName);
	
	public void addGymDetails(Gymnasium gymDetails) throws GymDetailsNotFoundException, DataEntryException;
		
	public List<Gymnasium> fetchGymDetails(String gymOwnerUserName) throws NoGymOwnerIdFoundException, NoDataFoundException;
	
	public void addSlots(int gymId, String chosenSlots, List<Slots> slotInfo);
	
	public List<Slots> fetchPossibleSlots() throws NoDataFoundException;
	
	public boolean checkOwnerApproval(String email);
	
	public boolean checkGymApproval(int gymId);
	
	public boolean checkIfAlreadyBooked(int gymId);
}