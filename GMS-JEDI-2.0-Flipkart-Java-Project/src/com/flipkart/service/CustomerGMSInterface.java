package com.flipkart.service;

import java.time.LocalDate;

import com.flipkart.bean.Customer;
import com.flipkart.bean.Slots;

public interface CustomerGMSInterface {
	public Customer fetchCustomerDetails(String customerId); 
	
	public void fetchGymList(LocalDate date) ;
	
	public Slots selectSlot();
}
