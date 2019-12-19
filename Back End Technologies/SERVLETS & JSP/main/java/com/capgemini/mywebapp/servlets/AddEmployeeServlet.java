package com.capgemini.mywebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.capgemini.mywebapp.bin.EmployeeInfoBean;
import com.capgemini.mywebapp.service.EmployeeService;
import com.capgemini.mywebapp.service.EmployeeServiceImpl;


@WebServlet("/addEmployee")
public class AddEmployeeServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		HttpSession session=req.getSession(false);
		EmployeeService service=new EmployeeServiceImpl();
		
		
		if (session != null) {
			//valid session
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
			out.println("<html>");
			out.println("<body>");	
			
			if(service.addEmployee(employeeInfoBean)) {
				//if object added
				out.println("<h3 style='color:green'>Employee added successfully .. </h3>");
				
			}
			else {
				//if object not added
				out.println("<h3 style='color:red'>Something Went Wrong </h3>");
			}
		   
			out.println("</body>");
			out.println("</html>");
			req.getRequestDispatcher("./Addemployee.html").include(req, resp);
			
		}
		else {
			//invalid session
			out.println("<html>");
			out.println("<body>");
			out.println("<h3 style='color:red'>Please Login First </h3>");
			req.getRequestDispatcher("./loginpage.html").include(req, resp);
			out.println("</body>");
			out.println("</html>");
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
}
