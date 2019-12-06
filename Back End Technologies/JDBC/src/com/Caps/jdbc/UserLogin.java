package com.Caps.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UserLogin {
	public static void main(String[] args) {
		ResultSet rs=null;
		Connection conn=null;
		PreparedStatement stmt=null;
		Scanner sc=new Scanner(System.in);

		try {
			//1. Load the driver and register with the driver manager
			java.sql.Driver driver=new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(driver);
			System.out.println("Driver is loaded...");

			//2.  Establish connection with the data base
			String dbaddress="jdbc:mysql://127.0.0.1:3306/ty_cg_nov6";
			System.out.println("Enter User Name for the Database : ");
			String dbuser=sc.nextLine();
			System.out.println("Enter Password for the Database : ");
			String dbpass=sc.nextLine();
			conn=DriverManager.getConnection(dbaddress,dbuser,dbpass);
			System.out.println("Connection is made...");
			System.out.println();


			//3.  Issue sql queries using that connection

			String query="select * from users_info where userid = ? and password = ?";
			stmt=conn.prepareStatement(query);
			System.out.println("Enter the User_Id of the person : ");
			stmt.setInt(1, Integer.parseInt(sc.nextLine()));
			System.out.println("Enter the Password of the person : ");
			stmt.setString(2, sc.nextLine());
			//4.  Process the result set given by the data base
			rs=stmt.executeQuery();
			if(rs.next()) {
				System.out.println("User Id: "+rs.getInt("userid"));
				System.out.println("User Name: "+rs.getString("user_name"));
				System.out.println("E-Mail: "+rs.getString("email"));
				System.out.println("Password : "+rs.getString("password"));
			}
			else {
				System.out.println("Something went wrong....");
			}



		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}





		}




		//5. Close all the jdbc objects



	}




}
