<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page session="false"%>
   <% String msg1=(String)request.getAttribute("msg");%> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

   

 <fieldset>
		<legend>
			DELETE EMPLOYEE<br>
		</legend>
		<form action="./deleteEmployeeJsp" method="get">
			EMPLOYEE ID: <input type="number" name="empId" required> <br>
			<input type="submit" value="Delete">

		</form>
	</fieldset>
<% if(msg1 != null && !msg1.isEmpty()){ %>
	    <h2 style="color: red">   <%= msg1 %></h2>
	<% } %>

</body>
</html>