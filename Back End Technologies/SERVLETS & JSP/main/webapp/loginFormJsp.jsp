<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<% String msg=(String)request.getAttribute("msg");   %>
<%@ page session="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<% if(msg != null && !msg.isEmpty()){ %>
	<%= msg %>
	<% } %>


	<fieldset>
		<legend>Employee Login </legend>
		<form method="post" action="./login2">

			<table>
				<tr>
					<td>Id:</td>
					<td></td>
					<td><input type="number" name="empId"></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td></td>
					<td><input type="password" name="password" required></td>
				</tr>
				<tr>
					<td colspan="3" align="center"><br> <input type="submit"
						value="login"></td>
				</tr>

			</table>

		</form>

	</fieldset>



</body>
</html>