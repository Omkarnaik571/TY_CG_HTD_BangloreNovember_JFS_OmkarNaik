package com.capgemini.mywebapp.servletforjsps;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout2")
public class LogoutServlet extends HttpServlet  {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession(false);
		if (session != null) {
			session.invalidate(); 
			req.setAttribute("msg", "Successfully logged Out !!");
		}
		else {
			//If session is not there
			req.setAttribute("msg", "You are not Logged In !!");
			
		}
		
		req.getRequestDispatcher("./loginForm").forward(req, resp);
	}
	
	
}
