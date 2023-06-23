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
//		CustomerActionPage(in, customer.getEmail());
	}
	
	public void viewCatalog(Scanner in, String email) {
//		System.out.println("Welcome to FlipFit Gymnasium Application");
//		System.out.println("Menu:-");
		customerGMSService.fetchGymList();
		
		System.out.print("Choose Gym ID: ");
		int gymId = in.nextInt();
		
		customerGMSService.fetchAvilableSlots(gymId);
		System.out.print("Enter Slot ID for which you want to make booking: ");
		String slotId = in.next();
		
		boolean flag =customerGMSService.checkSlotExists(slotId, gymId);
		if(flag ==false)
		{
			System.out.println("No slots found for this gym");
			CustomerActionPage(in, email);
			return;
		}
		
		System.out.print("Enter your Date: ");
		String date = in.next();
		
		int response = customerGMSService.bookSlots(gymId, slotId, email, date);
		switch (response) {
			case 0:
				System.out.println("This time is already booked\nCancelling that slot and booking new");
				
				break;
			case 1:
				System.out.println("There are no more slots left");
				break;
			case 2:
				System.out.println("Congratulations your slot is booked");
				break;
			// Default case statement
			default:
				System.out.println("Incorrect choice!!! Please try again!!!");
		}
	}

	public void CustomerActionPage(Scanner in, String email) {
		int choice = 0;
		
		while(choice != 3) {
//			System.out.println("Welcome to FlipFit Gymnasium Application");
			
			System.out.println("Menu:-");
			System.out.println("1.View Gyms \n2.View Booked Slots\n3.Exit");
			System.out.print("Enter your choice: ");
			choice = in.nextInt();
			
			switch (choice) {
				case 1:
					viewCatalog(in, email);
					break;
				case 2:
					customerGMSService.fetchBookedSlots(email);
					break;
				case 3:
					System.exit(0);
					break;
				default:
					System.out.println("Incorrect choice!!! Please try again!!!");
			}
		}

	}
	
//	public void ViewCatalog(Scanner in) {
//		System.out.println("1.Gym1 \n2.Gym2\n3.Exit");
//		System.out.print("Enter your choice: ");
//		int choice = in.nextInt();
//		switch (choice) {
//		// Case statements
//		case 1:
//			BookGym(in);
//			break;
//		case 2:
//			BookGym(in);
//			break;
//		case 3:
//			System.exit(0);
//			break;
//		// Default case statement
//		default:
//			System.out.println("incorrect choice");
//		}
//
//	}
	
//	public void BookGym(Scanner in) {
//		System.out.println("1.Slot1 \n2.Slot2\n3.Go Back\n4.Exit");
//		System.out.print("Enter your choice: ");
//		int choice = in.nextInt();
//		switch (choice) {
//		// Case statements
//		case 1:
//			System.out.println("Slot Booked");
//			break;
//		case 2:
//			System.out.println("Slot Full Please select another slot");
//			break;
//		case 3:
//			ViewCatalog(in);
//			break;
//		case 4:
//			System.exit(0);
//			break;
//		// Default case statement
//		default:
//			System.out.println("incorrect choice");
//		}
//
//	}
}
