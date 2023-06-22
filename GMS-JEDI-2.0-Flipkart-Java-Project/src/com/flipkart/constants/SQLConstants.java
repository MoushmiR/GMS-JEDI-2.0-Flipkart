package com.flipkart.constants;

public class SQLConstants {
	
	public static final String SQL_INSERT_GYM_DETAILS_QUERY = "insert into Gymnasium (gymOwnerEmail, name, address, totalArea, numItem, numSeatsPerSlot, isApproved) values(?, ?, ?, ?, ?, ?, ?)";
	public static final String SQL_FETCH_GYMOWNER_DETAILS_QUERY = "select * from GymOwmer where email=?";
	public static final String SQL_FETCH_GYM_DETAILS_QUERY ="select * from Gymnasium where gymOwnerEmail=?";
	public static final String SQL_AUTH_QUERY= "SELECT * FROM User WHERE email = ? AND password = ?";
	public static final String SQL_INSERT_GYMOWNER_DETAILS_QUERY = "insert into GymOwner values(?,?, ?, ?,?, ?, ?,?, ?)";
	public static final String SQL_INSERT_USER_DETAILS_QUERY = "insert into User values(?,?,?)";
	public static final String SQL_INSERT_CUSTOMER_DETAILS_QUERY = "insert into Customer values(?,?,?,?,?)";
}
