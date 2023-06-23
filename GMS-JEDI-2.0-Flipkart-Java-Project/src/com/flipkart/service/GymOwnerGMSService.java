/**
 * 
 */
package com.flipkart.service;
import com.flipkart.bean.*;
import com.flipkart.dao.GymOwnerGMSDaoImpl;
import com.flipkart.exception.DataEntryException;
import com.flipkart.exception.GymDetailsNotFoundException;
import com.flipkart.exception.NoDataFoundException;
import com.flipkart.exception.NoGymOwnerIdFoundException;
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
	
	
	 public List<Slots> fetchPossibleSlots() throws NoDataFoundException{
	        List<Slots> slotList = new ArrayList<Slots>();
	        try {
	            slotList=gymOwnerGMSDao.fetchPossibleSlots();
	        }
	        catch(Exception ex) {
	            throw new NoDataFoundException();
	        }
	        return slotList;
	    }
	
	public void addSlots(int gymId, String chosenSlots, List<Slots> slotInfo) {
		gymOwnerGMSDao.addSlots(gymId,chosenSlots,slotInfo);
	}
	
	
	public List<Gymnasium> fetchGymDetails(String gymOwnerId) throws NoGymOwnerIdFoundException, NoDataFoundException {
        List<Gymnasium> gymList = new ArrayList<Gymnasium>();
        if(gymOwnerId == null) {
            throw new NoGymOwnerIdFoundException();
        }
        try {
        gymList=gymOwnerGMSDao.fetchGymDetails(gymOwnerId);
        }
        catch(Exception ex){
            throw new NoDataFoundException();
 
        }
        return gymList;
    }
	
	public void addGymDetails(Gymnasium gymDetails) throws GymDetailsNotFoundException, DataEntryException {
        if(gymDetails == null) {
            throw new GymDetailsNotFoundException();
        }
        try {
        gymOwnerGMSDao.addGymDetails(gymDetails);
        }
        catch(Exception ex) {
            throw new DataEntryException();
        }
    }
}