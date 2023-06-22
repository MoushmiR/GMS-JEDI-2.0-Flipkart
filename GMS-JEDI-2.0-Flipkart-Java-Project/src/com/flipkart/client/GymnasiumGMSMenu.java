package com.flipkart.client;

import java.util.List;
import java.util.Scanner;
import com.flipkart.bean.*;
import com.flipkart.service.GymOwnerGMSService;
import com.flipkart.service.UserGMSService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class GymnasiumGMSMenu {
	
	
//	List<User> users;
	GymOwner gymOwner = new GymOwner();
	GymOwnerGMSService gymOwnerService = new GymOwnerGMSService();
	public void GymOwnerRegistration(Scanner in) {
		Registration registration = new Registration();
		
		System.out.println("Enter your name: ");
		gymOwner.setName(in.next());
		
		System.out.println("Enter your ID: ");
		gymOwner.setOwnerUserName(in.next());
		registration.setUserName(gymOwner.getOwnerUserName());
		
		System.out.println("Enter your mobile: ");
		gymOwner.setMobile(in.next());
		registration.setMobile(gymOwner.getMobile());
		
		System.out.println("Enter your email: ");
		gymOwner.setEmail(in.next());
		registration.setEmail(gymOwner.getEmail());
		
		System.out.println("Enter your address: ");
		gymOwner.setAddress(in.next());
		registration.setAddress((gymOwner.getAddress()));
		
		System.out.println("Enter your dob: ");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
		String st = in.next();
		gymOwner.setDob(LocalDate.parse(st, dtf));
		registration.setDob(gymOwner.getDob());
		
		System.out.println("Enter your Aadhar number: ");
		gymOwner.setAadhaarNumber(in.next());
		
		System.out.println("Enter your PAN number: ");
		gymOwner.setPanNumber(in.next());
		registration.setPanNumber(gymOwner.getPanNumber());
		
		System.out.println("Enter your GST number: ");
		gymOwner.setGstNumber(in.next());
		registration.setGstNumber(gymOwner.getGstNumber());
		
		System.out.println("Enter your username: ");
		String username = in.next();
		System.out.println("Enter your password: ");
		String password = in.next();
		
		User user = new User(username,password,2);
		
		UserGMSService userService =new UserGMSService();
		userService.registerGymOwner(registration);
		userService.registerUser(user);
//		System.out.println(gymOwner.getOwnerId());
		GymOwnerActionPage(in);
		System.out.flush();
	}
	

	public void GymRegistration(Scanner in) {
		Gymnasium gymDetails = new Gymnasium(); 
		System.out.println("Add gym Details:-");
		System.out.print("Add gymnasium name: ");
		gymDetails.setName(in.next());
		System.out.print("Enter the number of equipments: ");
		gymDetails.setNumItem(in.nextInt());
		System.out.print("Enter gymnasium address: ");
		gymDetails.setAddress(in.next());
		System.out.print("Add gymnasium area in square foot: ");
		gymDetails.setTotalArea(in.nextDouble());
//		System.out.println(gymOwner.getOwnerId());
		gymDetails.setOwnerId(gymOwner.getOwnerUserName());
//		System.out.println(gymDetails);
		
		gymOwnerService.addGymDetails(gymDetails);
		System.out.flush();
	}

	public void FetchGymDetails(Scanner in) {
		System.out.println("Enter gym owner Id\n");
//		GymOwnerGMSService gymOwnerService = new GymOwnerGMSService();
		List<Gymnasium> gymDetails = gymOwnerService.fetchGymDetails(in.next());
		for(Gymnasium gymnasium: gymDetails) {
			System.out.println(gymnasium);
		}
	}
	
	public void GymOwnerActionPage(Scanner in) {

		System.out.println("1.Add Gyms \n2.View Gymnasiums\n3.Exit");
		while(true) {
			System.out.print("Enter your choice: ");
			int choice = in.nextInt();
			switch (choice) {
			// Case statements
			case 1:
				GymRegistration(in);
				break;
			case 2:
				FetchGymDetails(in);
				break;
			case 3:
				System.exit(0);
				break;
			// Default case statement
			default:
				System.out.println("incorrect choice");
			}
		}

	}
}