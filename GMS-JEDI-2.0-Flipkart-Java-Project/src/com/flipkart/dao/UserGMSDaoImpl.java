package com.flipkart.dao;
import com.flipkart.bean.*;
import com.flipkart.constants.SQLConstants;
import com.flipkart.exception.UserNotFoundException;
import com.flipkart.utils.DBUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserGMSDaoImpl implements UserGMSDao{
	
//	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
//	static final String DB_URL = "jdbc:mysql://localhost/GMS_db";
//	static final String USER = "root";
//	static final String PASS = "Naman@fk";
	Connection conn = null;
	PreparedStatement stmt = null;
	
	public User isAuthenticated(User userData) throws UserNotFoundException {
		
		
		try{
			  
//			Class.forName("com.mysql.jdbc.Driver");
//            conn = DriverManager.getConnection(DB_URL,USER,PASS);
			conn = DBUtils.getConnection();


            stmt = conn.prepareStatement(SQLConstants.SQL_AUTH_QUERY);
            stmt.setString(1, userData.getEmail());
            stmt.setString(2, userData.getPassword());
            ResultSet rs = stmt.executeQuery();
            if(rs.next() == true)
            {
            	int roleId = rs.getInt("roleId");
            	userData.setRoleId(roleId);
            }
            else {
            	throw new UserNotFoundException();
            }
		      stmt.close();
//			      conn.close();
		    }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		    }
		//end try
//		System.out.println("Authentication checked");
		return userData.getRoleId()==0? null:userData;
	}
	
	public void registerCustomer(Customer customerData) {
		// todo
		try{
            
            

            // Step 4 make/open  a connection 
            
//               System.out.println("Connecting to database...");
               conn = DBUtils.getConnection();
            
               //STEP 4: Execute a query
//               System.out.println("Creating statement...");
               //String sql = "UPDATE Employees set age=? WHERE id=?";
              // String sql1="delete from employee where id=?";
              // stmt.setInt(1, 101);
               stmt = conn.prepareStatement(SQLConstants.SQL_INSERT_CUSTOMER_DETAILS_QUERY);
            
               // Hard coded d
               //Bind values into the parameters.
               stmt.setString(1, customerData.getEmail());  // This would set age
               stmt.setString(2, customerData.getName()); 
               stmt.setString(3, customerData.getAddress()); 
               stmt.setString(4, customerData.getMobile()); 
               stmt.setString(5, customerData.getDob()); 
               stmt.executeUpdate();
                   
               //STEP 6: Clean-up environment
              // rs.close();
               stmt.close();
//               conn.close();
            }catch(SQLException se){
               //Handle errors for JDBC
               se.printStackTrace();
            }catch(Exception e){
               //Handle errors for Class.forName
               e.printStackTrace();
            }
            System.out.println("Added Customer details");
		return;
	}
	
	public void registerGymOwner(GymOwner ownerData) {
        // todo
         try{
              
               

               // Step 4 make/open  a connection 
               
//                  System.out.println("Connecting to database...");
                  conn = DBUtils.getConnection();
               
                  //STEP 4: Execute a query
//                  System.out.println("Creating statement...");
                  //String sql = "UPDATE Employees set age=? WHERE id=?";
                 // String sql1="delete from employee where id=?";
                 // stmt.setInt(1, 101);
                  stmt = conn.prepareStatement(SQLConstants.SQL_INSERT_GYMOWNER_DETAILS_QUERY);
               
                  // Hard coded d
                  //Bind values into the parameters.
                  stmt.setString(1, ownerData.getEmail());  // This would set age
                  stmt.setString(2, ownerData.getName()); 
                  stmt.setString(3, ownerData.getMobile()); 
                  stmt.setString(4, ownerData.getDob()); 
                  stmt.setString(5, ownerData.getAadhaarNumber()); 
                  stmt.setString(6, ownerData.getPanNumber()); 
                  stmt.setString(7, ownerData.getGstNumber()); 
                  stmt.setString(8, ownerData.getAddress()); 
                  stmt.setInt(9, 0);
                  stmt.executeUpdate();
                      
                  //STEP 6: Clean-up environment
                 // rs.close();
                  stmt.close();
//                  conn.close();
               }catch(SQLException se){
                  //Handle errors for JDBC
                  se.printStackTrace();
               }catch(Exception e){
                  //Handle errors for Class.forName
                  e.printStackTrace();
               }
               System.out.println("Added Gym Owner details");
        return;
    }
	
	public void registerUser(User userData) {
		 try{
			  
			   // Step 4 make/open  a connection 
			   
//			      System.out.println("Connecting to database...");
			      conn = DBUtils.getConnection();
			   
			      //STEP 4: Execute a query
//			      System.out.println("Creating statement...");
			      //String sql = "UPDATE Employees set age=? WHERE id=?";
			     // String sql1="delete from employee where id=?";
			     // stmt.setInt(1, 101);
			      stmt = conn.prepareStatement(SQLConstants.SQL_INSERT_USER_DETAILS_QUERY);
			   
			      // Hard coded d
			      //Bind values into the parameters.
			      stmt.setString(1, userData.getEmail());  // This would set age
			      stmt.setString(2,userData.getPassword());
			      stmt.setInt(3, userData.getRoleId());
			      stmt.executeUpdate();
			          
			      //STEP 6: Clean-up environment
			     // rs.close();
			   }catch(SQLException se){
			      //Handle errors for JDBC
			      se.printStackTrace();
			   }catch(Exception e){
			      //Handle errors for Class.forName
			      e.printStackTrace();
			   }//end try
//			   System.out.println("Added User Details");
		return;
	}
	
}
