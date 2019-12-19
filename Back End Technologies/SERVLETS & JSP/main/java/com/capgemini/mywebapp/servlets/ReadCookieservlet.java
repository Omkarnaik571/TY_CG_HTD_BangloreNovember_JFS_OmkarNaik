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

@WebServlet("/readcookie")
public class ReadCookieservlet extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	  
	  Cookie[] cookies=req.getCookies();
	  resp.setContentType("text/html");	
	  PrintWriter out=resp.getWriter();
	  
	  req.getRequestDispatcher("./Cookie.html").include(req, resp);
	  
	    out.println("<html>");
		out.println("<body>");
		if(cookies != null) {
			for (Cookie c1 : cookies) {
				out.print("<br>cookie name = "+c1.getName());
				out.print("<br>cookie Value = "+c1.getValue());
			}	
		}
		else {
			out.print("<br> No cookie found..");
		}
		
		out.println("</body>");
		out.println("</html>");
	  
	  
	  
	  
		
		
		
		
	}
	
}
