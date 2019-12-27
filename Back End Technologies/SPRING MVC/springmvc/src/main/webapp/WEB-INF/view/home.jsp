<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:useBean id="user" class="springmvccom.capgemini.beans.User"
  scope="session"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 style="color: blue"> ${msg} </h1>

<h1> Welcome  <%= user.getName()%> </h1>
<h3>E-Mail : <%= user.getEmail() %> </h3>
<h3>Password : <%= user.getPassword() %> </h3>
<h3>Gender : <%= user.getGender() %> </h3>


</body>
</html>