package com.capgemini.forestmanagementsystem.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

import com.capgemini.forestmanagementsystem.controller.AdminPage;
import com.capgemini.forestmanagementsystem.dto.CustomerDetailsDto;
import com.capgemini.forestmanagementsystem.exceptions.CustomExceptions;
import com.capgemini.forestmanagementsystem.factory.FactoryClass;

public class CustomerDetailsDaoImpl implements CustomerDetailsDao {
	CustomerDetailsDto cdd=FactoryClass.getCustomerDetailsDto();
	Scanner sc=new Scanner(System.in);

	@Override
	public boolean addCustomer(CustomerDetailsDto cdd) throws CustomExceptions {
		FileReader reader=null;
		Properties prop=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver is loaded");
			reader=new FileReader("operations.properties");
			prop=new Properties();
			prop.load(reader);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

		try(Connection conn=DriverManager.getConnection(prop.getProperty("dburl"),
				prop.getProperty("dbname"),prop.getProperty("dbpass"));
				//				Scanner sc=new Scanner(System.in);
				PreparedStatement insert=conn.prepareStatement(prop.getProperty("insertcustomer"))
				){	
			insert.setInt(1, cdd.getCustomerid());
			insert.setString(2, cdd.getCustomername());
			insert.setString(3, cdd.getStreetaddress1());
			insert.setString(4, cdd.getStreetaddress2());
			insert.setString(5, cdd.getTown());
			insert.setInt(6, cdd.getPostalcode());
			insert.setString(7, cdd.getEmail());
			insert.setLong(8, cdd.getTelephoneno());
			int result=insert.executeUpdate();
			if(result>0) {
				System.out.println("\nCUSTOMER ADDED SUCCESSFULLY !!\n");
				return true;

			}
			else {
				System.out.println("\nYOUR INPUT TO SOME FIELDS DID`NT MATCHED THE PARAMIETERS,  PLEASE INSERT DATA AGAIN PROPERLY !!\n");
			} 


		}
		catch (Exception e) {
			throw new CustomExceptions();
		}
		return false;
	}
	//add customer end..

	@Override
	public boolean viewCustomerDetails() {
		FileReader reader=null;
		Properties prop=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			reader=new FileReader("operations.properties");
			prop=new Properties();
			prop.load(reader);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

		try(Connection conn=DriverManager.getConnection(prop.getProperty("dburl"),
				prop.getProperty("dbname"),prop.getProperty("dbpass"));
				//				Scanner sc=new Scanner(System.in);
				java.sql.Statement stmt= conn.createStatement();

				){	
			ResultSet rs=stmt.executeQuery(prop.getProperty("viewallcustomer"));
			System.out.println("\n<^^^^^^^^^^^CUSTOMER DETAILS^^^^^^^^^^^^^^^>");
			while(rs.next()) {
				System.out.println("CUSTOMER ID: "+rs.getInt(1));
				System.out.println("Customer NAME: "+rs.getString(2));
				System.out.println("STREET ADDRESS 1: "+rs.getString(3));
				System.out.println("STREET ADDRESS 2: "+rs.getString(4));
				System.out.println("TOWN: "+rs.getString(5));
				System.out.println("POSTAL CODE: "+rs.getInt(6));
				System.out.println("E-MAIL: "+rs.getString(7));
				System.out.println("TELEPHONE NUMBER: "+rs.getLong(8));
				System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
			}	
			if(rs.first()) {
				return true;
			}
			else {
				System.err.println("\nThere are no Customer present in the database\n");
			}

		}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return false;
	}
	//view customer details end..
	@Override
	public boolean viewSingleCustomerDetails() {
		FileReader reader=null;
		Properties prop=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			reader=new FileReader("operations.properties");
			prop=new Properties();
			prop.load(reader);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		try(Connection conn=DriverManager.getConnection(prop.getProperty("dburl"),
				prop.getProperty("dbname"),prop.getProperty("dbpass"));
				//				Scanner sc=new Scanner(System.in);
				PreparedStatement pstmt=conn.prepareStatement(prop.getProperty("viewsinglecustomer"))

				){	
			System.out.println("ENTER THE CUSTOMER ID: ");
			cdd.setCustomerid(sc.nextInt());
			pstmt.setInt(1, cdd.getCustomerid());
			ResultSet rs=pstmt.executeQuery();
			System.out.println("\n<^^^^^^^^^^^CUSTOMER DETAILS^^^^^^^^^^^^^^^>");
			while(rs.next()) {
				System.out.println("CUSTOMER ID: "+rs.getInt(1));
				System.out.println("Customer NAME: "+rs.getString(2));
				System.out.println("STREET ADDRESS 1: "+rs.getString(3));
				System.out.println("STREET ADDRESS 2: "+rs.getString(4));
				System.out.println("TOWN: "+rs.getString(5));
				System.out.println("POSTAL CODE: "+rs.getInt(6));
				System.out.println("E-MAIL: "+rs.getString(7));
				System.out.println("TELEPHONE NUMBER: "+rs.getLong(8));
				System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
			}	
			if(rs.first()) {
				return true;
			}
			else {
				System.err.println("\nThe Customer id that you have entered is not present\n");
			}

		}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		return false;

	}
	//view single customer deatails end..


