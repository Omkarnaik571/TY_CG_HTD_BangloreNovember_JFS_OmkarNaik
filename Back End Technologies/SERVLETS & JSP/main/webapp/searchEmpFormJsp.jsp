<%@page import="com.capgemini.mywebapp.bin.EmployeeInfoBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page session="false"%>
 <% EmployeeInfoBean employeeInfoBean=(EmployeeInfoBean)request.getAttribute("employeeInfoBean");%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 
  <fieldset>
		<legend>
			SERACH EMPLOYEE<br>
		</legend>
		<form action="./searchEmployee3" method="get">
			EMPLOYEE ID: <input type="number" name="empId" required> <br>
			<input type="submit" value="Search">

		</form>
	</fieldset>

     <% 
       if(employeeInfoBean == null){
     
     %>
     <br><br> <h3 style="color: blue">EMPLOYEE ID NOT FOUND </h3>
    
    <%} else {%>
    
      <h3 style="color: green"> Details For employee Id  <%=employeeInfoBean.getEmpId() %> </h3>
    <h4> Name = <%=employeeInfoBean.getName() %> </h4>
     <h4>Age = <%=employeeInfoBean.getAge() %></h4>
     <h4>Salary = <%=employeeInfoBean.getSalary() %> </h4>
     <h4>Designation = <%=employeeInfoBean.getDesignation() %> </h4>
     <h4>Password = <%=employeeInfoBean.getPassword() %> </h4>
    
    <%} %>
    
    
    
    
    
    
</body>
</html>