package com.Caps.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class MyFirstJDBC {

	public static void main(String[] args) {
		Connection conn=null;
		java.sql.Statement stmt=null;
		ResultSet rs=null;
		
		
		try {
			//Load the driver
			Driver driver=new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(driver);
			System.out.println("Driver loaded......");
			
			//Get the db connection via driver
			String dburl="jdbc:mysql://localhost:3306/ty_cg_nov6"+ "?user=root&password=root";
			
		    conn=DriverManager.getConnection(dburl);
		    System.out.println("Connaction established...");
		    
		    
		  //Issue sql queries into the connection
		    String query="SELECT * FROM users_info";
		    stmt=conn.createStatement();
		    stmt.executeQuery(query);
		    rs=stmt.executeQuery(query);
		    System.out.println("Query issued....");
		    
		  //Process the results returned by sql queries
		    System.out.println("*******************************************");
		    while(rs.next()){
		    	System.out.println("User Id : "+rs.getInt("userid"));
		    	System.out.println("User Name: "+rs.getString("user_name"));
		    	System.out.println("E-mail : "+rs.getString("email"));
		    	System.out.println("Password : "+rs.getString("password"));
		    	System.out.println("******************************************");
		    }
		    			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		//close all the JDBC objects
		
		finally{
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(stmt != null){
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
			
		if(	rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
			
		}
		
		
		 
		
		
		
		
		
		
		
		 
		
		
		
		// TODO Auto-generated method stub

	}

}
