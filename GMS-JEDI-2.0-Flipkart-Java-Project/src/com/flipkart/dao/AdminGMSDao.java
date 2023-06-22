

/**
 * 
 * 
 * Method has to be designed similar to service class with DAO
 */
package com.flipkart.dao;
import com.flipkart.bean.*;
import java.util.List;

/**
 * 
 */
public interface AdminGMSDao {
	
	public List<GymOwner> seeAllGymOwner();
	
	public List<Gymnasium> seeAllGyms();
	
	public List<GymOwner> seePendingGymOwnerRequest();
	
	public List<Gymnasium> seePendingGymRequest();
	
	public void approveSingleOwnerRequest(String requestId);
	
	public void approveAllOwnerRequest();
	
	public void approveSingleGymRequest(int gymId);
	
	public void approveAllGymRequest();
	
}
