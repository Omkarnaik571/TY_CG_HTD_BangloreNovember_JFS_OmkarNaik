package com.capgemini.mywebapp.servletforjsps;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.capgemini.mywebapp.service.EmployeeService;
import com.capgemini.mywebapp.service.EmployeeServiceImpl;

@WebServlet("/deleteEmployeeJsp")
public class DeleteEmployeeServlet extends HttpServlet  {
	private EmployeeService service=new EmployeeServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession(false);
		if (session != null) {
			//session is not null
			int empId=Integer.parseInt(req.getParameter("empId"));
			
			if(service.deleteEmployee(empId)) {
				//Employee Deleted
				req.setAttribute("msg", "User Deleted successfully ..");
				req.getRequestDispatcher("./deleteEmpJsp").forward(req, resp);
				
			}
			else {
				//employee Not Deleted
				req.setAttribute("msg", "User Id that has been entered is Not in the database..");
				req.getRequestDispatcher("./DeleteEmployeeJsp.jsp").forward(req, resp);
				
			}
			
		}
		else {
			//session is null(Send back to login page)
			req.setAttribute("msg", "You have not logged in, please log in first..");
			req.getRequestDispatcher("./loginForm").forward(req, resp);
			
			
		}
		
		
		
		
	}
	
	

}
