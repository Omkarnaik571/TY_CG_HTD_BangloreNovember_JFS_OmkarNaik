 package com.capgemini.mywebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.capgemini.mywebapp.bin.EmployeeInfoBean;
import com.capgemini.mywebapp.service.EmployeeService;
import com.capgemini.mywebapp.service.EmployeeServiceImpl;

@WebServlet("/searchEmployee")
public class SearchEmployeeServlet extends HttpServlet {

	private EmployeeService employeeservice=new EmployeeServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
	    String empIdval=req.getParameter("empId");
	    int empId=Integer.parseInt(empIdval);
	EmployeeInfoBean employeeInfoBean=employeeservice.searchEmployee(empId);
	
	ServletContext context=getServletContext();
    String contextparamval = context.getInitParameter("myContextParam");
	
	out.print("<html>");
	out.print("<body>");
	if(employeeInfoBean != null) {
	    	out.println("<h3>  Employee Id "+empId+" Found </h3>");
	    	out.println("Name =  "+employeeInfoBean.getName());
	    	out.println("<br>Age =  "+employeeInfoBean.getAge());
	    	out.println("<br>Salary =  "+employeeInfoBean.getSalary());
	    	out.println("<br>Designation =  "+employeeInfoBean.getDesignation());
	    	
	    	
	    	
	    }
	    else {
	    	out.println("<h3 style='color:red'>  Employee ID"+empId+" not found</h3>");	
	    }
	out.println("<br><br> Context Param Value = "+contextparamval);
	out.print("</body>");
	out.print("</html>");
	}
	
	
	
}
