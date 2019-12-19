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

@WebServlet("/modifyEmployeeJsp")
public class ModifyEmployeeServlet extends HttpServlet {

private EmployeeService service=new EmployeeServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession(false);
		if (session != null) {
			//If user is already logged in
			int empId=Integer.parseInt(req.getParameter("empId"));
			String name=req.getParameter("name");
			String salary=(req.getParameter("salary"));
			String age=(req.getParameter("age"));
			String designation=req.getParameter("designation");
			String password=req.getParameter("password");
			EmployeeInfoBean employeeInfoBean=new EmployeeInfoBean();
		
			
			if(age != null && !age.isEmpty()) {
				int ageVal=Integer.parseInt(age);
				employeeInfoBean.setAge(ageVal);
			}
			if(salary != null && !salary.isEmpty()) {
				double salVal=Double.parseDouble(salary);
				employeeInfoBean.setSalary(salVal);
				
			}
			employeeInfoBean.setEmpId(empId);
			employeeInfoBean.setName(name);
			
			employeeInfoBean.setDesignation(designation);
			employeeInfoBean.setPassword(password);
			
			if(service.updateEmployee(employeeInfoBean)) {
				//If User data modified successfully
				req.setAttribute("msg", "User data Updated successfully !!");
				
			}
			else {
				//If something went wrong
				req.setAttribute("msg", "User data not Updated !!");
				
			}
			req.getRequestDispatcher("./updateEmployeeJsp").forward(req, resp);
			
		}
		else {
			//If user has been logged out
			req.getRequestDispatcher("./loginForm").forward(req, resp);
		}
		
		
		
	}
	
	
}
