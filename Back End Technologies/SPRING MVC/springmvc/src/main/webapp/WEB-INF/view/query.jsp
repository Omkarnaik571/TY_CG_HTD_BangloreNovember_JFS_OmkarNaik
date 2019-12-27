<% String name=(String)request.getAttribute("name"); %>
<% int age=Integer.parseInt((String)request.getAttribute("age"));  %>
<html>
<head>
</head>
<body>
<h2 style="color: blue"> Name is ${name}  </h2>
<h2 style="color: green"> Age is ${age}  </h2>
<br>
<%= name %>
<%= age%>
</body>
</html>