	@Override
	public boolean deleteCustomerDetails(CustomerDetailsDto cdd) {
		FileReader reader=null;
		Properties prop=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			reader=new FileReader("operations.properties");
			prop=new Properties();
			prop.load(reader);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

		try(Connection conn=DriverManager.getConnection(prop.getProperty("dburl"),
				prop.getProperty("dbname"),prop.getProperty("dbpass"));
				//				Scanner sc=new Scanner(System.in);
				PreparedStatement delete=conn.prepareStatement(prop.getProperty("deletecustomer"))
				){	
			delete.setInt(1, cdd.getCustomerid());
			int result=delete.executeUpdate();
			if(result>0) {
				System.out.println("\nCUSTOMER DELETED SUCCESSFULLY !!\n");
				return true;

			}
			else {
				System.err.println("\nTHE CUSTOMER ID THAT YOU HAVE ENTERED IS NOT PRESENT !!\n");
			} 

		}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return false;
	}
	//delete customer details end..
	@Override
	public boolean modifyCustomerDetails(CustomerDetailsDto cdd,int choice) {
		FileReader reader=null;
		Properties prop=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			reader=new FileReader("operations.properties");
			prop=new Properties();
			prop.load(reader);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		switch (choice) {
		case 1:

			try(Connection conn=DriverManager.getConnection(prop.getProperty("dburl"),
					prop.getProperty("dbname"),prop.getProperty("dbpass"));
					PreparedStatement modify=conn.prepareStatement(prop.getProperty("modifystreetaddress1"))
					){	
				modify.setInt(2, cdd.getCustomerid());
				modify.setString(1, cdd.getStreetaddress1());
				int result=modify.executeUpdate();
				if(result>0) {
					System.out.println("\nSTREET ADDRESS 1 MODIFIED SUCCESSFULLY !!\n");
					return true;

				}
				else {
					System.err.println("\nThe customer id that you have entered is not present !!\n");
				} 

			}
			catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}

			break;
		case 2:


			try(Connection conn=DriverManager.getConnection(prop.getProperty("dburl"),
					prop.getProperty("dbname"),prop.getProperty("dbpass"));
					PreparedStatement modify=conn.prepareStatement(prop.getProperty("modifystreetaddress2"))
					){	
				modify.setInt(2, cdd.getCustomerid());
				modify.setString(1, cdd.getStreetaddress2());
				int result=modify.executeUpdate();
				if(result>0) {
					System.out.println("\nSTREET ADDRESS 2 MODIFIED SUCCESSFULLY !!\n");
					return true;

				}
				else {
					System.err.println("\nThe customer id that you have entered is not present !!\n");
				} 

			}
			catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}

			break;
		case 3:
			try(Connection conn=DriverManager.getConnection(prop.getProperty("dburl"),
					prop.getProperty("dbname"),prop.getProperty("dbpass"));
					PreparedStatement modify=conn.prepareStatement(prop.getProperty("modifytown"))
					){	
				modify.setInt(2, cdd.getCustomerid());
				modify.setString(1, cdd.getTown());
				int result=modify.executeUpdate();
				if(result>0) {
					System.out.println("\nTOWN MODIFIED SUCCESSFULLY !!\n");
					return true;

				}
				else {
					System.err.println("\nThe customer id that you have entered is not present !!\n");

				} 

			}
			catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}

			break;
		case 4:

			try(Connection conn=DriverManager.getConnection(prop.getProperty("dburl"),
					prop.getProperty("dbname"),prop.getProperty("dbpass"));
					PreparedStatement modify=conn.prepareStatement(prop.getProperty("modifypostalcode"))
					){	
				modify.setInt(2, cdd.getCustomerid());
				modify.setInt(1, cdd.getPostalcode());
				int result=modify.executeUpdate();
				if(result>0) {
					System.out.println("\nPOSTAL CODE MODIFIED SUCCESSFULLY !!\n");
					return true;

				}
				else {
					System.err.println("\nThe customer id that you have entered is not present !!\n");

				} 

			}
			catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}



			break;
		case 5:

			try(Connection conn=DriverManager.getConnection(prop.getProperty("dburl"),
					prop.getProperty("dbname"),prop.getProperty("dbpass"));
					PreparedStatement modify=conn.prepareStatement(prop.getProperty("modifyemail"))
					){	
				modify.setInt(2, cdd.getCustomerid());
				modify.setString(1, cdd.getEmail());
				int result=modify.executeUpdate();
				if(result>0) {
					System.out.println("\nE-MAIL CODE MODIFIED SUCCESSFULLY !!\n");
					return true;

				}
				else {
					System.err.println("\nThe customer id that you have entered is not present !!\n");
				} 

			}
			catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}

			break;
		case 6:

			try(Connection conn=DriverManager.getConnection(prop.getProperty("dburl"),
					prop.getProperty("dbname"),prop.getProperty("dbpass"));
					PreparedStatement modify=conn.prepareStatement(prop.getProperty("modifytelephoneno"))
					){	
				modify.setInt(2, cdd.getCustomerid());
				modify.setLong(1, cdd.getTelephoneno());
				int result=modify.executeUpdate();
				if(result>0) {
					System.out.println("\nTELEPHONE NUMBER CODE MODIFIED SUCCESSFULLY !!\n");
					return true;

				}
				else {
					System.err.println("\nThe customer id that you have entered is not present !!\n");
				} 

			}
			catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}

			break;
		default:
			System.out.println("\nPLEASE SELECT A VALID OPTION........\n");
			break;
		}
		return false;
	}
	//modify customer details end..

}
