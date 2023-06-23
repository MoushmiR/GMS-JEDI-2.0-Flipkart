/**
 * 
 */
package com.flipkart.service;
import java.util.List;
import com.flipkart.dao.UserGMSDao;
import com.flipkart.dao.UserGMSDaoImpl;
import com.flipkart.exception.*;
import java.util.ArrayList;
import java.util.Arrays;

import com.flipkart.bean.*;

/**
 * 
 */
public class UserGMSService {

	UserGMSDao userGMSDao = new UserGMSDaoImpl();
	public void registerCustomer(Customer customerData) {
		userGMSDao.registerCustomer(customerData);
;	}
	
	public void registerGymOwner(GymOwner ownerData) {
		
		userGMSDao.registerGymOwner(ownerData);
	}
	
	public User authenticateUser(User userData)  throws UserNotFoundException {
		return userGMSDao.isAuthenticated(userData);
//		return userGMSDao.isAuthenticated(userData);
	}
	
	public void registerUser(User userData) {
		userGMSDao.registerUser(userData);
	}
	
	public boolean logout(User userData) {
		return true;
	}
}
