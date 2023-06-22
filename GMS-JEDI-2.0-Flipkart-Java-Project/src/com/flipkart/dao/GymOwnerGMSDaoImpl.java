package com.flipkart.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Gymnasium;

public class GymOwnerGMSDaoImpl implements GymOwnerGMSDao {
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/GMS_db";
	static final String USER = "root";
	static final String PASS = "Ayush@37";
	Connection conn = null;
	PreparedStatement stmt = null;
	
	
	public GymOwner fetchOwnerDetails(String gymOwnerId) {
		GymOwner gymOwnerDetails = null;
//		for(GymOwner gymOwner: gymOwners) {
//			if(gymOwner.getOwnerUserName().equals(gymOwnerUserName)) {
//				gymOwnerDetails = gymOwner;
//			}
//		}
		return gymOwnerDetails;
		
		//todo
		 
	}
	
//	public void addGymOwnerDetails(GymOwner gymOwnerDetails) {
//		// todo
//	}
	
	public List<Gymnasium> fetchGymDetails(String gymOwnerId) {
		// todo
		 return new ArrayList<Gymnasium>();  
		 
	}
	
	public void addGymDetails(Gymnasium gymDetails) {
		try{
			  
			   Class.forName("com.mysql.jdbc.Driver");

			   // Step 4 make/open  a connection 
			   
			      System.out.println("Connecting to database...");
			      conn = DriverManager.getConnection(DB_URL,USER,PASS);
			   
			      //STEP 4: Execute a query
			      System.out.println("Creating statement...");
			      String sql="insert into Gymnasium values(?,?, ?, ?,?, ?, ?,?, ?)";
			      //String sql = "UPDATE Employees set age=? WHERE id=?";
			     // String sql1="delete from employee where id=?";
			     // stmt.setInt(1, 101);
			      stmt = conn.prepareStatement(sql);
			   
			      // Hard coded d
			      //Bind values into the parameters.
			      stmt.setString(1, gymDetails.getGymId());  // This would set age
			      stmt.setString(2, gymDetails.getOwnerUserName());  
			      stmt.setString(3, gymDetails.getName());  
			      stmt.setString(4, gymDetails.getAddress());  
			      stmt.setDouble(5, gymDetails.getTotalArea());
			      stmt.setInt(5, gymDetails.getNumItem());   
			      stmt.executeUpdate();
			          
			      //STEP 6: Clean-up environment
			     // rs.close();
			      stmt.close();
			      conn.close();
			   }catch(SQLException se){
			      //Handle errors for JDBC
			      se.printStackTrace();
			   }catch(Exception e){
			      //Handle errors for Class.forName
			      e.printStackTrace();
			   }finally{
			      //finally block used to close resources
			      try{
			         if(stmt!=null)
			            stmt.close();
			      }catch(SQLException se2){
			      }// nothing we can do
			      try{
			         if(conn!=null)
			            conn.close();
			      }catch(SQLException se){
			         se.printStackTrace();
			      }//end finally try
			   }//end try
			   System.out.println("Added Gymnaisum");
		return;
	}

}
