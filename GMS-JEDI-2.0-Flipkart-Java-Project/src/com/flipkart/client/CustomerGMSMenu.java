package com.flipkart.client;

import java.util.Scanner;

import com.flipkart.bean.*;
import com.flipkart.service.*;

public class CustomerGMSMenu {
	
	Customer customer = new Customer();
	CustomerGMSService customerGMSService = new CustomerGMSService();
	
	public void CustomerRegistration(Scanner in) {
		System.out.println("Enter your name: ");
		customer.setName(in.next());
		System.out.println("Enter your mobile: ");
		customer.setMobile(in.next());
		System.out.println("Enter your email: ");
		customer.setEmail(in.next());
		System.out.println("Enter your address: ");
		customer.setAddress(in.next());
		System.out.println("Enter your dob: ");
		customer.setDob(in.next());
		System.out.println("Enter your password: ");
		String password = in.next();
		User user = new User(customer.getEmail(),password,1);
		UserGMSService userService = new UserGMSService();
		userService.registerUser(user);
		userService.registerCustomer(customer);
		CustomerActionPage(in, customer.getEmail());
	}

	public void CustomerActionPage(Scanner in, String email) {
		customer.setEmail(email);
		
		System.out.println("1.View Gyms \n2.View Current Bookings\n3.Exit");
		System.out.print("Enter your choice: ");
		int choice = in.nextInt();
		switch (choice) {
		// Case statements
		case 1:
			ViewCatalog(in);
			break;
		case 2:
			System.out.println("Viewing Booked Slots");
			break;
		case 3:
			System.exit(0);
			break;
		// Default case statement
		default:
			System.out.println("incorrect choice");
		}

	}
	
	public void ViewCatalog(Scanner in) {
		System.out.println("1.Gym1 \n2.Gym2\n3.Exit");
		System.out.print("Enter your choice: ");
		int choice = in.nextInt();
		switch (choice) {
		// Case statements
		case 1:
			BookGym(in);
			break;
		case 2:
			BookGym(in);
			break;
		case 3:
			System.exit(0);
			break;
		// Default case statement
		default:
			System.out.println("incorrect choice");
		}

	}
	
	public void BookGym(Scanner in) {
		System.out.println("1.Slot1 \n2.Slot2\n3.Go Back\n4.Exit");
		System.out.print("Enter your choice: ");
		int choice = in.nextInt();
		switch (choice) {
		// Case statements
		case 1:
			System.out.println("Slot Booked");
			break;
		case 2:
			System.out.println("Slot Full Please select another slot");
			break;
		case 3:
			ViewCatalog(in);
			break;
		case 4:
			System.exit(0);
			break;
		// Default case statement
		default:
			System.out.println("incorrect choice");
		}

	}
}
