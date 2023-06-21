package com.flipkart.service;
import java.util.List;

import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Gymnasium;

public interface GymOwnerGMSInterface {
	
	public GymOwner fetchOwnerDetails(String gymOwnerUserName);
	
	public void addGymDetails(Gymnasium gymDetails);
	
	public void addGymOwnerDetails(GymOwner gymOwnerDetails);
	
	public List<Gymnasium> fetchGymDetails(String gymOwnerUserName);
}