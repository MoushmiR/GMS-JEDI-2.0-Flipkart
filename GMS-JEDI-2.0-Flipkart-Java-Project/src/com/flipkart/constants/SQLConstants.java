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
	public static final String SQL_ALL_SLOTS="INSERT INTO SlotsNew values(?, ?, ?, ?)";
	public static final String SQL_INSERT_CUSTOMER_DETAILS_QUERY="INSERT INTO Customer values(?, ?, ?, ?, ?)";
	public static final String SQL_FETCH_GYM_SLOT_QUERY = "Select * From SlotsNew Where gymId=?";
	public static final String SQL_FIND_CAPACITY="SELECT * FROM Gymnasium WHERE gymId=?";
	public static final String SQL_COUNT_CURRENT_CAPACITY_QUERY = "Select Count(*) From BookedSlot Where slotId=? AND date=?";
	public static final String SQL_CHECK_CAPACITY_QUERY = "Select * From SlotsNew Where slotId=?";
	public static final String SQL_BOOK_SLOT_QUERY="INSERT INTO BookedSlot (slotId,gymId,customerEmail,date) values(?, ?, ?, ?)";
	public static final String SQL_FETCH_BOOKED_SLOT_QUERY="Select * From BookedSlot where customerEmail = ?";
	public static final String SQL_ALREADY_BOOKED_SLOT_QUERY = "Select * from BookedSlot where customerEmail = ? and slotId = ? and date = ?";
	public static final String SQL_CANCEL_BOOKED_SLOT_QUERY = "Delete from BookedSlot where customerEmail = ? and slotId = ? and date = ?";
	public static final String SQL_CHECK_SLOT_QUERY = "Select * from SlotsNew where slotId = ? and gymId= ?";
	public static final String SQL_FETCH_ALL_APPROVED_GYMS = "SELECT * FROM Gymnasium WHERE isApproved=1";
	public static final String SQL_CANCEL_BOOKING = "Delete from BookedSlot where BookingId = ?";
	public static final String SQL_CHECK_GYM_APPROVE = "Select * from Gymnasium where gymId=? and isApproved=1";
	public static final String SQL_CHECK_OWNER_APPROVE = "Select * from GymOwner where email=? and approved=1";
	public static final String SQL_CHECK_SLOT_FOR_GYM = "SELECT * FROM SlotsNew WHERE gymId=?";
}
