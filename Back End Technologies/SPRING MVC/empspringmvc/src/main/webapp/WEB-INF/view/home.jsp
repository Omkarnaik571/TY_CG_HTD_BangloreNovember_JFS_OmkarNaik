<%@page import="com.capgemini.empmvcspring.bean.EmployeeBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:useBean id="bean"
	class="com.capgemini.empmvcspring.bean.EmployeeBean" scope="session">
</jsp:useBean>



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color: lavender;">
	<a href="./changepassword">ChangePassword</a>
	<!-- <a href="./logout" style="float:right;">LogOut</a> -->
	<h1>
		Welcome
		<%= bean.getName()%>
	</h1>


	<form action="./search">
		<table>
			<tr>
				<td>Enter Key :</td>
				<td><input type="text" name="key"></td>
			</tr>
			<tr>
				<td><input type="submit" value="search"></td>
			</tr>
		</table>
	</form>


	<a href="./logout">LogOut</a>

	<%
   List<EmployeeBean> list=(List<EmployeeBean>)request.getAttribute("list");

%>
	<% 
      if(list != null){
%>
	<% if(list.isEmpty()){%>
	<h3>No Data Found..</h3>
	<%}else{%>
	<table>
  <tr>
  <th>Id:</th>
    <th>Name:</th>
    <th>E-Mail:</th>
    <th>Password:</th>
  </tr>
  <% for(EmployeeBean bean1:list){%>
  <tr>
    <td><%=bean1.getId() %></td>
    <td><%=bean1.getName() %></td>
    <td><%=bean1.getEmail() %>  </td>
    <td><%=bean1.getPassword() %>  </td>
  </tr>
  <%} %>
</table>


	<%}%>
	
<%} %>


	<h1 style="color: green">${msg}</h1>



</body>
</html>