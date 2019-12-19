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

@WebServlet("/addEmployeeJsp")
public class AddEmployeeServlet extends HttpServlet {
	
	private EmployeeService service=new EmployeeServiceImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         HttpSession session=req.getSession(false);
		if (session != null) {
			//User Is already Logged In
			int empId=Integer.parseInt(req.getParameter("empId"));
			String name=req.getParameter("name");
			double salary=Double.parseDouble(req.getParameter("salary"));
			int age=Integer.parseInt(req.getParameter("age"));
			String designation=req.getParameter("designation");
			String password=req.getParameter("password");
			EmployeeInfoBean employeeInfoBean=new EmployeeInfoBean();
			employeeInfoBean.setAge(age);
			employeeInfoBean.setEmpId(empId);
			employeeInfoBean.setName(name);
			employeeInfoBean.setSalary(salary);
			employeeInfoBean.setDesignation(designation);
			employeeInfoBean.setPassword(password);
			
			if(service.addEmployee(employeeInfoBean)) {
				//If added SuccessFully
				req.setAttribute("msg", "User added Successfully");
			    req.getRequestDispatcher("./addEmpJsp").forward(req, resp);
			}
			else {
				//If Credentials are invalid
	
			req.setAttribute("msg", "Duplicate User Id");
			req.getRequestDispatcher("./addEmpJsp").forward(req, resp);
			}
		}
		else {
			//User has been logged out
			req.setAttribute("msg", "You have logged out, Login again");
			req.getRequestDispatcher("./loginForm").forward(req, resp);
		}
		
		
	}	



}
