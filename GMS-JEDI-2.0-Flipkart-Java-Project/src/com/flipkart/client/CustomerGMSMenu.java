package com.flipkart.client;

import java.util.Scanner;

public class CustomerGMSMenu {
	public static void CustomerRegistration(Scanner in) {
		System.out.println("Enter your name: ");
		String name=in.next();
		System.out.println("Enter your mobile: ");
		String mobile=in.next();
		System.out.println("Enter your email: ");
		String email=in.next();
		System.out.println("Enter your address: ");
		String address=in.next();
		System.out.println("Enter your dob: ");
		String dob=in.next();
		System.out.println("Enter your username: ");
		String username = in.next();
		System.out.println("Enter your password: ");
		String password = in.next();
		CustomerActionPage(in);
	}

	public static void CustomerActionPage(Scanner in) {
		System.out.println("1.View Gyms \n2.View Slots\n3.Exit");
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
	
	public static void ViewCatalog(Scanner in) {
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
	
	public static void BookGym(Scanner in) {
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
