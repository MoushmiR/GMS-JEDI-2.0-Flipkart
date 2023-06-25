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
	
	//registers customer in the database
	public void registerCustomer(Customer customerData) {
		userGMSDao.registerCustomer(customerData);
;	}
	
	
	//registers gym owner in the database
	public void registerGymOwner(GymOwner ownerData) {	
		userGMSDao.registerGymOwner(ownerData);
	}
	
	
	//used to login a user
	public User authenticateUser(User userData) {
		try {
			User authenticatedUser = userGMSDao.isAuthenticated(userData);
			return authenticatedUser;
		}
		catch(UserNotFoundException excep) {
			System.out.println(excep.getMessage());
		}
		return null;
	}
	
	
	//used to regsiter a user
	public void registerUser(User userData) {
		userGMSDao.registerUser(userData);
	}
	
	
	//used to logout a user
	public boolean logout(User userData) {
		return true;
	}
}
