package com.flipkart.dao;
import com.flipkart.bean.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserGMSDaoImpl implements UserGMSDao{
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/GMS_db";
	static final String USER = "root";
	static final String PASS = "Ayush@37";
	
	
	public boolean isAuthenticated(User userData) {
		
		boolean authenticated = false;
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			  
			Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            String sql = "SELECT * FROM User WHERE email = ? AND password = ?";


            stmt = conn.prepareStatement(sql);
            stmt.setString(1, userData.getUserName());
            stmt.setString(2, userData.getPassword());
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next() == true)
            {
            	System.out.println("I am in");
            	authenticated =true;
            }
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
			   System.out.println("Authentication checked");
		return authenticated;
	}
	
	public void registerCustomer(Registration customerData) {
		// todo
		
		return;
	}
	
	public void registerGymOwner(Registration ownerData) {
		// todo
		
		
//		 try{
//			  
//			   Class.forName("com.mysql.jdbc.Driver");
//
//			   // Step 4 make/open  a connection 
//			   
//			      System.out.println("Connecting to database...");
//			      conn = DriverManager.getConnection(DB_URL,USER,PASS);
//			   
//			      //STEP 4: Execute a query
//			      System.out.println("Creating statement...");
//			      String sql="insert into GymOwner values(?,?, ?, ?,?, ?, ?,?, ?)";
//			      //String sql = "UPDATE Employees set age=? WHERE id=?";
//			     // String sql1="delete from employee where id=?";
//			     // stmt.setInt(1, 101);
//			      stmt = conn.prepareStatement(sql);
//			   
//			      // Hard coded d
//			      //Bind values into the parameters.
//			      stmt.setString(1, ownerData.getUserName());  // This would set age
//			      stmt.setString(2, ownerData.getName()); 
//			      stmt.setString(3, ownerData.getMobile()); 
//			      stmt.setString(4, ownerData.getDob()); 
//			      stmt.setString(5, ownerData.getAadhaarNumber()); 
//			      stmt.setString(6, ownerData.getPanNumber()); 
//			      stmt.setString(7, ownerData.getGstNumber()); 
//			      stmt.setString(8, ownerData.getAddress()); 
//			      stmt.setInt(9, 0);
//			      stmt.executeUpdate();
//			          
//			      //STEP 6: Clean-up environment
//			     // rs.close();
//			      stmt.close();
//			      conn.close();
//			   }catch(SQLException se){
//			      //Handle errors for JDBC
//			      se.printStackTrace();
//			   }catch(Exception e){
//			      //Handle errors for Class.forName
//			      e.printStackTrace();
//			   }finally{
//			      //finally block used to close resources
//			      try{
//			         if(stmt!=null)
//			            stmt.close();
//			      }catch(SQLException se2){
//			      }// nothing we can do
//			      try{
//			         if(conn!=null)
//			            conn.close();
//			      }catch(SQLException se){
//			         se.printStackTrace();
//			      }//end finally try
//			   }//end try
//			   System.out.println("Added Gym Owner details");
		return;
	}
	
	public void registerUser(User userData) {
		// todo
		Connection conn = null;
		PreparedStatement stmt = null;
		 try{
			  
			   Class.forName("com.mysql.jdbc.Driver");

			   // Step 4 make/open  a connection 
			   
			      System.out.println("Connecting to database...");
			      conn = DriverManager.getConnection(DB_URL,USER,PASS);
			   
			      //STEP 4: Execute a query
			      System.out.println("Creating statement...");
			      String sql="insert into User values(?,?,?)";
			      //String sql = "UPDATE Employees set age=? WHERE id=?";
			     // String sql1="delete from employee where id=?";
			     // stmt.setInt(1, 101);
			      stmt = conn.prepareStatement(sql);
			   
			      // Hard coded d
			      //Bind values into the parameters.
			      stmt.setString(1, userData.getUserName());  // This would set age
			      stmt.setString(2,userData.getPassword());
			      stmt.setInt(3, 3);
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
			   System.out.println("Added User Details");
		return;
	}
	
}
