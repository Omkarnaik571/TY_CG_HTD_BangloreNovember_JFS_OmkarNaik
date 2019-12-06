package com.Caps.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class User_Email_Update {
  public static void main(String[] args) {
	Connection conn=null;
	PreparedStatement stmt=null;
	Scanner sc=new Scanner(System.in);
	
	try  {
		//1.
		try {
		Class.forName("com.mysql.jdbc.Driver");
		}
		 catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		System.out.println("Driver is loaded...");
		//2.
	      String dbaddres="jdbc:mysql://localhost:3306/ty_cg_nov6";
		    System.out.println("enter the User Name and Password for the Database: ");
		     String usn=sc.nextLine();
		     String pas=sc.nextLine();
				conn= DriverManager.getConnection(dbaddres,usn,pas);
				System.out.println("Connection is made......");
			 //3.
				
				String query="update users_info set email=? where userid=?";
				stmt=conn.prepareStatement(query);
				
				System.out.println("Enter the  User Id:");
				stmt.setInt(2, Integer.parseInt(sc.nextLine()));
				System.out.println("Enter the new e-mail Id :");
				stmt.setString(1, sc.nextLine());
				
				//4.
				
				int i1=stmt.executeUpdate();
				if(i1>0) {
					System.out.println("E-mail changed....");
				}
				else {
					System.out.println("Something went wrong...");
				}	
				
				
				
				
	}
	catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  
	/*
	finally {
		if(stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		sc.close();
		
	}
	  
	  */
	  
}
	
	
	
	
	
}
