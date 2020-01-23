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

import com.capgemini.forestmanagementsystem.controller.AdminLandOperation;
import com.capgemini.forestmanagementsystem.controller.AdminPage;
import com.capgemini.forestmanagementsystem.dto.ContractorDetailsDto;
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
			insert.setString(3,ldd.getLandValue());
			insert.setString(4, ldd.getLocation());
			int result=insert.executeUpdate();
			if(result>0) {
				return true;

			} 
		}
		catch (Exception e) {
			throw new CustomExceptions("The plot number that you have entered already exists !!");
			
		}
		return false;

	}
	//add land end..

	@Override
	public boolean deleteLand(LandDetailsDto ldd) throws CustomExceptions {
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
				return true;

			} 

		}
		catch (Exception e) {
			throw new CustomExceptions("The plot number that you have entered doesnot exists !!");
		}

		return false;
	}
	// delete land end..

	@Override
	public boolean modifyLand(LandDetailsDto ldd,int ch) throws CustomExceptions {
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
					return true;
				} 
				break;
			case 2:
				modifylandvalue.setInt(2, ldd.getPlotNumber());
				modifylandvalue.setString(1, ldd.getLandValue());
				result=modifylandvalue.executeUpdate();
				if(result>0) {
					return true;
				} 
				break;

			default:
				break;
			}
		}
		catch (Exception e) {
			throw new CustomExceptions("The plot number that you have entered does not exists !!");
		}
		return false;

	}
	// modify land end

	@Override
	public List<LandDetailsDto> viewAllLand() throws CustomExceptions {
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
		List<LandDetailsDto> l1=new ArrayList<LandDetailsDto>();
		try(Connection conn=DriverManager.getConnection(prop.getProperty("dburl"),
				prop.getProperty("dbname"),prop.getProperty("dbpass"));
				java.sql.Statement stmt= conn.createStatement();
				){	
			ResultSet rs=stmt.executeQuery(prop.getProperty("viewalllanddetails"));
			while(rs.next()) {
		    	LandDetailsDto cdt=new LandDetailsDto();
		    	cdt.setPlotNumber(rs.getInt(1));
		    	cdt.setAcquireDdate(rs.getString(2));
		    	cdt.setLandValue(rs.getString(3));
		    	cdt.setLocation(rs.getString(4));
		    	l1.add(cdt);
		    	
		    }

		}
		catch (Exception e) {
			throw new CustomExceptions("There are no land records present in the data base !!");
		}
	 return l1;
	}
	// view all land end..

}
