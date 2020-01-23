package com.capgemini.forestmanagementsystem.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import com.capgemini.forestmanagementsystem.controller.AdminPage;
import com.capgemini.forestmanagementsystem.dto.ContractorDetailsDto;
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
			insert.setInt(1, cdd.getCustomerId());
			insert.setString(2, cdd.getCustomerName());
			insert.setString(3, cdd.getStreetAddress1());
			insert.setString(4, cdd.getStreetAddress2());
			insert.setString(5, cdd.getTown());
			insert.setInt(6, cdd.getPostalCode());
			insert.setString(7, cdd.getEmail());
			insert.setLong(8, cdd.getTelephoneno());
			int result=insert.executeUpdate();
			if(result>0) {
				return true;
			} 
		}
		catch (Exception e) {
			throw new CustomExceptions("The customer id that you have entered already exists !!");
		}
		return false;
	}
	//add customer end..

	@Override
	public List<CustomerDetailsDto> viewCustomerDetails() throws CustomExceptions {
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

		List<CustomerDetailsDto> l1=new ArrayList<CustomerDetailsDto>();
		try(Connection conn=DriverManager.getConnection(prop.getProperty("dburl"),
				prop.getProperty("dbname"),prop.getProperty("dbpass"));
				//				Scanner sc=new Scanner(System.in);
				java.sql.Statement stmt= conn.createStatement();

				){	
			ResultSet rs=stmt.executeQuery(prop.getProperty("viewallcustomer"));
			 while(rs.next()) {
			    	CustomerDetailsDto cdt=new CustomerDetailsDto();
			    	cdt.setCustomerId(rs.getInt(1));
			    	cdt.setCustomerName(rs.getString(2));
			    	cdt.setStreetAddress1(rs.getString(3));
			    	cdt.setStreetAddress2(rs.getString(4));
			    	cdt.setTown(rs.getString(5));
			    	cdt.setPostalCode(rs.getInt(6));
			    	cdt.setEmail(rs.getString(7));
			    	cdt.setTelephoneno(rs.getLong(8));
			    	l1.add(cdt);
			    }
		}
		catch (Exception e) {
			throw new CustomExceptions("There are no customers in the database !!");
		}
		return l1;
	}
	//view customer details end..
	
	
	
	@Override
	public CustomerDetailsDto viewSingleCustomerDetails(CustomerDetailsDto cdd) throws CustomExceptions {
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
			pstmt.setInt(1, cdd.getCustomerId());
			ResultSet rs=pstmt.executeQuery();
			 while(rs.next()) {
			    	CustomerDetailsDto cdt=new CustomerDetailsDto();
			    	cdt.setCustomerId(rs.getInt(1));
			    	cdt.setCustomerName(rs.getString(2));
			    	cdt.setStreetAddress1(rs.getString(3));
			    	cdt.setStreetAddress2(rs.getString(4));
			    	cdt.setTown(rs.getString(5));
			    	cdt.setPostalCode(rs.getInt(6));
			    	cdt.setEmail(rs.getString(7));
			    	cdt.setTelephoneno(rs.getLong(8));
			    return cdt;   
			 }
			
			
		}
		catch (Exception e) {
			throw new CustomExceptions("The customer id that you have entered already exists !!");
		}

		return null;

	}
	//view single customer deatails end..


	@Override
	public boolean deleteCustomerDetails(CustomerDetailsDto cdd) throws CustomExceptions {
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
			delete.setInt(1, cdd.getCustomerId());
			int result=delete.executeUpdate();
			if(result>0) {
				return true;

			} 
		}
		catch (Exception e) {
			throw new CustomExceptions("The customer id that you have entered already exists !!");
		}
		return false;
	}
	//delete customer details end..
	@Override
	public boolean modifyCustomerDetails(CustomerDetailsDto cdd,int choice) throws CustomExceptions {
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
				modify.setInt(2, cdd.getCustomerId());
				modify.setString(1, cdd.getStreetAddress1());
				int result=modify.executeUpdate();
				if(result>0) {
					return true;

				} 

			}
			catch (Exception e) {
				throw new CustomExceptions("The customer id that you have entered already exists !!");
			}

			break;
		case 2:
			try(Connection conn=DriverManager.getConnection(prop.getProperty("dburl"),
					prop.getProperty("dbname"),prop.getProperty("dbpass"));
					PreparedStatement modify=conn.prepareStatement(prop.getProperty("modifystreetaddress2"))
					){	
				modify.setInt(2, cdd.getCustomerId());
				modify.setString(1, cdd.getStreetAddress2());
				int result=modify.executeUpdate();
				if(result>0) {
					return true;
				} 
			}
			catch (Exception e) {
				throw new CustomExceptions("The customer id that you have entered already exists !!");
			}

			break;
		case 3:
			try(Connection conn=DriverManager.getConnection(prop.getProperty("dburl"),
					prop.getProperty("dbname"),prop.getProperty("dbpass"));
					PreparedStatement modify=conn.prepareStatement(prop.getProperty("modifytown"))
					){	
				modify.setInt(2, cdd.getCustomerId());
				modify.setString(1, cdd.getTown());
				int result=modify.executeUpdate();
				if(result>0) {
					return true;

				} 
			}
			catch (Exception e) {
				throw new CustomExceptions("The customer id that you have entered already exists !!");
			}

			break;
		case 4:

			try(Connection conn=DriverManager.getConnection(prop.getProperty("dburl"),
					prop.getProperty("dbname"),prop.getProperty("dbpass"));
					PreparedStatement modify=conn.prepareStatement(prop.getProperty("modifypostalcode"))
					){	
				modify.setInt(2, cdd.getCustomerId());
				modify.setInt(1, cdd.getPostalCode());
				int result=modify.executeUpdate();
				if(result>0) {
					return true;
				} 
			}
			catch (Exception e) {
				throw new CustomExceptions("The customer id that you have entered already exists !!");
			}
			break;
		case 5:

			try(Connection conn=DriverManager.getConnection(prop.getProperty("dburl"),
					prop.getProperty("dbname"),prop.getProperty("dbpass"));
					PreparedStatement modify=conn.prepareStatement(prop.getProperty("modifyemail"))
					){	
				modify.setInt(2, cdd.getCustomerId());
				modify.setString(1, cdd.getEmail());
				int result=modify.executeUpdate();
				if(result>0) {
					return true;
				} 

			}
			catch (Exception e) {
				throw new CustomExceptions("The customer id that you have entered already exists !!");
			}

			break;
		case 6:

			try(Connection conn=DriverManager.getConnection(prop.getProperty("dburl"),
					prop.getProperty("dbname"),prop.getProperty("dbpass"));
					PreparedStatement modify=conn.prepareStatement(prop.getProperty("modifytelephoneno"))
					){	
				modify.setInt(2, cdd.getCustomerId());
				modify.setLong(1, cdd.getTelephoneno());
				int result=modify.executeUpdate();
				if(result>0) {
					return true;
				} 
			}
			catch (Exception e) {
				throw new CustomExceptions("The customer id that you have entered already exists !!");
			}

			break;
		default:
			break;
		}
		return false;
	}
	//modify customer details end..

}
