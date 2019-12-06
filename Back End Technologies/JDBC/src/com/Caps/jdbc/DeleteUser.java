package com.Caps.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.Statement;

public class DeleteUser {
 public static void main(String[] args) {
	Connection conn=null;
	ResultSet rs=null;
	PreparedStatement pstmt=null;
	Scanner sc=new Scanner(System.in);
	try {
		//1.
//		Driver driver = new com.mysql.jdbc.Driver();
//		DriverManager.registerDriver(driver);
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver is loaded....");
		System.out.println();
		//2.
		String dbaddress="jdbc:mysql://localhost:3306/ty_cg_nov6";
		System.out.println("Enter the user name and password for Data Base: ");
		String usn=sc.nextLine();
		String psw=sc.nextLine();
		conn=DriverManager.getConnection(dbaddress,usn,psw);
		System.out.println("Connection is made....");
		//3.
		String query="delete from users_info where userid=? and password= ? ";
		pstmt=conn.prepareStatement(query);
		System.out.println("enter the user id which you want to delete: ");
		pstmt.setInt(1,Integer.parseInt(sc.nextLine()));
		System.out.println("enter the Password which you want to delete: ");
		pstmt.setString(2, sc.nextLine());
		int i1=pstmt.executeUpdate();
		//4.
		if(i1>0) {
			System.out.println("Record is deleted....");
		}
		else {
			System.out.println("Something went wrong....");
		}
		
		
		
		
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	 
	 
	 
	 
}
	
	
	
	
	
}
