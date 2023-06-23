package com.flipkart.exception;

public class NoGymOwnerIdFoundException extends Exception {

	public NoGymOwnerIdFoundException() {
        System.out.println("GymOwner email was not found!");
    }
}
