package com.flipkart.exception;

public class NoGymOwnerIdFoundException extends Exception {

	@Override
	public String getMessage() {
		return "No gym found!";
	}
}
