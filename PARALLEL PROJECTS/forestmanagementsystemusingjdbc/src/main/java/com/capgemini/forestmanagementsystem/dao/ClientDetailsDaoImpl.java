package com.capgemini.forestmanagementsystem.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

import com.capgemini.forestmanagementsystem.controller.AdminPage;
import com.capgemini.forestmanagementsystem.dto.ClientDetailsDto;
import com.capgemini.forestmanagementsystem.factory.FactoryClass;

public class ClientDetailsDaoImpl implements ClientDetailsDao {
	ClientDetailsDto cld=FactoryClass.getClientDetailsDto();
   Scanner sc=new Scanner(System.in);


	@Override
	public boolean addClient(ClientDetailsDto cld) {
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
				PreparedStatement insert=conn.prepareStatement(prop.getProperty("insertclientdetails"))
				){	
			insert.setInt(1, cld.getClientId());
			insert.setString(2, cld.getClientName());
			insert.setString(3, cld.getPassword());
			int result=insert.executeUpdate();
			if(result>0) {
				System.out.println("\nCLIENT ADDED SUCCESSFULLY !!\n");
				return true;

			}
			else {
				System.err.println("\nYOUR INPUT TO SOME FIELDS DID`NT MATCHED THE PARAMIETERS,  PLEASE INSERT DATA  AGAIN PROPERLY !!\n");
//				AdminPage.clientOperations();
			} 

		}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
      return false;
		
	}
	//add client end..


	@Override
	public boolean deleteClient(ClientDetailsDto cld) {
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
				PreparedStatement delete=conn.prepareStatement(prop.getProperty("deleteclientdetails"))
				){	
			delete.setInt(1, cld.getClientId());
			delete.setString(2, cld.getPassword());
			int result=delete.executeUpdate();
			if(result>0) {
				System.out.println("\nCLIENT DELETED SUCCESSFULLY !!\n");
				return true;
			}
			else {
				System.err.println("\nINCORRECT CLIENT ID AND PASSWORD,   PLEASE INSERT DATA  AGAIN PROPERLY !!\n");
//				AdminPage.clientOperations();
			} 

		}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
           return false;
	}
	//delete client details end....



	@Override
	public boolean modifyClient(ClientDetailsDto cld,String pass) {
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
				PreparedStatement modify=conn.prepareStatement(prop.getProperty("modifypassword"))
						
				){	
			modify.setInt(2, cld.getClientId());
			modify.setString(3, pass);
			modify.setString(1, cld.getPassword());
			int result=modify.executeUpdate();
			if(result>0) {
				System.out.println("\nPASSWORD MODIFIED SUCCESSFULLY !!\n");
				return true;

			}
			else {
				System.err.println("\nINCORRECT CLIENT ID AND PASSWORD,   PLEASE INSERT DATA  AGAIN PROPERLY !!\n");
//				AdminPage.clientOperations();
			} 
			
			
		}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return false;
	}
	//modify client end


	@Override
	public boolean viewAllClient() {
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
				java.sql.Statement stmt= conn.createStatement();

				){	
			ResultSet rs=stmt.executeQuery(prop.getProperty("viewallclientdetails"));
			System.out.println("\n<^^^^^^^^^^^CLIENT DETAILS^^^^^^^^^^^^^^^>");
			while(rs.next()) {
				System.out.println("CLIENT ID : "+rs.getInt(1));
				System.out.println("CLIENT NAME : "+rs.getString(2));
				System.out.println("PASSWORD : "+rs.getString(3));
				System.out.println("------------------------------------------------------------------------------");
			}
			System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
			if(rs.first()) {
				return true;
			}
			else {
				System.err.println("There are no Clients present in the database !!\n");
			}

		}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
     return false;
	}



}
