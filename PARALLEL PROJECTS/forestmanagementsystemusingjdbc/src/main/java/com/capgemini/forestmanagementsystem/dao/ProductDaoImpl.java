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
import com.capgemini.forestmanagementsystem.controller.ClientPage;
import com.capgemini.forestmanagementsystem.dto.ProductDetailsDto;
import com.capgemini.forestmanagementsystem.exceptions.CustomExceptions;
import com.capgemini.forestmanagementsystem.factory.FactoryClass;
import com.capgemini.forestmanagementsystem.validations.Validations;
import com.mysql.jdbc.Statement;

public class ProductDaoImpl implements ProductDao {
	ProductDetailsDto pdd=FactoryClass.getProductDetailsDto();
    Scanner sc=new Scanner(System.in);
	
	@Override
	public boolean addProduct(ProductDetailsDto pdt ) throws CustomExceptions {
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
				PreparedStatement insert=conn.prepareStatement(prop.getProperty("insertproduct"))
				){	
			 insert.setInt(1, pdt.getProductId());
			insert.setString(2, pdt.getProductName());
			 int result=insert.executeUpdate();
			if(result>0) {
				return true;	
			} 
		}
		catch (Exception e) {
			throw new CustomExceptions("The product id that you have ebtered alreday exists !!");
			
		}
		
		return false;
	}//end of addProduct()

	@Override
	public boolean deleteProduct(ProductDetailsDto pdt ) throws CustomExceptions  {
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
				PreparedStatement delete=conn.prepareStatement(prop.getProperty("deleteproduct"))
				){
			 delete.setInt(1, pdt.getProductId());
			 int result=delete.executeUpdate();
				if(result>0) {
					return true;	
				} 
		}
		catch (Exception e) {
			throw new CustomExceptions("The product id that you have entered doesnot exists !!");
		}
		
		return false;
	}// end of deleteProduct()

	@Override
	public boolean modifyProduct(ProductDetailsDto pdt ) throws CustomExceptions {
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
				PreparedStatement modify=conn.prepareStatement(prop.getProperty("modifyproductname"))
				){
			modify.setInt(2, pdt.getProductId());
			modify.setString(1, pdt.getProductName());
			 int result=modify.executeUpdate();
				if(result>0) {
					return true;	
				}
			
		}
		catch (Exception e) {
			throw new CustomExceptions("The product id that you have ebtered alreday exists !!");
		}
		

		return false;
	}// end of modifyProduct()

	@Override
	public List<ProductDetailsDto> viewAllProduct() throws CustomExceptions {
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
		List<ProductDetailsDto> l1=new ArrayList<ProductDetailsDto>();
		try(Connection conn=DriverManager.getConnection(prop.getProperty("dburl"),
				prop.getProperty("dbname"),prop.getProperty("dbpass"));
//				Scanner sc=new Scanner(System.in);
				java.sql.Statement stmt=conn.createStatement()
				) {	
			ResultSet rs=stmt.executeQuery(prop.getProperty("viewallproduct"));
			while(rs.next()) {
				ProductDetailsDto pd=new ProductDetailsDto();
				pd.setProductId(rs.getInt(1));
				pd.setProductName(rs.getString(2));
				l1.add(pd);
			}
		}
		catch (Exception e) {
			throw new CustomExceptions("There are no products present in the database !!");
		}
		return l1;
		
	}// end of view allProduct()

	@Override
	public ProductDetailsDto viewParticularProduct(ProductDetailsDto pdd ) throws CustomExceptions {
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
				PreparedStatement view=conn.prepareStatement(prop.getProperty("viewsingleproduct"))
				){	
			
			 view.setInt(1, pdd.getProductId());
			ResultSet rs=view.executeQuery();
			while(rs.next()) {
				ProductDetailsDto pd=new ProductDetailsDto();
				pd.setProductId(rs.getInt(1));
				pd.setProductName(rs.getString(2));
				return pd;
			}
			
			
			}
		catch (Exception e) {
			throw new CustomExceptions("The product id that you have ebtered alreday exists !!");
		}
       return null;
	}// end of ParticularProduct()

	
	
	
}
