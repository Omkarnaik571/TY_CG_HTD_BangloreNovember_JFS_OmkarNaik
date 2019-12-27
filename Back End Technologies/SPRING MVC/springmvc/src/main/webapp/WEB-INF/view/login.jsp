<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <h4 style="color: red">${msg}</h4>


	<fieldset>
		<legend>-----FILL THE FORM---------</legend>
		<form action="./login" method="post">
			<table>
				<tr>
					<td>User Name:</td>
					<td><input type="text" name="username"> </td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="password" name="password"> </td>
				</tr>
				<tr>
					<td><input type="submit" name="login" value="Submit"> </td>
				</tr>				
			</table>
		</form>
	</fieldset>



</body>
</html>