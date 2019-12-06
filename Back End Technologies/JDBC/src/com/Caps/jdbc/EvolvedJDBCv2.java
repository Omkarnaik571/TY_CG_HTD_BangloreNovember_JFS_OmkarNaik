package com.Caps.jdbc;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Properties;

import com.mysql.jdbc.Statement;

public class EvolvedJDBCv2 {
   public static void main(String[] args) {
	FileReader reader=null;
	Properties prop=null;
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Diver is loaded.....");
		reader=new FileReader("db2.properties");
		prop=new Properties();
		prop.load(reader);
          System.out.println("User Id and Password matched !!!!!!");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  String address="jdbc:mysql://localhost:3306/ty_cg_nov6";
	   String query="Select * from users_info";
	try(Connection conn=DriverManager.getConnection(address, prop);
		java.sql.Statement stmt=conn.createStatement();	
			ResultSet rs=stmt.executeQuery(query);
			){
		 System.out.println("\n<^^^^^^^^^^^PRINTING THE DETAILS^^^^^^^^^^^^^^^>");
		while(rs.next()) {
			System.out.println("User Id: "+rs.getInt(1));
			 System.out.println("User name: "+rs.getString("user_name"));
			 System.out.println("E-Mail: "+rs.getString("email"));
			 System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		}	
	}
	catch(Exception ee){
		ee.printStackTrace();
	}
	
	
	
	
	
	
	
	
	   
	   
	   
	   
}
	
	
	
	
	
	
	
}
