package com.flipkart.client;
import com.flipkart.service.*;
import java.util.List;
import java.util.Scanner;

import com.flipkart.bean.*;
import com.flipkart.service.*;

public class CustomerGMSMenu {
	
	Customer customer = new Customer();
	CustomerGMSInterface customerGMSService = new CustomerGMSService();
	
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
	
	public void viewCatalog(Scanner in, String email) throws Exception {
//		System.out.println("Welcome to FlipFit Gymnasium Application");
//		System.out.println("Menu:-");
		fetchGymList();
		
		System.out.print("Choose Gym ID: ");
		int gymId = in.nextInt();
		boolean check = customerGMSService.checkGymApprove(gymId);
		
		if(check == false)
		{
			System.out.println("This gym has not been approved yet!");
			viewCatalog(in, email);
			return;
		}
		boolean slotsAvailable = customerGMSService.fetchAvilableSlots(gymId);
		if(slotsAvailable) {
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
		else {
			viewCatalog(in,email);
		}
		
	}
	
	public void fetchGymList() {
		List<Gymnasium> gymDetails = customerGMSService.fetchGymList();
		 System.out.println("Gym Id \t  GymOwner \t       GymName");
    	for(Gymnasium gym: gymDetails) {
    		System.out.printf("%-5s\t", gym.getGymId() );
			System.out.printf("%-5s\t",gym.getGymOwnerEmail());
			System.out.printf("%-5s\t", gym.getName() );
	    	System.out.println("");
		}
    	System.out.println("**********************************");
		
	}

	private void cancelBookedSlots(Scanner in, String email) {
		customerGMSService.fetchBookedSlots(email);
		System.out.print("Enter Booking ID that you want to cancel: ");
		int bookingId =in.nextInt();
		customerGMSService.cancelBookedSlots(email, bookingId);

		
	}
	
	public void CustomerActionPage(Scanner in, String email) throws Exception {
		int choice = 0;
		
		while(choice != 4) {
//			System.out.println("Welcome to FlipFit Gymnasium Application");
			
			System.out.println("Menu:-");
			System.out.println("1.View Gyms \n2.View Booked Slots \n3.Cancel Booked Slots \n4.Exit");
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
					cancelBookedSlots(in, email);
					break;
				case 4:
					GMSApplicationClient.mainPage();
					break;
				default:
					System.out.println("Incorrect choice!!! Please try again!!!");
			}
		}

	}
}
