/**
 * 
 */
package com.flipkart.client;
import java.util.*;

/**
 * 
 */
public class AppClient {

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
		System.out.println("Enter your password: ");
		String password = in.next();
		System.out.println("Welcome "+ username + "! You are logged in.");
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
	public static void CustomerActionPage() {
		Scanner in = new Scanner(System.in);
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
	public static void customerRegistration()
	{
		Scanner in = new Scanner(System.in);
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
		CustomerActionPage();
	}
	
	public static void gymOwnerRegistration()
	{
		Scanner in = new Scanner(System.in);
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
		System.out.println("Enter your Aadhar number: ");
		String aadhaarNumber=in.next();
		System.out.println("Enter your PAN number: ");
		String panNumber=in.next();
		System.out.println("Enter your GST number: ");
		String gstNumber=in.next();
		System.out.println("Enter your username: ");
		String username = in.next();
		System.out.println("Enter your password: ");
		String password = in.next();
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
			customerRegistration();
			break;
		case 3:
			gymOwnerRegistration();
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
