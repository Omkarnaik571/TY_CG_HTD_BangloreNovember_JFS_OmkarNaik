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

import antlr.collections.List;

@WebServlet("/getAllEmpJsp")
public class GetAllEmployeeServlet extends HttpServlet {
	private EmployeeService service=new EmployeeServiceImpl();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession(false);
		if (session != null) {
			//User has logged in
          java.util.List<EmployeeInfoBean> l1= service.getAllEmployees();			
			if(l1 != null) {
				//query executed perfectly
				req.setAttribute("msg", l1);
				req.getRequestDispatcher("./getEveryEmployeeJsp").forward(req, resp);
			}
			else {
				//something went wrong with the query(Back to search emp page)
				req.setAttribute("msg", "Something went wrong with the server");
				req.getRequestDispatcher("./getEveryEmployeeJsp").forward(req, resp);
			}
          
          
		}
		else {
			//user has not logged in(Backto login page)
			req.getRequestDispatcher("./loginForm").forward(req, resp);
			
		}
		
		
		
		
		
	}
	
	
	

}
