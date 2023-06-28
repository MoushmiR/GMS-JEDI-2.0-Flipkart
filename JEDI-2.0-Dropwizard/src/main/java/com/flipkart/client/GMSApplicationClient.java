/**
 * 
 */
package com.flipkart.client;
import java.util.*;


import com.flipkart.bean.User;
import com.flipkart.service.UserGMSService;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
/**
 * 
 */
public class GMSApplicationClient {


	
	
	public static void login() throws Exception
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Enter your username: ");
		String username = in.next();
		System.out.println("Enter your correct password: ");
		String password = in.next();
		User user = new User(username,password,0);
		UserGMSService authentication = new UserGMSService();
		LocalDateTime localDateTime = LocalDateTime.now();
		if(authentication.authenticateUser(user) != null) {
			System.out.println("Welcome " + username + "! You are logged in.");
			System.out.println("Current Date and Time: "+ localDateTime);
			int role = user.getRoleId();
			switch(role) {
			case 1: 
				CustomerGMSMenu Customer = new CustomerGMSMenu();
				Customer.CustomerActionPage(in, user.getEmail());
				
			break;
			case 2:
				GymnasiumGMSMenu Owner = new GymnasiumGMSMenu();
				Owner.GymOwnerActionPage(in, user.getEmail());
			break;
			case 3: 
				AdminGMSMenu Admin = new AdminGMSMenu();
				Admin.AdminPage(in);
			break;
			}
		}else {
			login();
		}
		
	}
	
	public static void mainPage() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Welcome to FlipFit Gymnasium Application");
		System.out.println("Menu:");
		System.out.println("1. Login");
		System.out.println("2. Customer Registration");
		System.out.println("3. GymOwner Registration");
		System.out.println("4. exit");
		
		Scanner in = new Scanner(System.in);
		try {
			int choice =in.nextInt();
			
			switch(choice) {
			case 1:
				login();
				break;
			case 2:
				CustomerGMSMenu Customer = new CustomerGMSMenu();
				Customer.CustomerRegistration(in);
				System.out.println("Please Login");
				login();
				break;
			case 3:
				GymnasiumGMSMenu Owner = new GymnasiumGMSMenu();
				Owner.GymOwnerRegistration(in);
				System.out.println("Please Login");
				login();
				break;
			case 4:
				System.out.println("Exiting.....");
				System.exit(0);
				break;
			default: 
				System.out.println("Wrong choice");
				mainPage();
			}
		}
		catch(InputMismatchException excep) {
			System.out.println("Please give relevant input!");
			mainPage();
		}
		
		
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		mainPage();
	}


	




}
