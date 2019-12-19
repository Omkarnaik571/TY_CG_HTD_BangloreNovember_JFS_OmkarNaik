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

@WebServlet("/searchEmployee3")
public class SearchEmoloyeeServlet extends HttpServlet {

	private EmployeeService service=new EmployeeServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession(false);
		if (session != null) {
			//Valid session
			int empId=Integer.parseInt(req.getParameter("empId"));
			EmployeeInfoBean employeeInfoBean= service.searchEmployee(empId);
			req.setAttribute("employeeInfoBean", employeeInfoBean);
			req.getRequestDispatcher("./searchEmpFormJsp.jsp").forward(req, resp);
			
		}
		else {
			//invalid session
		req.setAttribute("msg", "Please login first,");
		req.getRequestDispatcher("./loginForm").forward(req, resp);
		
		}
		
		
		
	}//end of do get
	
	
	
}
