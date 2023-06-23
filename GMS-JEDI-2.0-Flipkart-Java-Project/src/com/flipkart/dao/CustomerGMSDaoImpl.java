package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.flipkart.bean.Gymnasium;
import com.flipkart.constants.SQLConstants;
import com.flipkart.utils.DBUtils;

public class CustomerGMSDaoImpl implements CustomerGMSDao {
	
	public void fetchGymList() {
		System.out.println("Connecting to database...");
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DBUtils.getConnection();
		    stmt = conn.prepareStatement(SQLConstants.SQL_FETCH_ALL_GYMS);
	
		    ResultSet output = stmt.executeQuery();
		    while(output.next()) {
		    	System.out.println(output.getString(1) + " " + output.getString(2) + " " + output.getString(3));
		    }
	    } catch(SQLException sqlExcep) {
		       System.out.println(sqlExcep);
	    } catch(Exception excep) {
	           excep.printStackTrace();
	    }
	}
	
	public void fetchSlotList(int gymId) {
		System.out.println("Connecting to database...");
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DBUtils.getConnection();
		    stmt = conn.prepareStatement(SQLConstants.SQL_FETCH_GYM_SLOT_QUERY);
		    stmt.setInt(1, gymId); 
		    ResultSet output = stmt.executeQuery();
		    while(output.next()) {
		    	System.out.println(output.getString(1) + " " + output.getString(2) + " " + output.getString(3));
		    }
	    } catch(SQLException sqlExcep) {
		       System.out.println(sqlExcep);
	    } catch(Exception excep) {
	           excep.printStackTrace();
	    }
	}
	
	public void bookSlots(int gymId, String slotId,String email,String date) {
		System.out.println("Connecting to database...");
		Connection conn = null;
		PreparedStatement stmt = null;
		   
	    try {
	    	conn = DBUtils.getConnection();
		   
		    stmt = conn.prepareStatement(SQLConstants.SQL_BOOK_SLOT_QUERY);
		    stmt.setString(1, slotId);
		    stmt.setInt(2, gymId);
		    stmt.setString(3, email);
		    stmt.setString(4, date);
		    
		    stmt.executeUpdate();
		    
	    } catch(SQLException sqlExcep) {
		       System.out.println(sqlExcep);
	    } catch(Exception excep) {
	           excep.printStackTrace();
	    }
	    
	    return;
	}
	
	public boolean isFull(String slotId,String date) {
		System.out.println("Connecting to database...");
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DBUtils.getConnection();
		    stmt = conn.prepareStatement(SQLConstants.SQL_COUNT_CURRENT_CAPACITY_QUERY);
		    stmt.setString(1, slotId); 
		    stmt.setString(2, date); 
		    ResultSet output = stmt.executeQuery();
		    output.next();
		    int current_capacity = output.getInt(1);
		    stmt = conn.prepareStatement(SQLConstants.SQL_CHECK_CAPACITY_QUERY);
		    stmt.setString(1, slotId); 
		    output = stmt.executeQuery();
		    output.next();
		    int total_capacity = output.getInt(2);
		    return current_capacity>=total_capacity;
	    } catch(SQLException sqlExcep) {
		       System.out.println(sqlExcep);
	    } catch(Exception excep) {
	           excep.printStackTrace();
	    }
		return false;
	}
	
	public void fetchBookedSlots(String email) {

		
		System.out.println("Connecting to database...");
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DBUtils.getConnection();
		    stmt = conn.prepareStatement(SQLConstants.SQL_FETCH_BOOKED_SLOT_QUERY);
		    stmt.setString(1, email); 
		    ResultSet output = stmt.executeQuery();
		    while(output.next()) {
		    	System.out.println("Booking id: " + output.getInt(1) + " Date:" + output.getString(5) + " GymId:" + output.getString(3));
		    }
		} catch(SQLException sqlExcep) {
		       System.out.println(sqlExcep);
		} catch(Exception excep) {
		       excep.printStackTrace();
		}
    }
	
	
	public void cancelBooking(String slotId, String email, String date) {
	System.out.println("Connecting to database...");
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DBUtils.getConnection();
		    stmt = conn.prepareStatement(SQLConstants.SQL_CANCEL_BOOKED_SLOT_QUERY);
		    stmt.setString(1, email); 
		    stmt.setString(2, slotId);
		    stmt.setString(3, date);
		    stmt.executeUpdate();
		
		} catch(SQLException sqlExcep) {
		       System.out.println(sqlExcep);
		} catch(Exception excep) {
		       excep.printStackTrace();
		}
//		return false;
		
		
	}
	
	
	public boolean alreadyBooked(String slotId, String email, String date) {
	System.out.println("Connecting to database...");
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DBUtils.getConnection();
		    stmt = conn.prepareStatement(SQLConstants.SQL_ALREADY_BOOKED_SLOT_QUERY);
		    stmt.setString(1, email); 
		    stmt.setString(2, slotId);
		    stmt.setString(3, date);
		    ResultSet output = stmt.executeQuery();
		    if(output.next())
		    	return true;
		} catch(SQLException sqlExcep) {
		       System.out.println(sqlExcep);
		} catch(Exception excep) {
		       excep.printStackTrace();
		}
		return false;
	}
	
	
	
}
