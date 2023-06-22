package com.flipkart.dao;
import com.flipkart.bean.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserGMSDaoImpl implements UserGMSDao{
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/Test";
	static final String USER = "root";
	static final String PASS = "Ayush@37";
	 
	
	public void fxn()
	{
		
	}
	public boolean isAuthenticated(User userData) {
		
		
		
		
		return true;
	}
	
	public void registerCustomer(Registration customerData) {
		// todo
		
		return;
	}
	
	public void registerGymOwner(Registration ownerData) {
		// todo
		
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
			      String sql="insert into User values(?,?)";
			      //String sql = "UPDATE Employees set age=? WHERE id=?";
			     // String sql1="delete from employee where id=?";
			     // stmt.setInt(1, 101);
			      stmt = conn.prepareStatement(sql);
			   
			      // Hard coded d
			      //Bind values into the parameters.
			      stmt.setString(1, userData.getUserName());  // This would set age
			      stmt.setString(2,userData.getPassword());
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
			   System.out.println("Goodbye!");
		return;
	}
	
}
