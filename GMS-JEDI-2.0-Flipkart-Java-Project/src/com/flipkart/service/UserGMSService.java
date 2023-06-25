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
/**

This class represents the service layer for User Management System.
*/
public class UserGMSService {

		UserGMSDao userGMSDao = new UserGMSDaoImpl();
		
		/**
		
		Registers a customer in the database.
		@param customerData The Customer object representing the customer data
		*/
		public void registerCustomer(Customer customerData) {
		userGMSDao.registerCustomer(customerData);
		}
		/**
		
		Registers a gym owner in the database.
		@param ownerData The GymOwner object representing the gym owner data
		*/
		public void registerGymOwner(GymOwner ownerData) {
		userGMSDao.registerGymOwner(ownerData);
		}
		/**
		
		Authenticates a user based on the provided user data.
		@param userData The User object representing the user data
		@return The authenticated User object if authentication is successful, null otherwise
		*/
		public User authenticateUser(User userData) {
		try {
		User authenticatedUser = userGMSDao.isAuthenticated(userData);
		return authenticatedUser;
		} catch (UserNotFoundException excep) {
		System.out.println(excep.getMessage());
		}
		return null;
		}
		/**
		
		Registers a user in the database.
		@param userData The User object representing the user data
		*/
		public void registerUser(User userData) {
		userGMSDao.registerUser(userData);
		}
		/**
		
		Logs out a user.
		@param userData The User object representing the user data
		@return true if the user is successfully logged out, false otherwise
		*/
		public boolean logout(User userData) {
		// Perform logout logic here
		return true;
		}
}
