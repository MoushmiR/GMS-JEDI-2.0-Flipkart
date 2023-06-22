/**
 * 
 */
package com.flipkart.service;
import java.util.List;
import com.flipkart.bean.*;
/**
 * 
 */
public interface AdminGMSInterface {
	
	public List<GymOwner> seeAllGymOwner();
	
	public List<Gymnasium> seeAllGyms();
	
	public List<GymOwner> seePendingGymOwnerRequest();
	
	public List<Gymnasium> seePendingGymRequest();
	
	public void approveSingleOwnerRequest(String requestId);
	
	public void approveAllOwnerRequest();
	
	public void approveSingleGymRequest(int gymId);
	
	public void approveAllGymRequest();
	
}