/**
 * 
 */
package com.flipkart.client;

import java.util.Scanner;

import com.flipkart.service.AdminGMSService;
import java.util.List;
import com.flipkart.bean.*;

/**
 * 
 */
public class AdminGMSMenu {
	
	AdminGMSService adminService = new AdminGMSService();
	
	public void approveAllGymRequest() {
		adminService.approveAllGymRequest();
;	}

	public void approveSingleGymRequest(Scanner in) {
		// TODO Auto-generated method stub
		System.out.println("Enter the gym Id: ");
		int gymId = in.nextInt();
		adminService.approveSingleGymRequest(gymId);
		
	}

	public void approveAllOwnerRequest() {
		// TODO Auto-generated method stub
		adminService.approveAllOwnerRequest();
	}

	public void approveSingleOwnerRequest(Scanner in) {
		// TODO Auto-generated method stub
		System.out.println("Enter the owner email: ");
		String email = in.next();
		adminService.approveSingleOwnerRequest(email);
		
	}

	public void viewPendingGymRequests() {
		// TODO Auto-generated method stub
		List<Gymnasium> gymDetails = adminService.seePendingGymRequest();
		
		for(Gymnasium gym: gymDetails) {
			System.out.println(gym.getName() + " " + gym.getAddress() + " " + gym.getTotalArea());
		}		
	}

	public void viewPendingGymOwnerRequests() {
		// TODO Auto-generated method stub
		List<GymOwner> gymOwnerDetails = adminService.seePendingGymOwnerRequest();
		
		for(GymOwner gymOwner: gymOwnerDetails) {
			System.out.println(gymOwner.getName() + " " + gymOwner.getEmail() + " " + gymOwner.getAddress());
		}		
	}

	public void viewAllGyms() {
		// TODO Auto-generated method stub
		List<Gymnasium> gymDetails = adminService.seeAllGyms();
		
		for(Gymnasium gym: gymDetails) {
			System.out.println(gym.getName() + " " + gym.getAddress() + " " + gym.getTotalArea());
		}		
	}

	public void viewAllGymOwners() {
		
		List<GymOwner> gymOwnerDetails = adminService.seeAllGymOwner();
		
		for(GymOwner gymOwner: gymOwnerDetails) {
			System.out.println(gymOwner.getName() + " " + gymOwner.getEmail() + " " + gymOwner.getAddress());
		}		
	}
	
	public void AdminPage(Scanner in) {
		while(true) {
			System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println("1. View All Gym Owners");
			System.out.println("2. View All Gyms");
			System.out.println("3. View Pending Gym Owner Requests");
			System.out.println("4. View Pending Gym Requests");
			System.out.println("5. Approve Single Gym Owner Request");
			System.out.println("6. Approve All Gym Owner Requests");
			System.out.println("7. Approve Single Gym Requests");
			System.out.println("8. Approve All Gym Requests");
			System.out.println("9. Exit");
			System.out.print("Enter your choice: ");
			int choice = in.nextInt();
			switch (choice) {
			// Case statements
			case 1:
				viewAllGymOwners();
				break;
			case 2:
				viewAllGyms();
				break;
			case 3:
				viewPendingGymOwnerRequests();
				break;
			case 4:
				viewPendingGymRequests();
				break;
			case 5:
				approveSingleOwnerRequest(in);
				break;
			case 6:
				approveAllOwnerRequest();
				break;
			case 7:
				approveSingleGymRequest(in);
				break;
			case 8:
				approveAllGymRequest();
				break;
			case 9:
				System.exit(0);
				break;
			// Default case statement
			default:
				System.out.println("Wrong choice");
			}
		}

	}

	

	
	
}