package com.capgemini.jdbc.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import com.capgemini.jdbc.bean.UserBean;
import com.mysql.jdbc.Statement;


public class UserDAOImpl implements UserDAO {

	Scanner sc=new Scanner(System.in );
	FileReader reader;
	Properties prop;
    UserBean user;	
	
	//<-----------Constructor To load the Driver----------->
	public UserDAOImpl() {
		
		try {
			
			reader=new FileReader("db.properties");
			prop=new Properties();
			prop.load(reader);
			
			Class.forName(prop.getProperty("driverClass"));
		}
		
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	
	//1.
	@Override
	public List<UserBean> getAllUsers() {
		List<UserBean> list=new ArrayList<UserBean>();
		try(
				//2. Getting The Connection
				Connection conn=DriverManager.getConnection(prop.getProperty("dburl"),
				prop.getProperty("dbuser"),prop.getProperty("dbpassword"));
				//.3 Create Statement
			java.sql.Statement stmt=conn.createStatement();	
				//4.executing the Query()
			ResultSet rs=stmt.executeQuery(prop.getProperty("query1"));			
				){
			while(rs.next()) {
				user=new UserBean();
				user.setUserid(rs.getInt(1));
				user.setUser_name(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setPassword(rs.getString(4));
				list.add(user);
//				System.out.println("User Id : "+rs.getInt(1));
//			    System.out.println("User Name : "+rs.getString("user_name"));
		        	
			}
			return list;
			
		}
		catch (Exception e) {
			
			e.printStackTrace();// TODO: handle exception
		}
		return null;
	}
	
    //2.
	@Override
	public UserBean userLogin(String user_name, String password) {
		try(//2. Getting The Connection
				Connection conn=DriverManager.getConnection(prop.getProperty("dburl"),
				prop.getProperty("dbuser"),prop.getProperty("dbpassword"));
				//.3 Create Statement
			PreparedStatement stmt=conn.prepareStatement(prop.getProperty("loginquery"));	
					
						
				){
			stmt.setString(1,user_name);
			stmt.setString(2, password);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
        	  user=new UserBean();
				user.setUserid(rs.getInt(1));
				user.setUser_name(rs.getString(2));
				user.setEmail(rs.getString(3));
//				user.setPassword(rs.getString(4));
          } 
			
			return user;
			
			
		}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		
		
		
		
		
		
		
		// TODO Auto-generated method stub
		return null;
	}

	//3.
	@Override
	public boolean updateUser(int userid, String password) {
		try(Connection conn=DriverManager.getConnection(prop.getProperty("dburl"),
				prop.getProperty("dbuser"),prop.getProperty("dbpassword"));
				
			PreparedStatement stmt=conn.prepareStatement(prop.getProperty("updatequery"))
				
				){
			stmt.setInt(2, userid);
			stmt.setString(3, password);
			System.out.println("Enter the new Password: ");
			Scanner sc=new Scanner(System.in);
			stmt.setString(1,sc.nextLine() );
			
			int result=stmt.executeUpdate();
			sc.close();
			if(result>0) {
				return true;
			}
			else {
				return false;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		return false;
	}

	//4.
	@Override
	public boolean insertUser(UserBean user) {
		// TODO Auto-generated method stub
		try(Connection conn=DriverManager.getConnection(prop.getProperty("dburl"),
				prop.getProperty("dbuser"),prop.getProperty("dbpassword"));
				
			PreparedStatement pstmt=
					conn.prepareStatement(prop.getProperty("insertquery"));
					
				){
			System.out.println("Connection is made.....");
			pstmt.setInt(1, user.getUserid());		
            pstmt.setString(2, user.getUser_name());
			   pstmt.setString(3,user.getEmail());	
				pstmt.setString(4, user.getPassword());
			
		int result=pstmt.executeUpdate();
				System.out.println(result);
		if(result>0) {
			return true;
		}
		else {
			return false;
		}		
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return false;
	}

	//5.
	@Override
	public boolean deleteUser(int userid, String password) {
		try(
				Connection conn=DriverManager.getConnection(prop.getProperty("dburl"),
						prop.getProperty("dbuser"),prop.getProperty("dbpassword"));
				PreparedStatement pstmt1=
						conn.prepareStatement(prop.getProperty("deletequery"));
				){
			
			System.out.println("Connection is Made.......");
			pstmt1.setInt(1,userid);
			pstmt1.setString(2,password);
		      
			
			int count=pstmt1.executeUpdate();
//			System.out.println(count);
			
			if(count>0) {
				return true;
			}
			else {
				return false;
			}	
			
		}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		// TODO Auto-generated method stub
		return false;
	}

	
		
	
	
	
	
	
}
