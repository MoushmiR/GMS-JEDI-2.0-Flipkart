/**
 * 
 */
package com.flipkart.service;
import com.flipkart.bean.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.flipkart.dao.*;
import com.flipkart.exception.NoSlotsFoundException;
/**
 * 
 */
public class CustomerGMSService implements CustomerGMSInterface{ 
	CustomerGMSDao customerDao = new CustomerGMSDaoImpl();
	
	//fetches customer details based on customerId
	public Customer fetchCustomerDetails(String customerId) {
		return new Customer();
	}
	
	
	//fetches all gyms list for the customer
	public List<Gymnasium> fetchGymList() {
		List<Gymnasium> gymList =  customerDao.fetchGymList();
		return gymList;
	}
	
	
	//fetches all available slots for a particular gym
	public boolean fetchAvilableSlots(int gymId){
		try {
			customerDao.fetchSlotList(gymId);
			return true;
		}catch(NoSlotsFoundException excep) {
			System.out.println(excep.getMessage());
		}
		return false;
	}
	
	
	//allows customer to book a slot
	public int bookSlots(int gymId, String slotId, String email,String date) {
		if(alreadyBooked(slotId,email,date)) {
			customerDao.cancelBooking(slotId, email, date);
			customerDao.bookSlots(gymId, slotId, email, date);
			return 0;
		}else if(isFull(slotId,date)) {
			return 1;
		}else {
			customerDao.bookSlots(gymId, slotId, email, date);
			return 2;
		}
	}
	
	
	//checks if the current slot is already booked
	public boolean alreadyBooked(String slotId,String email,String date) {
		return customerDao.alreadyBooked(slotId, email, date);
	}
	
	
	//checks if the current slot is full or available
	public boolean isFull(String slotId,String date) {
		return customerDao.isFull(slotId, date);
	}
	
	
	//fetches booked slots
	public void fetchBookedSlots(String email) {
		customerDao.fetchBookedSlots(email);
	}

	
	//checks if a slot is available
	public boolean checkSlotExists(String slotId, int gymId) {	
		return customerDao.checkSlotExists(slotId, gymId);
	}


	public void cancelBookedSlots(String email, int bookingId) {
		customerDao.cancelBookedSlots(email, bookingId);
		
	}


	public boolean checkGymApprove(int gymId) {
		return customerDao.checkGymApprove(gymId);
		// TODO Auto-generated method stub
		
	}

}
