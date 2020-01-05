package com.capgemini.forestmanagementsystem.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

import com.capgemini.forestmanagementsystem.controller.ClientPage;
import com.capgemini.forestmanagementsystem.dto.ContractorDetailsDto;
import com.capgemini.forestmanagementsystem.exceptions.ContractCustomException;
import com.capgemini.forestmanagementsystem.factory.FactoryClass;
import com.capgemini.forestmanagementsystem.validations.Validations;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;


public class ContractorDetailsDaoImpl  implements ContractorDetailsDao{

	ContractorDetailsDto cdd=FactoryClass.getContractorDetailsDto();
    Scanner sc=new Scanner(System.in);


	@Override
	public boolean addContractor(ContractorDetailsDto cdd ) throws MySQLIntegrityConstraintViolationException, ContractCustomException {
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
				PreparedStatement insert=conn.prepareStatement(prop.getProperty("insertcontractor"))
				){	
			insert.setInt(1, cdd.getContractNo());
			insert.setInt(2, cdd.getCustomerId());
			insert.setInt(3, cdd.getProductId());
			insert.setInt(4, cdd.getHaulierId());
			insert.setString(5, cdd.getDeliveryDate());
			insert.setString(6, cdd.getDeliveryDay());
			insert.setString(7, cdd.getQuantity());
			int result=0;
			
			 result=insert.executeUpdate();
			
			if(result>0) {
				System.out.println("\nCONTRACTOR ADDED SUCCESSFULLY !!\n");
				return true;

			}
			else {
				System.err.println("WRONG INPUT ENTERED IN SOME FIELDS, PLEASE ENTER AGAIN PROPERLY !!");
				
			} 

		}
		catch (Exception e) {
			throw new ContractCustomException();
		}
         return false;
	}//add contractor end

	@Override
	public boolean viewContractorDetails() {
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
				Statement stmt=conn.createStatement()
				){	
			ResultSet rs=stmt.executeQuery(prop.getProperty("viewallcontractor"));
			System.out.println("\n<^^^^^^^^^^^CONTRACT DETAILS^^^^^^^^^^^^^^^>");
			while(rs.next()) {
				System.out.println("CONTRACT NO: "+rs.getInt(1));
				System.out.println("CUSTOMER ID: "+rs.getInt(2));
				System.out.println("PRODUCT ID: "+rs.getInt(3));
				System.out.println("HAULIER ID: "+rs.getInt(4));
				System.out.println("DELIVERY DATE: "+rs.getString(5));
				System.out.println("DELIVERY DAY: "+rs.getString(6));
				System.out.println("QUANTITY : "+rs.getString(7));
				System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
			}
			 if(rs.first()) {
				 return true;	
			 }
				else {
					System.err.println("There are no Contractss present in the database !!\n");
				}
//			ClientPage.contractorOperations();
		}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return false;
	}//view all contractor end


	@Override
	public boolean viewSingleContractorDetails() {
		//For loading the driver
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
				PreparedStatement viewsingle=conn.prepareStatement(prop.getProperty("viewsinglecontractor"))
				){	
			System.out.println("ENTER THE CONTRACT NO: ");
			char x='n';
			String x1=null;
			while(x=='n') {
			    x1=sc.next();
				if(Validations.isNumber1(x1)) {
					x='x';
				}
				else {
					System.err.println("Enter the contract number in integer value !!");
				}
			}
			cdd.setContractNo(Integer.parseInt(x1));
			viewsingle.setInt(1, cdd.getContractNo());
			ResultSet rs=viewsingle.executeQuery();
			System.out.println("\n<^^^^^^^^^^^CONTRACT DETAILS^^^^^^^^^^^^^^^>");
			while(rs.next()) {
				System.out.println("CONTRACT NO: "+rs.getInt(1));
				System.out.println("CUSTOMER ID: "+rs.getInt(2));
				System.out.println("PRODUCT ID: "+rs.getInt(3));
				System.out.println("HAULIER ID: "+rs.getInt(4));
				System.out.println("DELIVERY DATE: "+rs.getString(5));
				System.out.println("DELIVERY DAY: "+rs.getString(6));
				System.out.println("QUANTITY : "+rs.getString(7));
				System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
			}	
			
			if(rs.first()) {
				return true;
			}
			else {
				System.err.println("The Contrat number that you have entered is not present in the database !!\n");
			}
//			ClientPage.contractorOperations();
		}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return false;
	}//view single contractor end

	@Override
	public boolean deleteContractorDetails(ContractorDetailsDto cdd ) {
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
				PreparedStatement delete=conn.prepareStatement(prop.getProperty("deletecontractor"))
				){	
			delete.setInt(1, cdd.getContractNo());
			int result=delete.executeUpdate();
			if(result>0) {
				System.out.println("\nCONTRACTOR DELETED SUCCESSFULLY !!\n");
				return true;

			}
			else {
				System.out.println("\nTHE CONTRACT NO THAT YOU HAVE ENTERED IS NOT PRESENT !!\n");
				deleteContractorDetails(cdd);
			} 
 
	     		
		}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		 return false;

	}//delete contractor end




	@Override
	public boolean modifyContractorDetails(ContractorDetailsDto cdd,int cno) {
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
		int choice=cno;
		switch (choice) {
		case 1:
			try(Connection conn=DriverManager.getConnection(prop.getProperty("dburl"),
					prop.getProperty("dbname"),prop.getProperty("dbpass"));
					PreparedStatement modify=conn.prepareStatement(prop.getProperty("modifydeliverydate"))
					){	
				modify.setInt(2, cdd.getContractNo());
				modify.setString(1, cdd.getDeliveryDate());
				int result=modify.executeUpdate();
				if(result>0) {
					System.out.println("\nDELIVERY DATE AND DAY MODIFIED SUCCESSFULLY !!\n");
					return true;
				}
				else {
					System.out.println("\nCONTRACT NUMBER THAT YOU HAVE ENTERED IS NOT PRESENT, PLEASE ENTER AGAIN !!\n");
					ClientPage.contractorOperations();
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
					PreparedStatement modify=conn.prepareStatement(prop.getProperty("modifydeliveryday"))
					){	
				modify.setInt(2, cdd.getContractNo());
				modify.setString(1, cdd.getDeliveryDay());
				int result=modify.executeUpdate();
				if(result>0) {
					System.out.println("\nDELIVERY DAY MODIFIED SUCCESSFULLY !!\n");
					return true;
				}
				else {
					System.out.println("\nCONTRACT NUMBER THAT YOU HAVE ENTERED IS NOT PRESENT, PLEASE ENTER AGAIN !!\n");
					ClientPage.contractorOperations();
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
					PreparedStatement modify=conn.prepareStatement(prop.getProperty("modifyquantity"))
					){	
				modify.setInt(2, cdd.getContractNo());
				modify.setString(1, cdd.getQuantity());
				int result=modify.executeUpdate();
				if(result>0) {
					System.out.println("\nQUANTITY MODIFIED SUCCESSFULLY !!\n");
					return true;
				}
				else {
					System.out.println("\nCONTRACT NUMBER THAT YOU HAVE ENTERED IS NOT PRESENT, PLEASE ENTER AGAIN !!\n");
					ClientPage.contractorOperations();
				} 
			}
			catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
			break;
		default:
			ClientPage.contractorOperations();
			break;
		}
    return false;

	}//modify contractor end






}
