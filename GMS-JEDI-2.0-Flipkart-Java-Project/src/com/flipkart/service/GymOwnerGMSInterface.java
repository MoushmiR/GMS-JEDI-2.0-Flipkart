package com.flipkart.service;

import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Gymnasium;

public interface GymOwnerGMSInterface {
	public GymOwner fetchOwnerDetails();
	
	public Gymnasium addGymDetails(); 
}
