package com.capgemini.forestmanagementsystem.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import com.capgemini.forestmanagementsystem.controller.ClientContractOperation;
import com.capgemini.forestmanagementsystem.controller.ClientPage;
import com.capgemini.forestmanagementsystem.dto.ContractorDetailsDto;
import com.capgemini.forestmanagementsystem.exceptions.CustomExceptions;
import com.capgemini.forestmanagementsystem.factory.FactoryClass;
import com.capgemini.forestmanagementsystem.validations.Validations;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;


public class ContractorDetailsDaoImpl  implements ContractorDetailsDao{

	ContractorDetailsDto cdd=FactoryClass.getContractorDetailsDto();
    Scanner sc=new Scanner(System.in);


	@Override
	public boolean addContractor(ContractorDetailsDto cdd ) throws CustomExceptions {
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
				PreparedStatement insert=conn.prepareStatement(prop.getProperty("insertcontractor"))
				){	
			insert.setInt(1, cdd.getContractNo());
			insert.setInt(2, cdd.getCustomerId());
			insert.setInt(3, cdd.getProductId());
			insert.setString(4, cdd.getDeliveryDate());
			insert.setString(5, cdd.getQuantity());
			int result=insert.executeUpdate(); 
		}
		catch (Exception e) {
			throw new CustomExceptions("The Contract No that you have entered already exists !!");
		}
		return true;
	}//add contractor end

	@Override
	public List<ContractorDetailsDto> viewContractorDetails() throws CustomExceptions {
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
		List<ContractorDetailsDto> l1=new ArrayList<ContractorDetailsDto>();
		try(Connection conn=DriverManager.getConnection(prop.getProperty("dburl"),
				prop.getProperty("dbname"),prop.getProperty("dbpass"));
//				Scanner sc=new Scanner(System.in);
				Statement stmt=conn.createStatement()
				){	
			ResultSet rs=stmt.executeQuery(prop.getProperty("viewallcontractor"));
		    
		    while(rs.next()) {
		    	ContractorDetailsDto cdt=new ContractorDetailsDto();
		    	cdt.setContractNo(rs.getInt(1));
		    	cdt.setCustomerId(rs.getInt(2));
		    	cdt.setProductId(rs.getInt(3));
		    	cdt.setDeliveryDate(rs.getString(4));
		    	cdt.setQuantity(rs.getString(5));
		    	l1.add(cdt);
		    }
		}
		catch (Exception e) {
			throw new CustomExceptions("\n There are no Contract details present in the database !!\n");
		}
		return l1;
		
	}//view all contractor end


	@Override
	public ContractorDetailsDto viewSingleContractorDetails(ContractorDetailsDto cdd) throws CustomExceptions {
		//For loading the driver
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
				PreparedStatement viewsingle=conn.prepareStatement(prop.getProperty("viewsinglecontractor"))
				){	
			viewsingle.setInt(1, cdd.getContractNo());
			ResultSet rs=viewsingle.executeQuery();	
			while(rs.next()) {
				ContractorDetailsDto cdt=new ContractorDetailsDto();
		    	cdt.setContractNo(rs.getInt(1));
		    	cdt.setCustomerId(rs.getInt(2));
		    	cdt.setProductId(rs.getInt(3));
		    	cdt.setDeliveryDate(rs.getString(4));
		    	cdt.setQuantity(rs.getString(5));
				return cdt;
			}
		}
		catch (Exception e) {
			throw new CustomExceptions("THE CONTRACT NO THAT YOU HAVE ENTERED IS NOT PRESENT !!");
		}
		return null;
	}//view single contractor end

	@Override
	public boolean deleteContractorDetails(ContractorDetailsDto cdd ) throws CustomExceptions {
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
				PreparedStatement delete=conn.prepareStatement(prop.getProperty("deletecontractor"))
				){	
			delete.setInt(1, cdd.getContractNo());
			int result=delete.executeUpdate();
			if(result>0) {
				return true;

			}	
		}
		catch (Exception e) {
			throw new CustomExceptions("THE CONTRACT NO THAT YOU HAVE ENTERED IS NOT PRESENT !!");
		}

		 return false;

	}//delete contractor end




	@Override
	public boolean modifyContractorDetails(ContractorDetailsDto cdd,int cno) throws CustomExceptions {
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
					return true;
				} 
			}
			catch (Exception e) {
				throw new CustomExceptions("CONTRACT NUMBER THAT YOU HAVE ENTERED IS NOT PRESENT, PLEASE ENTER AGAIN !! ");
			}
			break;
		case 2:
			try(Connection conn=DriverManager.getConnection(prop.getProperty("dburl"),
					prop.getProperty("dbname"),prop.getProperty("dbpass"));
					PreparedStatement modify=conn.prepareStatement(prop.getProperty("modifyquantity"))
					){	
				modify.setInt(2, cdd.getContractNo());
				modify.setString(1, cdd.getQuantity());
				int result=modify.executeUpdate();
				if(result>0) {
					return true;
				} 
			}
			catch (Exception e) {
				throw new CustomExceptions("CONTRACT NUMBER THAT YOU HAVE ENTERED IS NOT PRESENT, PLEASE ENTER AGAIN !! ");
			}
			break;
		default:
			break;
		}
    return false;

	}//modify contractor end






}
