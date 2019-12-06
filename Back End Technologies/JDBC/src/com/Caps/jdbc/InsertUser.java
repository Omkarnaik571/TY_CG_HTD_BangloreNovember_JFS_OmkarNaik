package com.Caps.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class InsertUser {

	public static void main(String[] args) {
		Connection conn=null;
		ResultSet rs=null;
		PreparedStatement pstmt=null;
		Scanner sc=new Scanner(System.in);
		try {
			//1.
			Driver driver = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(driver);
			//				Class.forName("com.mysql.jdbc.Driver()");
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
			String query="insert into users_info values(?,?,?,?) ";
			pstmt=conn.prepareStatement(query);
			System.out.println("enter the user id: ");
			pstmt.setInt(1,Integer.parseInt(sc.nextLine()));
			System.out.println("enter the User Name: ");
			pstmt.setString(2, sc.nextLine());
			System.out.println("enter the E-Mail: ");
			pstmt.setString(3, sc.nextLine());
			System.out.println("enter the Password: ");
			pstmt.setString(4, sc.nextLine());
			int i1=pstmt.executeUpdate();

			if(i1>0) {
				System.out.println("Record is inserted....");
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
