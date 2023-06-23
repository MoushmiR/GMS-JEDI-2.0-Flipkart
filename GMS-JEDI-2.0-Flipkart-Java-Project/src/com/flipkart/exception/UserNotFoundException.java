package com.flipkart.exception;

public class UserNotFoundException extends Exception{
	
	public UserNotFoundException() {
        System.out.println("User not found!");
    }
}
