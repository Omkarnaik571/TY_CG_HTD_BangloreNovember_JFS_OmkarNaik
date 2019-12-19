<%@page import="java.util.ArrayList"%>
<%@page import="com.capgemini.mywebapp.bin.EmployeeInfoBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page session="false"%>
<%
	
    List<EmployeeInfoBean> result=(List<EmployeeInfoBean>)request.getAttribute("msg");
    		
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h3>
		<a href="./homePageJsp.jsp">Go Back To Home page</a>
	</h3>



	<%
		if (result != null && !result.isEmpty()) {
	%>
	<h2 style="color: green">Details Of All the Employees Are</h2>
	<table style="border: 4px solid blue;">
		<tr >
			<th>Id</th>
			<th>Name</th>
			<th>Designation</th>
			<th>Age</th>
			<th>Salary</th>
			<th>Password</th>

		</tr>
		<% for (EmployeeInfoBean ei :result ) {%>
           <tr >
           <td><%=ei.getEmpId() %> </td>
           <td><%=ei.getName() %> </td>
           <td><%=ei.getDesignation() %> </td>
           <td><%=ei.getAge() %> </td>
           <td><%=ei.getSalary() %> </td>
           <td><%=ei.getPassword() %> </td>
           </tr>


		<% }%>
	</table>




	<%}%>





</body>
</html>