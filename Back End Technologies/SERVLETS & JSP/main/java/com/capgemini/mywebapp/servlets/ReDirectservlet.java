package com.capgemini.mywebapp.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/redirect")
public class ReDirectservlet extends HttpServlet  {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter();
		
//		String url="http://www.youtube.com";
		String url="./currentDate";
		
		resp.sendRedirect(url);
		
		
		
	}
	
	
	
	
}
