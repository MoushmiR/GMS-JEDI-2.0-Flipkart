/**
 * 
 */
package com.flipkart.service;
import com.flipkart.bean.*;

/**
 * 
 */
public class GymOwnerGMSService implements GymOwnerGMSInterface {
	public GymOwner fetchOwnerDetails() {
		return new GymOwner();
	}
	
	public Gymnasium addGymDetails() {
		return new Gymnasium();
	}
	
}
