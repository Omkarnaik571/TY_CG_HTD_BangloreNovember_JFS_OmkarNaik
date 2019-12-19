package com.capgemini.mywebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.capgemini.mywebapp.bin.EmployeeInfoBean;
import com.capgemini.mywebapp.service.EmployeeService;
import com.capgemini.mywebapp.service.EmployeeServiceImpl;

@WebServlet("/searchEmployee2")
public class SearchEmployeeServlet2 extends HttpServlet{

	private EmployeeService service=new EmployeeServiceImpl();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession(false);//Here we dont need to create another session
		//we want the existing session created during login time,thats why getSession is false..
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		if (session != null) {
			//valid session
			String empIdval=req.getParameter("empId");
			int empId=Integer.parseInt(empIdval);
			
			EmployeeInfoBean employeeInfoBean=service.searchEmployee(empId);
			if(employeeInfoBean != null) {
		    	out.println("<h3>  Employee Id "+empId+" Found </h3>");
		    	out.println("Name =  "+employeeInfoBean.getName());
		    	out.println("<br>Age =  "+employeeInfoBean.getAge());
		    	out.println("<br>Salary =  "+employeeInfoBean.getSalary());
		    	out.println("<br>Designation =  "+employeeInfoBean.getDesignation());
		    	out.println("<br><h2 style='color:brown'>Password =  "+employeeInfoBean.getPassword()+"</h2>");
		    }
		    else {
		    	out.println("<h3 style='color:red'> > Employee ID"+empId+" not found</h3>");	
		    }
			
		}
		else {
			//Invalid Session
			out.println("<h3 style='color:yellow'>Please Login Again </h3>");
			req.getRequestDispatcher("./loginpage.html").include(req, resp);
			
//			String url="./loginpage.html";
//			RequestDispatcher dispatcher=req.getRequestDispatcher(url);
//			dispatcher.include(req, resp);
			
		}
		out.println("</body>");
		out.println("</html>");
		
	}//end of doget	

}//end of class
