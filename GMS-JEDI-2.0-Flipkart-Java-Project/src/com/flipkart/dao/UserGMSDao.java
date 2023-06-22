package com.flipkart.dao;
import com.flipkart.bean.Registration;
import com.flipkart.bean.User;

public interface UserGMSDao {
	
	public boolean isAuthenticated(User userData);
	
	public void registerCustomer(Registration customerData);
	
	public void registerGymOwner(Registration ownerData);
	
	public void registerUser(User userData);
}
