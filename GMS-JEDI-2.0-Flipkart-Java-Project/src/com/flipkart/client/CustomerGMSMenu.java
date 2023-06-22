package com.flipkart.client;

import java.util.Scanner;

import com.flipkart.bean.Customer;
import com.flipkart.bean.User;
import com.flipkart.service.CustomerGMSService;
import com.flipkart.service.UserGMSService;

public class CustomerGMSMenu {
    
    CustomerGMSService customerService = new CustomerGMSService();
    Customer customer = new Customer();
    public void CustomerRegistration(Scanner in) {
        System.out.println("Enter your email: ");
        String email=in.next();
        System.out.println("Enter your name: ");
        String name=in.next();
        System.out.println("Enter your address: ");
        String address=in.next();
        System.out.println("Enter your mobile: ");
        String mobile=in.next();
        System.out.println("Enter your dob: ");
        String dob=in.next();
        System.out.println("Enter your password: ");
        String password = in.next();
        User user = new User(email,password,1);
        UserGMSService userService = new UserGMSService();
        userService.registerUser(user);
        userService.registerCustomer(customer);
        CustomerActionPage(in);
    }
    public void CustomerBookings(Scanner in) {
    	
    }
    public void CustomerActionPage(Scanner in) {
        int flag = 1;
        while(flag==1)
        {
        	System.out.println("1.View all Gymnasiums \n2.View my Bookings\n3.Logout");
        	System.out.print("Enter your choice: ");
            int choice = in.nextInt();
            switch (choice) {
            // Case statements
            case 1:
                ViewGyms(in);
                break;
            case 2:
                System.out.println("My Bookings");
                CustomerBookings(in);
                break;
            case 3:
                flag = 0;
                break;
            // Default case statement
            default:
                System.out.println("incorrect choice");
            }
        }
        

    }
    
    public void ViewGyms(Scanner in) {
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
            ViewGyms(in);
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