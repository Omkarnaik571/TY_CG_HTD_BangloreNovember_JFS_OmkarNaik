<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page session="false"%>
<%
	String msg = (String) request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		if (msg != null && !msg.isEmpty()) {
	%>
	<h2 style="color: green">
		<%=msg%></h2>
	<%
		}
	%>

	<fieldset>
		<legend>Employee SignUp </legend>
		<form method="post" action="./addEmployeeJsp">
			Employee Id: <input type="number" name="empId"><br>
			Name: <input type="text" name="name"><br> Salary:
			<input type ="number" name="salary">
			<br>
			Age: <input type ="number" name="age">
			<br>
			Designation: <input type="text" name="designation">
			<br>
			Password: <input type="password" name="password">
			<br>
			<br>
			<br>
			<input type="submit" value="AddEmployee">
		</form>

	</fieldset>

</body>
</html>