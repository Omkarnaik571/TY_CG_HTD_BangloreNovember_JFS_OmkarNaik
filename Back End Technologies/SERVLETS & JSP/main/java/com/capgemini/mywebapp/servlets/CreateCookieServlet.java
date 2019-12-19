package com.capgemini.mywebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/createcookie")
public class CreateCookieServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		
		Cookie mycookie=new Cookie("EmpName","Jai_Hind_doston");
		resp.addCookie(mycookie);
		
		RequestDispatcher dispatcher=req.getRequestDispatcher("./Cookie.html");
		dispatcher.include(req, resp);
		
		
		
		out.println("<html>");
		out.println("<body>");
		out.println("<h2>cookie Created successfully..</h2>");
		out.println("</body>");
		out.println("</html>");
	}
	
	
}
