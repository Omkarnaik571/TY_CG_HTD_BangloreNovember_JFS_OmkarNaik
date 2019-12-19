package com.capgemini.mywebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetEmployeeServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String idval=req.getParameter("id");
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();

		out.println("<html>   ");
		out.println("<body>   ");
		out.println("Employeee Id = "+idval);
		out.println("<br>Name = Omkar");
		out.println("<br>Salary = 40000");
		out.println("</body>   ");
		out.println("</html>");


	}
	//end of do get
}
//end of class