package com.capgemini.mywebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/includedemo1")
public class IncludePractice extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		
		String url="./currentDate";
	      RequestDispatcher dispatcher=req.getRequestDispatcher(url);
	      dispatcher.include(req, resp);
		
	   out.println("<h1>Toh Abba harmonium Bajtay Thay..   </h1>");
		
		out.println("</body>");
		out.println("</html>");
		
	}
	
	
}
