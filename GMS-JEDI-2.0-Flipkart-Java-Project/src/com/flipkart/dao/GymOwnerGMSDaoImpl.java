package com.flipkart.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Gymnasium;
import com.flipkart.constants.SQLConstants;
import com.flipkart.utils.DBUtils;

public class GymOwnerGMSDaoImpl implements GymOwnerGMSDao {
	Connection conn = null;
	PreparedStatement stmt = null;

	public GymOwner fetchOwnerDetails(String gymOwnerEmail) {
		GymOwner gymOwnerDetails = new GymOwner();

		try {
			conn = DBUtils.getConnection();
			System.out.println("Fetching gym...");

			stmt = conn.prepareStatement(SQLConstants.SQL_FETCH_GYMOWNER_DETAILS_QUERY);
			stmt.setString(1, gymOwnerEmail);

			ResultSet rs = stmt.executeQuery();
			gymOwnerDetails.setEmail(rs.getString("email"));
			gymOwnerDetails.setName(rs.getString("name"));
			gymOwnerDetails.setMobile(rs.getString("mobile"));
			gymOwnerDetails.setDob(rs.getString("dob"));
			gymOwnerDetails.setAadhaarNumber(rs.getString("aadhaarNumber"));
			gymOwnerDetails.setPanNumber(rs.getString("panNumber"));
			gymOwnerDetails.setGstNumber(rs.getString("gstNumber"));
			gymOwnerDetails.setAddress(rs.getString("address"));
			gymOwnerDetails.setApproved(rs.getBoolean("approved"));

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		}

		return gymOwnerDetails;

	}

//	public void addGymOwnerDetails(GymOwner gymOwnerDetails) {
//		// todo
//	}

	public List<Gymnasium> fetchGymDetails(String gymOwnerId) {
		
		List<Gymnasium> gymDetails = new ArrayList<Gymnasium>();


		try {
			conn = DBUtils.getConnection();
			System.out.println("Fetching gym...");

			stmt = conn.prepareStatement(SQLConstants.SQL_FETCH_GYM_DETAILS_QUERY);
			stmt.setString(1, gymOwnerId);

			ResultSet rs = stmt.executeQuery();
			System.out.println("Gym Owner Email : " + gymOwnerId);
			while (rs.next()) {
				Gymnasium gym = new Gymnasium();
				gym.setGymId(rs.getInt("gymId"));
				gym.setGymOwnerEmail(rs.getString("gymOwnerEmail"));
				gym.setName(rs.getString("name"));
				gym.setAddress(rs.getString("address"));
				gym.setNumItem(rs.getInt("numItem"));
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
	
public List<Gymnasium> fetchAllGymDetails() {
		
		List<Gymnasium> gymDetails = new ArrayList<Gymnasium>();


		try {
			conn = DBUtils.getConnection();
			System.out.println("Fetching gym...");

			stmt = conn.prepareStatement(SQLConstants.SQL_FETCH_ALL_GYM_DETAILS_QUERY);
//			stmt.setString(1, gymOwnerId);

			ResultSet rs = stmt.executeQuery();
//			System.out.println("Gym Owner Email : " + gymOwnerId);
			while (rs.next()) {
				Gymnasium gym = new Gymnasium();
				gym.setGymId(rs.getInt("gymId"));
				gym.setGymOwnerEmail(rs.getString("gymOwnerEmail"));
				gym.setName(rs.getString("name"));
				gym.setAddress(rs.getString("address"));
				gym.setNumItem(rs.getInt("numItem"));
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

	public void addGymDetails(Gymnasium gymDetails) {
		try {

			// Step 4 make/open a connection

			System.out.println("Connecting to database...");
			conn = DBUtils.getConnection();

			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			
			// String sql = "UPDATE Employees set age=? WHERE id=?";
			// String sql1="delete from employee where id=?";
			// stmt.setInt(1, 101);
			stmt = conn.prepareStatement(SQLConstants.SQL_INSERT_GYM_DETAILS_QUERY);

			// Hard coded d
			// Bind values into the parameters.
//			      stmt.setInt(1, gymDetails.getGymId());  // This would set age
			stmt.setString(1, gymDetails.getGymOwnerEmail());
			stmt.setString(2, gymDetails.getName());
			stmt.setString(3, gymDetails.getAddress());
			stmt.setDouble(4, gymDetails.getTotalArea());
			stmt.setInt(5, gymDetails.getNumItem());
			stmt.setInt(6,gymDetails.getNumSeatsPerSlot());
			stmt.setInt(7, 0);
			stmt.executeUpdate();

			// STEP 6: Clean-up environment
			// rs.close();
			stmt.close();
//			conn.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		// end finally try
		} // end try
		System.out.println("Added Gymnaisum");
		return;
	}



}
