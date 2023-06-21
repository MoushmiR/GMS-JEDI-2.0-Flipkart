/**
 * 
 */
package com.flipkart.service;
import java.util.List;
import com.flipkart.dao.UserGMSDao;
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
	public void registerCustomer(Registration customerData) {
		UserGMSDao userGMSDao = new UserGMSDao();
		userGMSDao.registerCustomer(customerData);
;	}
	
	public void registerGymOwner(Registration ownerData) {
		UserGMSDao userGMSDao = new UserGMSDao();
		userGMSDao.registerGymOwner(ownerData);
	}
	
	public boolean authenticateUser(User userData) {
		UserGMSDao userGMSDao = new UserGMSDao();
		return userGMSDao.isAuthenticated(userData);
	}
	
	public void registerUser(User userData) {
		UserGMSDao userGMSDao = new UserGMSDao();
		userGMSDao.registerUser(userData);
	}
	
	public boolean logout(User userData) {
		return true;
	}
}
