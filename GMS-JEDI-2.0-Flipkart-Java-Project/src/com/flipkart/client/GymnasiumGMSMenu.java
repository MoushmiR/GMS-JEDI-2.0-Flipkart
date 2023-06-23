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
		
		System.out.println("Enter your email: ");
		gymOwner.setEmail(in.next());
		registration.setEmail(gymOwner.getEmail());
	
		System.out.println("Enter your name: ");
		gymOwner.setName(in.next());
		
		System.out.println("Enter your mobile: ");
		gymOwner.setMobile(in.next());
		
		System.out.println("Enter your address: ");
		gymOwner.setAddress(in.next());
		
		System.out.println("Enter your dob: ");
		gymOwner.setDob(in.next());
		
		System.out.println("Enter your Aadhar number: ");
		gymOwner.setAadhaarNumber(in.next());
		
		System.out.println("Enter your PAN number: ");
		gymOwner.setPanNumber(in.next());
		
		System.out.println("Enter your GST number: ");
		gymOwner.setGstNumber(in.next());
		
		System.out.println("Enter your password: ");
		String password = in.next();
		
		User user = new User(gymOwner.getEmail(),password,2);
		
		UserGMSService userService = new UserGMSService();
		userService.registerUser(user);
		userService.registerGymOwner(gymOwner);
//		System.out.println(gymOwner.getOwnerId());
		GymOwnerActionPage(in, gymOwner.getEmail());
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
		System.out.println("Enter the number of seats per slot: ");
		gymDetails.setNumSeatsPerSlot(in.nextInt());
//		System.out.println(gymOwner.getOwnerId());
		gymDetails.setGymOwnerEmail(gymOwner.getEmail());
//		System.out.println(gymDetails);
		
		gymOwnerService.addGymDetails(gymDetails);
		System.out.flush();
	}

	public void FetchGymDetails(Scanner in) {
//		GymOwnerGMSService gymOwnerService = new GymOwnerGMSService();
//		System.out.println("in fxn email: "+ gymOwner.getEmail());
		List<Gymnasium> gymDetails = gymOwnerService.fetchGymDetails(gymOwner.getEmail());
		System.out.println("Gym Id \t Name \t Number of Equipments \t Total-Area \t Address");
    	for(Gymnasium gym: gymDetails) {
			System.out.printf("%-5s\t", gym.getGymId());
			System.out.printf("%-8s\t", gym.getName());
			System.out.printf("%-8s\t", gym.getNumItem());
			System.out.printf("%-8s\t", gym.getTotalArea());
			System.out.printf("%-8s\t", gym.getAddress());
		}
    	System.out.println("");
	}
	
	public void AddSlots(Scanner in) {
		System.out.println("Enter the gym id for which you want to add slots: ");
		int gymId = in.nextInt();
		System.out.println("Select which slots you want to add in space separated numbers: \n");
		List<Slots> slotInfo = gymOwnerService.fetchPossibleSlots();
		for(Slots slot: slotInfo) {
			System.out.println(slot.getSlotId() + " " + slot.getSlotTime());
		}
		String chosenSlots = in.next();
		gymOwnerService.addSlots(gymId,chosenSlots);
	}
	
	public void GymOwnerActionPage(Scanner in, String email) {
		
			gymOwner.setEmail(email);
		
		while(true) {
			System.out.print("Enter your choice: \n");
			System.out.println("1.Add Gyms \n2.View Gymnasiums\n3.Add Slots\n4.Exit");
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
				AddSlots(in);
				break;
			case 4:
				break;
			// Default case statement
			default:
				System.out.println("incorrect choice");
			}
		}

	}
}