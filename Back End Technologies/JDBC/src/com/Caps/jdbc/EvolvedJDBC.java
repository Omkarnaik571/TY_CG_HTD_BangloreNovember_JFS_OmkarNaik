package com.Caps.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

import com.mysql.jdbc.Statement;

public class EvolvedJDBC {
 public static void main(String[] args) {
	 Scanner sc=new Scanner(System.in); 
	 String dbaddress="jdbc:mysql://localhost:3306/ty_cg_nov6";
	   System.out.println("Enter the User name and password for the Dtabase:");
	   String usn=sc.nextLine();
	   String pas=sc.nextLine();
	   String query="Select * from users_info";
	 try(Connection conn= DriverManager.getConnection(dbaddress,usn,pas);
		java.sql.Statement stmt=conn.createStatement();
	     ResultSet rs=stmt.executeQuery(query);
			 ){
		 System.out.println("<-----------PRINTING THE DETAILS------------>");
		 while(rs.next()) {
			 System.out.println("User Id: "+rs.getInt(1));
			 System.out.println("User name: "+rs.getString("user_name"));
			 System.out.println("E-Mail: "+rs.getString("email"));
			 System.out.println("--------------------------------------");
		 }
		 
	}
	 catch (Exception e) {
		// TODO: handle exception
		 e.printStackTrace();
	}
	 
	 
	 
}
	
	
	
	
}
