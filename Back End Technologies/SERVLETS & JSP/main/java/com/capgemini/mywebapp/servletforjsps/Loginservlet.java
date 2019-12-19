package com.capgemini.mywebapp.servletforjsps;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.capgemini.mywebapp.bin.EmployeeInfoBean;
import com.capgemini.mywebapp.service.EmployeeService;
import com.capgemini.mywebapp.service.EmployeeServiceImpl;

@WebServlet("/login2")
public class Loginservlet extends HttpServlet{
	private EmployeeService service=new EmployeeServiceImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//get the form data
		int empId=Integer.parseInt(req.getParameter("empId"));
		String password=req.getParameter("password");

		EmployeeInfoBean employeeInfoBean=service.authenticate(empId, password);
		if (employeeInfoBean != null) {
			HttpSession session=req.getSession(true);
			session.setAttribute("employeeInfoBean", employeeInfoBean);
			session.setMaxInactiveInterval(300); 
			req.getRequestDispatcher("./homePageJsp.jsp").forward(req, resp);
		}
		else {
			//Invalid Credential
			req.setAttribute("msg", "Invalid credentials !!");
			req.getRequestDispatcher("./loginForm").forward(req, resp);	
		}
	}
}//End of servlet
