package com.flipkart.dao;

import java.util.List;

import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Gymnasium;

public interface GymOwnerGMSDao {

	public GymOwner fetchOwnerDetails(String gymOwnerId);
	
//	public void addGymOwnerDetails(GymOwner gymOwnerDetails);
	
	public List<Gymnasium> fetchGymDetails(String gymOwnerId);
	public List<Gymnasium> fetchAllGymDetails();
	
	public void addGymDetails(Gymnasium gymDetails);
}
