package com.flipkart.constants;

public class SQLConstants {
	
	public static final String SQL_INSERT_GYM_DETAILS_QUERY = "insert into Gymnasium (gymOwnerEmail, name, address, totalArea, numItem, numSeatsPerSlot, isApproved) values(?, ?, ?, ?, ?, ?, ?)";
	public static final String SQL_FETCH_GYMOWNER_DETAILS_QUERY = "select * from GymOwmer where email=?";
	public static final String SQL_FETCH_GYM_DETAILS_QUERY ="select * from Gymnasium where gymOwnerEmail=?";
	public static final String SQL_AUTH_QUERY= "SELECT * FROM User WHERE email = ? AND password = ?";
	public static final String SQL_INSERT_GYMOWNER_DETAILS_QUERY = "insert into GymOwner values(?,?, ?, ?,?, ?, ?,?, ?)";
	public static final String SQL_INSERT_USER_DETAILS_QUERY = "insert into User values(?,?,?)";
	public static final String SQL_FETCH_ALL_GYMOWNERS="SELECT * FROM GymOwner";
	public static final String SQL_FETCH_ALL_GYMS="SELECT * FROM Gymnasium";
	public static final String SQL_FETCH_NOT_APPROVED_GYMOWNERS="SELECT * FROM GymOwner WHERE approved=0";
	public static final String SQL_APPROVE_ALL_GYMS="Update Gymnasium Set isApproved=1";
	public static final String SQL_FETCH_NOT_APPROVED_GYMS="SELECT * FROM Gymnasium WHERE isApproved=0";
	public static final String SQL_APPROVE_ALL_GYMOWNERS="Update GymOwner Set approved=1";
	public static final String SQL_APPROVE_GYM_BY_ID="Update Gymnasium Set isApproved=1 WHERE gymId=?";
	public static final String SQL_APPROVE_GYM_OWNER_BY_ID="Update GymOwner Set approved=1 WHERE email=?";
	public static final String SQL_FETCH_ALL_SLOTS="SELECT * FROM Slots";
	public static final String SQL_ALL_SLOTS="INSERT INTO GymSlots (gymId, slotId) values(?, ?)";
}
