package com.capgemini.forestmanagementsystem.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

import com.capgemini.forestmanagementsystem.dto.ClientDetailsDto;
import com.capgemini.forestmanagementsystem.dto.SchedulerDetailsDto;
import com.capgemini.forestmanagementsystem.exceptions.CustomExceptions;
import com.capgemini.forestmanagementsystem.factory.FactoryClass;

public class SchedulerDetailsDaoImpl  implements SchedulerDetailsDao{

	SchedulerDetailsDto cld=FactoryClass.getSchedulerDetailsDto();
	   Scanner sc=new Scanner(System.in);
	
	
	@Override
	public boolean addScheduler(SchedulerDetailsDto cld) throws CustomExceptions {
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
				PreparedStatement insert=conn.prepareStatement(prop.getProperty("insertschedulerdetails"))
				){	
			insert.setInt(1, cld.getSchedulerid());
			insert.setString(2, cld.getSchedulername());
			insert.setString(3, cld.getPassword());
			int result=insert.executeUpdate();
			if(result>0) {
				System.out.println("\nSCHEDULER ADDED SUCCESSFULLY !!\n");
				return true;

			}
			else {
				System.err.println("\nYOUR INPUT TO SOME FIELDS DID`NT MATCHED THE PARAMIETERS,  PLEASE INSERT DATA  AGAIN PROPERLY !!\n");
//				AdminPage.clientOperations();
			} 

		}
		catch (Exception e) {
			throw new CustomExceptions();
			// TODO: handle exception
		}
      return false;
		
	}//end of add method

	@Override
	public boolean deleteScheduler(SchedulerDetailsDto cld) {
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
				PreparedStatement delete=conn.prepareStatement(prop.getProperty("deleteschedulerdetails"))
				){	
			delete.setInt(1, cld.getSchedulerid());
			delete.setString(2, cld.getPassword());
			int result=delete.executeUpdate();
			if(result>0) {
				System.out.println("\nSCHEDULER DELETED SUCCESSFULLY !!\n");
				return true;
			}
			else {
				System.err.println("\nINCORRECT SCHEDULER ID AND PASSWORD,   PLEASE INSERT DATA  AGAIN PROPERLY !!\n");
//				AdminPage.clientOperations();
			} 

		}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		
		
		
		return false;
	}

	@Override
	public boolean modifyScheduler(SchedulerDetailsDto cld, String pass) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean viewAllScheduler() {
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
			ResultSet rs=stmt.executeQuery(prop.getProperty("viewallschedulerdetails"));
			System.out.println("\n<^^^^^^^^^^^SCHEDULER DETAILS^^^^^^^^^^^^^^^>");
			while(rs.next()) {
				System.out.println("SCHEDULER ID : "+rs.getInt(1));
				System.out.println("SCHEDULER NAME : "+rs.getString(2));
				System.out.println("PASSWORD : "+rs.getString(3));
				System.out.println("------------------------------------------------------------------------------");
			}
			System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
			if(rs.first()) {
				return true;
			}
			else {
				System.err.println("There are no Scheduler present in the database !!\n");
			}

		}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		
		
		return false;
	}

	
	
	
	
	
	
	
}
