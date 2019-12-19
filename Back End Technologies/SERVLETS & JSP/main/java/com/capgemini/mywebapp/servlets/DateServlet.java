package com.capgemini.mywebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DateServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Current system date and time
		Date date=new Date();
		
		//Get The context param
		ServletContext context=getServletContext();
       String contextparamval = context.getInitParameter("myContextParam");
		
      ServletConfig config=getServletConfig();
		String contextparamval1=config.getInitParameter("MyParam");
		
		resp.setContentType("text/html");
		resp.setHeader("refresh", "5");
		PrintWriter out=resp.getWriter();
		out.print("<html>");
		out.print("<h2> Current date and time -- <br>"+date+"</h2>"  );
		out.println("<br><br> Context Param Value = "+contextparamval);
		out.println("<br><br> Context Param Value = "+contextparamval1);
		out.print("</html>");	
	}//end of do get
	
}
