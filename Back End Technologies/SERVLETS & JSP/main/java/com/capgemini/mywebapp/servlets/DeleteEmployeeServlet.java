package com.capgemini.mywebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.capgemini.mywebapp.service.EmployeeService;
import com.capgemini.mywebapp.service.EmployeeServiceImpl;
@WebServlet("/deleteEmployee")
public class DeleteEmployeeServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession(false);
		EmployeeService service=new EmployeeServiceImpl();
		if (session != null) {
			//Valid Session
			int empId=Integer.parseInt(req.getParameter("empId"));
			PrintWriter out=resp.getWriter();
			out.println("<html>");
			out.println("<body>");
			if( service.deleteEmployee(empId)) {

				out.println("<h3 style='color:red'>Employee "+empId+" deleted successfully</h3>");

			}   
			else {
				out.println("<h3 style='color:red'>Employee not found</h3>");
				
				

			}
			out.println("</body>");
			out.println("</html>");

			req.getRequestDispatcher("./Deleteemployee.html").include(req, resp);
		}	
		else{
			//invalid session
			PrintWriter out=resp.getWriter();
			out.println("<html>");
			out.println("<body>");
			
			out.println("<h3 style='color:yellow'> please login first </h3>");
			req.getRequestDispatcher("./Deleteemployee.html").include(req, resp);
			out.println("</body>");
			out.println("</html>");
			
			
		}


	}//end Of Doget()
}//end of class
