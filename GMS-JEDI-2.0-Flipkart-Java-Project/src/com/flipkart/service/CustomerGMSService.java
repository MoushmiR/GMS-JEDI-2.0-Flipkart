/**
 * 
 */
package com.flipkart.service;
import com.flipkart.bean.*;
import java.time.LocalDate;
import com.flipkart.dao.*;
/**
 * 
 */
public class CustomerGMSService implements CustomerGMSInterface{ 
	CustomerGMSDao customerDao = new CustomerGMSDaoImpl();
	public Customer fetchCustomerDetails(String customerId) {
		return new Customer();
	}
	
	public void fetchGymList() {
		customerDao.fetchGymList();
		return;
	}
	
	public void fetchAvilableSlots(int gymId) {
		customerDao.fetchSlotList(gymId);
	}
	
	public int bookSlots(int gymId, String slotId, String email,String date) {
		if(alreadyBooked(slotId,email,date)) {
			return 0;
		}else if(isFull(slotId,date)) {
			return 1;
		}else {
			customerDao.bookSlots(gymId, slotId, email, date);
			return 2;
		}
	}
	
	public boolean alreadyBooked(String slotId,String email,String date) {
		return false;
	}
	
	public boolean isFull(String slotId,String date) {
		return customerDao.isFull(slotId, date);
	}
	
	public boolean bookSlot(String slotId,String email,String date) {
		return true;
	}
	
	public void fetchBookedSlots(String email) {
		customerDao.fetchBookedSlots(email);
	}


}
