/**
 * 
 */
package com.flipkart.service;
import java.util.List;
import com.flipkart.dao.UserGMSDao;
import com.flipkart.dao.UserGMSDaoImpl;

import java.util.ArrayList;
import java.util.Arrays;

import com.flipkart.bean.*;

/**
 * 
 */
public class UserGMSService {
//	User user1 = new User("Ayush", "psw1", 3);
//	User user2 = new User("Naman", "psw2", 3);
//	User user3 = new User("Rahul", "psw3", 3);
//	List<User> userList = new ArrayList<>(Arrays.asList(user1, user2, user3));
//	List<Registration> registrationInfo = new ArrayList<Registration>();
////	List<User> userList = new ArrayList<User>();
	
	UserGMSDao userGMSDao = new UserGMSDaoImpl();
	public void registerCustomer(Customer customerData) {
		userGMSDao.registerCustomer(customerData);
;	}
	
	public void registerGymOwner(GymOwner ownerData) {
		
		userGMSDao.registerGymOwner(ownerData);
	}
	
	public User authenticateUser(User userData) {
		return userGMSDao.isAuthenticated(userData);
	}
	
	public void registerUser(User userData) {
		userGMSDao.registerUser(userData);
	}
	
	public boolean logout(User userData) {
		return true;
	}
}
