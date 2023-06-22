/**
 * 
 */
package com.flipkart.client;
import java.util.*;

import com.flipkart.bean.User;
import com.flipkart.service.UserGMSService;

/**
 * 
 */
public class GMSApplicationClient {

	/**
	 * @param args
	 * 
	 * 
	 */
	
	
	public static void login()
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Enter your username: ");
		String username = in.next();
		System.out.println("Enter your correct password: ");
		String password = in.next();
		User user = new User(username,password,0);
		UserGMSService authentication = new UserGMSService();
		if(authentication.authenticateUser(user) != null) {
			System.out.println("Logged In");
			int role = user.getRoleId();
			switch(role) {
			case 1: 
				AdminGMSMenu Admin = new AdminGMSMenu();
				Admin.AdminPage(in);
			break;
			case 2:
				GymnasiumGMSMenu Owner = new GymnasiumGMSMenu();
				Owner.GymOwnerActionPage(in, user.getEmail());
			break;
			case 3: 
				CustomerGMSMenu Customer = new CustomerGMSMenu();
				Customer.CustomerActionPage(in);
			break;
			}
		}else {
			System.out.println("Invalid Credentials");
		}
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to FlipFit Gymnasium Application");
		System.out.println("Menu:");
		System.out.println("1. Login");
		System.out.println("2. Customer Registration");
		System.out.println("3. GymOwner Registration");
		System.out.println("4. Update Password");
		System.out.println("5. exit");
		
		Scanner in = new Scanner(System.in);
		int choice =in.nextInt();
		
		switch(choice) {
		case 1:
			login();
			break;
		case 2:
			CustomerGMSMenu Customer = new CustomerGMSMenu();
			Customer.CustomerRegistration(in);
			break;
		case 3:
			GymnasiumGMSMenu Owner = new GymnasiumGMSMenu();
			Owner.GymOwnerRegistration(in);
			break;
		case 4:
			System.out.println("Enter your current password");
			String currPassword = in.next();
			System.out.println("Enter your new password");
			String newPassword = in.next();
			System.out.println("Your password has been updated successfully!");
			break;
		case 5:
			System.out.println("Exiting.....");
			System.exit(0);
			break;
		default: 
			System.out.println("Wrong choice");
		}
	}




}
