package com.capgemini.mywebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DateServletDeomo1 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Date date=new Date();
		
		resp.setContentType("text/html");
		resp.setHeader("refresh", "2");
		
		PrintWriter out=resp.getWriter();
		out.print("<html>");
		out.print("<h2> Curresnt System Date and Time : "+date+"</h2>");
		out.print("</html>");
		
	}
	
	
	
	
}
