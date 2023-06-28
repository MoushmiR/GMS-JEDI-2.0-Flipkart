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
	
	/**
	 * Retrieves a list of all gym owners in the system.
	 * @return List of GymOwner objects
	 */
	public List<GymOwner> seeAllGymOwner();

	/**
	 * Retrieves a list of all gyms in the system.
	 * @return List of Gymnasium objects
	 */
	public List<Gymnasium> seeAllGyms();

	/**
	 * Retrieves a list of pending gym owner requests.
	 * @return List of GymOwner objects
	 */
	public List<GymOwner> seePendingGymOwnerRequest();

	/**
	 * Retrieves a list of pending gym requests.
	 * @return List of Gymnasium objects
	 */
	public List<Gymnasium> seePendingGymRequest();

	/**
	 * Approves a single gym owner request.
	 * @param requestId The ID of the request to be approved
	 */
	public void approveSingleOwnerRequest(String requestId);

	/**
	 * Approves all pending gym owner requests.
	 */
	public void approveAllOwnerRequest();

	/**
	 * Approves a single gym request.
	 * @param gymId The ID of the gym request to be approved
	 */
	public void approveSingleGymRequest(int gymId);

	/**
	 * Approves all pending gym requests.
	 */
	public void approveAllGymRequest();

}