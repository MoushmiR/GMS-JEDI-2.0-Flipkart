package com.flipkart.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.*;
import com.flipkart.constants.SQLConstants;
import com.flipkart.exception.NoSlotsFoundException;
import com.flipkart.utils.DBUtils;

public class CustomerGMSDaoImpl implements CustomerGMSDao {


	public List<Gymnasium> fetchGymList() {
//		System.out.println("Connecting to database...");
		List<Gymnasium> gymDetails = new ArrayList<Gymnasium>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DBUtils.getConnection();
		    stmt = conn.prepareStatement(SQLConstants.SQL_FETCH_ALL_APPROVED_GYMS);
	
		    ResultSet rs = stmt.executeQuery();
		    while (rs.next()) {
				Gymnasium gym = new Gymnasium();
				gym.setGymId(rs.getInt("gymId"));
				gym.setGymOwnerEmail(rs.getString("gymOwnerEmail"));
				gym.setName(rs.getString("name"));
				gym.setAddress(rs.getString("address"));
				gym.setNumItem(rs.getInt("numItem"));
				gym.setNumSeatsPerSlot(rs.getInt("numSeatsPerSlot"));
				gym.setTotalArea(rs.getDouble("totalArea"));
				gym.setIsApproved(rs.getInt("isApproved"));
				gymDetails.add(gym);
			}
//		    System.out.println("*********************************************");
	    } catch(SQLException sqlExcep) {
		       System.out.println(sqlExcep);
	    } catch(Exception excep) {
	           excep.printStackTrace();
	    }
		return gymDetails;
	}

	public List<SlotsNew> fetchSlotList(int gymId) throws NoSlotsFoundException{
//		System.out.println("Connecting to database...");
		List<SlotsNew> allSlots = new ArrayList<SlotsNew>();
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = DBUtils.getConnection();
			stmt = conn.prepareStatement(SQLConstants.SQL_FETCH_GYM_SLOT_QUERY);
			stmt.setInt(1, gymId);
			ResultSet output = stmt.executeQuery();
			while(output.next()) {
				SlotsNew slotsNew = new SlotsNew();
				slotsNew.setSlotId(output.getString(1));
				slotsNew.setCapacity(output.getInt(2));
				slotsNew.setSlotTime(output.getString(3));
				slotsNew.setGymId(output.getInt(4));
				System.out.println("");
				allSlots.add(slotsNew);
			}
		} catch(SQLException sqlExcep) {
			System.out.println(sqlExcep);
		}
		return allSlots;
	}
	
	public Object bookSlots(int gymId, String slotId, String email, String date) {
//		System.out.println("Connecting to database...");
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

		return null;
	}
	
	public boolean isFull(String slotId,String date) {
//		System.out.println("Connecting to database...");
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

	public List<UserBookings> fetchBookedSlots(String email) {

		List<UserBookings> bookedSlots = new ArrayList<UserBookings>();

		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = DBUtils.getConnection();
			stmt = conn.prepareStatement(SQLConstants.SQL_FETCH_BOOKED_SLOT_QUERY);
			stmt.setString(1, email);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				UserBookings userBooking = new UserBookings();
				userBooking.setBookingId(rs.getInt("bookingId"));
				userBooking.setSlotId(rs.getString("slotId"));
				userBooking.setName(rs.getString("name"));
				userBooking.setDate(rs.getString("date"));
				userBooking.setAddress(rs.getString("address"));
				userBooking.setStartTime(rs.getString("startTime"));
				bookedSlots.add(userBooking);
			}
		} catch(SQLException sqlExcep) {
			System.out.println(sqlExcep);
		} catch(Exception excep) {
			excep.printStackTrace();
		}
		return bookedSlots;
	}
	
	
	public void cancelBooking(String slotId, String email, String date) {
//	System.out.println("Connecting to database...");
		
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
//	System.out.println("Connecting to database...");
		
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
	
	public boolean checkSlotExists(String slotId, int gymId) {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DBUtils.getConnection();
		    stmt = conn.prepareStatement(SQLConstants.SQL_CHECK_SLOT_QUERY);
		    stmt.setString(1, slotId); 
		    stmt.setInt(2, gymId);
//		    stmt.setString(3, date);
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


	public void cancelBookedSlots(int bookingId) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DBUtils.getConnection();
		    stmt = conn.prepareStatement(SQLConstants.SQL_CANCEL_BOOKING);
		    stmt.setInt(1, bookingId); 
		    stmt.executeUpdate();
		} catch(SQLException sqlExcep) {
		       System.out.println(sqlExcep);
		} catch(Exception excep) {
		       excep.printStackTrace();
		}
		
	}

	@Override
	public boolean checkGymApprove(int gymId) {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DBUtils.getConnection();
		    stmt = conn.prepareStatement(SQLConstants.SQL_CHECK_GYM_APPROVE);
		    stmt.setInt(1, gymId);
//		    stmt.setString(3, date);
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

	@Override
	public int findAvailableSlots(int gymId, String slotId, String date) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DBUtils.getConnection();
			stmt = conn.prepareStatement(SQLConstants.SQL_FIND_USED_SLOTS);
			stmt.setInt(1, gymId);
		    stmt.setString(2, date);
			stmt.setString(3,slotId);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			GymOwnerGMSDao gymOwnerGMSDao = new GymOwnerGMSDaoImpl();
			Gymnasium gymDetails = gymOwnerGMSDao.getGymInfo(gymId);
			return gymDetails.getNumSeatsPerSlot() - rs.getInt("COUNT(*)");
		} catch(SQLException sqlExcep) {
			System.out.println(sqlExcep);
		} catch(Exception excep) {
			excep.printStackTrace();
		}
		return -1;
	}

	public List<SlotsNew> allAvailableSlots(int gymId, String date){
		List<SlotsNew> allSlots = new ArrayList<SlotsNew>();

		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = DBUtils.getConnection();
			stmt = conn.prepareStatement(SQLConstants.SQL_CHECK_SLOT_FOR_GYM);
			stmt.setInt(1, gymId);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				SlotsNew slotInfo = new SlotsNew();
				slotInfo.setGymId(rs.getInt("gymId"));
				slotInfo.setSlotId(rs.getString("slotId"));
				slotInfo.setCapacity(findAvailableSlots(gymId,rs.getString("slotId"),date));
				slotInfo.setSlotTime(rs.getString("slotTime"));
				allSlots.add(slotInfo);
			}
		} catch(SQLException sqlExcep) {
			System.out.println(sqlExcep);
		} catch(Exception excep) {
			excep.printStackTrace();
		}
		return allSlots;
	}

}
