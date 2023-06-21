/**
 * 
 */
package com.flipkart.service;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import com.flipkart.bean.*;

/**
 * 
 */
public class UserService {
	User user1 = new User("Ayush", "psw1", 3);
	User user2 = new User("Naman", "psw2", 3);
	User user3 = new User("Rahul", "psw3", 3);
	List<User> userList = new ArrayList<>(Arrays.asList(user1, user2, user3));
	List<Registration> registrationInfo = new ArrayList<Registration>();
//	List<User> userList = new ArrayList<User>();
	public void registerCustomer(Registration customerData) {
//		registrationInfo.add(customerData)
;	}
	
	public void registerGymOwner(Registration ownerData) {
		registrationInfo.add(ownerData);
	}
	
	public boolean authenticateUser(User userData) {
		boolean authenticated = false;
		
		for(User us: userList)
		{
			if(userData.getUserName().equals(us.getUserName()) && userData.getPassword().equals(us.getPassword()) && userData.getRoleId() == (us.getRoleId())) {
				authenticated = true;
				break;
			}
		}
		return authenticated;
	}
	
	public void registerUser(User userData) {
		userList.add(userData);
	}
	public boolean logout(User userData) {
		return true;
	}
}
