package com.flipkart.exception;

public class GymDetailsNotFoundException extends Exception {
	public GymDetailsNotFoundException() {
        System.out.println("GymDetails not found");
    }
}
