package com.capgemini.mywebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/foroward")
public class ForowardingServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
//		String url="./currentDate";
		String url="http://www.google.com";
		
		
		
		RequestDispatcher dispatcher=req.getRequestDispatcher(url);
		dispatcher.forward(req, resp);

		
		
		
		
		
	}
	
	
	
}
