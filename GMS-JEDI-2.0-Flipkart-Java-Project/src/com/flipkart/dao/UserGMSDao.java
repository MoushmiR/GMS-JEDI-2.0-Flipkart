package com.flipkart.dao;
import com.flipkart.bean.*;
import com.flipkart.bean.User;

public interface UserGMSDao {
	
	public User isAuthenticated(User userData);
	
	public void registerCustomer(Registration customerData);
	
	public void registerGymOwner(GymOwner ownerData);
	
	public void registerUser(User userData);
}
