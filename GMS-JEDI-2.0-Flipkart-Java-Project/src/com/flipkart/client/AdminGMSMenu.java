/**
 * 
 */
package com.flipkart.client;

import java.util.Scanner;


/**
 * 
 */
public class AdminGMSMenu {
	
	public static void viewPendingApprovals(Scanner in) {
		// TODO Auto-generated method stub
		System.out.println("1. Approve by id");
		System.out.println("2. Approve all");
		System.out.println("3. Exit");
		int choice = in.nextInt()
;		switch (choice) {
		// Case statements
		case 1:
			System.out.println("Enter the id to approve:");
			int id = in.nextInt();
			System.out.println("Gym id :" + id + "approved");
			break;
		case 2:
			System.out.println("All Gym Approved");
			break;
		case 3:
			System.exit(0);
			break;
		// Default case statement
		default:
			System.out.println("incorrect choice");
		}
	}
	public static void AdminPage(Scanner in) {
		System.out.println("1. View Pending approvals");
		System.out.println("2. Exit");
		System.out.print("Enter your choice: ");
		int choice = in.nextInt();
		switch (choice) {
		// Case statements
		case 1:
			viewPendingApprovals(in);
			break;
		case 2:
			System.exit(0);
			break;
		// Default case statement
		default:
			System.out.println("Wrong choice");
		}

	}

	
	
}
