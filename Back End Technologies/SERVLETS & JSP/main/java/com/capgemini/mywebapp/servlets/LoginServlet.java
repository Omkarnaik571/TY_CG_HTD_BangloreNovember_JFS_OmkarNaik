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
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private EmployeeService service=new EmployeeServiceImpl();
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String empIdval=req.getParameter("empId");
		String password=req.getParameter("password");
		
		int empId=Integer.parseInt(empIdval);
		
		 EmployeeInfoBean employeeInfoBean=service.authenticate(empId, password);
		
		 PrintWriter out=resp.getWriter();
		 out.print("<html>");
		 out.print("<body>");
		if(employeeInfoBean != null) {
			HttpSession session=req.getSession(true);
			session.setAttribute("employeeInfoBean", employeeInfoBean);
			out.println("<h3>Welcome "+employeeInfoBean.getName()+" !<h3>");
			out.println("<br><a href='./Addemployee.html'>Add Employee  </a>");
			out.println("<br><a href='#'>update Employee  </a>");
			out.println("<br><a href='./searchEmpForm.html'>Search Employee  </a>");
			out.println("<br><a href='./Deleteemployee.html'>Delete Employee  </a>");
			out.println("<br><a href='#'>See All Employee  </a>");
			out.println("<br><br><a href='./logout'> Logout  </a>");
		}
		else {
			out.print("<h3 'color : red'>Invalid Credential..<h3>");
			req.getRequestDispatcher("./loginpage.html").include(req, resp);
		}
		
		 out.print("</body>");
		 out.print("</html>");
		
	}//end of do post
}//end of class
