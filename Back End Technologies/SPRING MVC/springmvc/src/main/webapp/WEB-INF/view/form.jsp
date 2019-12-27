<html>
<head>
</head>
<body>

<h2> ${name} </h2>
<h2> ${email} </h2>
<h2> ${password} </h2>
<h2> ${gender} </h2>

<fieldset>
<legend><h1>Enter Form Data</h1></legend>
<form action="./form" method="post" >

  <table>
  <tr>
    <td>Name:  </td>
    <td><input type="text" name="name"></td>
  </tr>
  <tr>
    <td>Email:  </td>
    <td><input type="email" name="email"></td>
  </tr>
  <tr>
    <td>Password:  </td>
    <td><input type="password" name="password"></td>
  </tr>
  <tr>
    <td>Gender:  </td>
    <td><input type="radio" name="gender" value="M">Male </td>
    <td><input type="radio" name="gender" value="F">FeMale </td>
  </tr>
  <tr>
    <td><button type="reset" value="reset">Reset</button></td>
    <td><button type="submit" value="submit">Submit</button></td>
  </tr>
</table>

</form>

</fieldset>


</body>
</html>