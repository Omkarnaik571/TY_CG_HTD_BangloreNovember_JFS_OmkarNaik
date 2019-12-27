<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   
   <form action="./register" method="post">
   
   <fieldset>
   <legend>Employee Details</legend>
   <table>
  <tr>
    <td>Name : </td>
    <td><input type="text" name="name" ></td>
  </tr>
  <tr>
    <td>E-Mail : </td>
    <td><input type="email" name="email"></td>
  </tr>
  <tr>
    <td>Password : </td>
    <td><input type="password" name="password"></td>
  </tr>
</table>
   </fieldset>
   
   <br><br>
   <fieldset>
   <legend>Employee Address 1: </legend>
   <table>
  <tr>
    <td>Address Type : </td>
    <td>
    <select name="addressBeans[0].add_type">
  <option value="P selected">Permanent</option>
  <option value="T">Temporary</option>
</select>

    </td>
  </tr>
  <tr>
    <td>Address1 : </td>
    <td><input type="text" name="addressBeans[0].add1"></td>
  </tr>
  <tr>
    <td>Address2 : </td>
    <td><input type="text" name="addressBeans[0].add2"></td>
  </tr>
</table>
   </fieldset>
   
   <br><br>
   <fieldset>
   <legend>Employee  Address 2 : </legend>
   <table>
  <tr>
    <td>Address Type : </td>
    <td>
    <select name="addressBeans[1].add_type">
  <option value="T selected">Temporary</option>
  <option value="P ">Permanent</option>
</select>
    </td>
  </tr>
  <tr>
    <td>Address1 : </td>
    <td><input type="text" name="addressBeans[1].add1"></td>
  </tr>
  <tr>
    <td>Address2 : </td>
    <td><input type="text" name="addressBeans[1].add2"></td>
  </tr>
</table>
   </fieldset>
   
   <br>
    <input type="submit" value="submit">  
   </form>












</body>
</html>