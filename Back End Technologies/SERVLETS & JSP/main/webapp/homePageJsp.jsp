<%@page import="com.capgemini.mywebapp.bin.EmployeeInfoBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<%HttpSession session=request.getSession(false);%>
  <%	EmployeeInfoBean employeeInfoBean=(EmployeeInfoBean)session.getAttribute("employeeInfoBean"); %>

	<h3 style="color: blue;">
		WELCOME 
		<%= employeeInfoBean.getName()%>
	</h3>
	<br>
      <a href="./addEmpJsp"> Add Employee  </a><br>
       <a href="./deleteEmpJsp"> Delete Employee  </a><br>
       <a href="./updateEmployeeJsp"> Update Employee  </a><br>
       <a href="./getSingleemployee"> Search Employee  </a><br>
       <a href="./getAllEmpJsp"> See All Employee  </a><br><br>
       <a href="./logout2"> Logout  </a><br>



</body>
</html>