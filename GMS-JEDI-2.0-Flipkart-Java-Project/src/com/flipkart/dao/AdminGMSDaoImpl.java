package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Gymnasium;
import com.flipkart.constants.SQLConstants;
import com.flipkart.utils.DBUtils;

public class AdminGMSDaoImpl implements AdminGMSDao{
	
	Connection conn = null;
	PreparedStatement stmt = null;
	
	public List<GymOwner> seeAllGymOwner() {
		
		List<GymOwner> gymOwnerDetails = new ArrayList<GymOwner>();

		try {
			conn = DBUtils.getConnection();
			System.out.println("Fetching gym owners..");

			stmt = conn.prepareStatement(SQLConstants.SQL_FETCH_ALL_GYMOWNERS);

			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				GymOwner gymOwner = new GymOwner();
				gymOwner.setName(rs.getString("name"));
				gymOwner.setEmail(rs.getString("email"));
				gymOwner.setAddress(rs.getString("address"));
				gymOwnerDetails.add(gymOwner);
			}

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		}

		return gymOwnerDetails;
	}

	public List<Gymnasium> seeAllGyms() {
		
		List<Gymnasium> gymDetails = new ArrayList<Gymnasium>();

		try {
			conn = DBUtils.getConnection();
			System.out.println("Fetching gyms..");

			stmt = conn.prepareStatement(SQLConstants.SQL_FETCH_ALL_GYMS);

			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Gymnasium gym = new Gymnasium();
				gym.setName(rs.getString("name"));
				gym.setAddress(rs.getString("address"));
				gym.setTotalArea(rs.getDouble("totalArea"));
				gymDetails.add(gym);
			}

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		}

		return gymDetails;
		// TODO Auto-generated method stub
		
	}

	public List<GymOwner> seePendingGymOwnerRequest() {
		// TODO Auto-generated method stub
		List<GymOwner> gymOwnerDetails = new ArrayList<GymOwner>();

		try {
			conn = DBUtils.getConnection();
			System.out.println("Fetching pending gym owners..");

			stmt = conn.prepareStatement(SQLConstants.SQL_FETCH_NOT_APPROVED_GYMOWNERS);

			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				GymOwner gymOwner = new GymOwner();
				gymOwner.setName(rs.getString("name"));
				gymOwner.setEmail(rs.getString("email"));
				gymOwner.setAddress(rs.getString("address"));
				gymOwnerDetails.add(gymOwner);
			}

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		}

		return gymOwnerDetails;
	}

	public List<Gymnasium> seePendingGymRequest() {
		// TODO Auto-generated method stub
		List<Gymnasium> gymDetails = new ArrayList<Gymnasium>();

		try {
			conn = DBUtils.getConnection();
			System.out.println("Fetching gyms..");

			stmt = conn.prepareStatement(SQLConstants.SQL_FETCH_NOT_APPROVED_GYMS);

			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Gymnasium gym = new Gymnasium();
				gym.setName(rs.getString("name"));
				gym.setAddress(rs.getString("address"));
				gym.setTotalArea(rs.getDouble("totalArea"));
				gymDetails.add(gym);
			}

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		}

		return gymDetails;
	}

	
	public void approveSingleOwnerRequest(String email) {
		// TODO Auto-generated method stub
		try {
			conn = DBUtils.getConnection();
			System.out.println("Fetching gyms owners..");

			stmt = conn.prepareStatement(SQLConstants.SQL_APPROVE_GYM_OWNER_BY_ID);
			stmt.setString(1, email);
			stmt.executeUpdate();
			System.out.println("The gym owner has been approved!");

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		}
	}
	

	public void approveAllOwnerRequest() {
		// TODO Auto-generated method stub
		try {
			conn = DBUtils.getConnection();

			stmt = conn.prepareStatement(SQLConstants.SQL_APPROVE_ALL_GYMOWNERS);
			stmt.executeUpdate();
			System.out.println("All gyms owners have been approved!");

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		}
	}

	
	public void approveSingleGymRequest(int gymId) {
		// TODO Auto-generated method stub
		try {
			conn = DBUtils.getConnection();
			System.out.println("Fetching gyms..");

			stmt = conn.prepareStatement(SQLConstants.SQL_APPROVE_GYM_BY_ID);
			stmt.setInt(1, gymId);
			stmt.executeUpdate();
			System.out.println("The gym has been approved!");

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		}
	}

	
	public void approveAllGymRequest() {

		try {
			conn = DBUtils.getConnection();
			System.out.println("Fetching gyms..");

			stmt = conn.prepareStatement(SQLConstants.SQL_APPROVE_ALL_GYMS);
			stmt.executeUpdate();
			System.out.println("All gyms have been approved!");

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
	}

}
