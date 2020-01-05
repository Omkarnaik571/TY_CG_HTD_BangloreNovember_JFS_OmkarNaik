package com.capgemini.forestmanagementsystem.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

import com.capgemini.forestmanagementsystem.controller.AdminPage;
import com.capgemini.forestmanagementsystem.dto.LandDetailsDto;
import com.capgemini.forestmanagementsystem.exceptions.CustomExceptions;
import com.capgemini.forestmanagementsystem.factory.FactoryClass;

public class LandDaoImpl implements LandDao {
	LandDetailsDto ldd=FactoryClass.getLandDetailsDto();

	@Override
	public boolean addLand(LandDetailsDto ldd) throws CustomExceptions {
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
				PreparedStatement insert=conn.prepareStatement(prop.getProperty("insertlanddetails"))
				){	
			insert.setInt(1, ldd.getPlotNumber());
			insert.setString(2, ldd.getAcquireDdate());
			insert.setString(3, ldd.getLandValue());
			insert.setString(4, ldd.getLocation());
			int result=insert.executeUpdate();
			if(result>0) {
				System.out.println("\nLAND ADDED SUCCESSFULLY !!\n");
				return true;

			}
			else {
				System.err.println("\nYOUR INPUT TO SOME FIELDS DID`NT MATCHED THE PARAMIETERS,  PLEASE INSERT DATA AGAIN PROPERLY !!\n");
			} 

		}
		catch (Exception e) {
			throw new CustomExceptions();
			// TODO: handle exception
		}
		return false;

	}
	//add land end..

	@Override
	public boolean deleteLand(LandDetailsDto ldd) {
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
				PreparedStatement delete=conn.prepareStatement(prop.getProperty("deletelanddetails"))
				){
			delete.setInt(1, ldd.getPlotNumber());
			int result=delete.executeUpdate();
			if(result>0) {
				System.out.println("\nLAND DELETED SUCCESSFULLY !!\n");
				return true;

			}
			else {
				System.err.println("\nTHE PLOT NUMBER THAT YOU HAVE ENTERED IS NOT PRESENT !!\n");
			} 


		}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		return false;
	}
	// delete land end..

	@Override
	public boolean modifyLand(LandDetailsDto ldd,int ch) {
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
				PreparedStatement modify=conn.prepareStatement(prop.getProperty("modifylanddetails"));
				PreparedStatement modifylandvalue=conn.prepareStatement(prop.getProperty("modifylandvalue"))	
				){
			int result=0;
			int c=ch;
			switch (c) {
			case 1:
				modify.setInt(2, ldd.getPlotNumber());
				modify.setString(1, ldd.getAcquireDdate());
				result=modify.executeUpdate();
				if(result>0) {
					System.out.println("\nLAND DETAILS MODIFIED SUCCESSFULLY !!\n");
					return true;

				}
				else {
					System.err.println("\nINCORRECT LAND ID,   PLEASE INSERT DATA AGAIN PROPERLY !!\n");
					AdminPage.landOperations();
				} 
				break;
			case 2:
				modifylandvalue.setInt(2, ldd.getPlotNumber());
				modifylandvalue.setString(1, ldd.getLandValue());
				result=modifylandvalue.executeUpdate();
				if(result>0) {
					System.out.println("\nLAND DETAILS MODIFIED SUCCESSFULLY !!\n");
					return true;
				}
				else {
					System.err.println("\nINCORRECT LAND ID,   PLEASE INSERT DATA AGAIN PROPERLY !!\n");
					AdminPage.landOperations();
				} 
				break;

			default:
				System.err.println("\nPLEASE SELECT A VALID OPTION........\n");
				AdminPage.landOperations();
				break;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return false;

	}
	// modify land end

	@Override
	public boolean viewAllLand() {
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
			ResultSet rs=stmt.executeQuery(prop.getProperty("viewalllanddetails"));
			System.out.println("\n<^^^^^^^^^^^LAND DETAILS^^^^^^^^^^^^^^^>");
			while(rs.next()) {
				System.out.println("PLOT NUMBER : "+rs.getInt(1));
				System.out.println("ACQUIRED DATE : "+rs.getString(2));
				System.out.println("LAND VALUE : "+rs.getString(3));
				System.out.println("LOCATION : "+rs.getString(4));
				System.out.println("------------------------------------------------------------------------------");
			}
			System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
			if(rs.first()) {
				return true;
			}
			else {
				System.err.println("There are no Land records present in the database !!\n");
			}

		}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return false;
	}
	// view all land end..

}
