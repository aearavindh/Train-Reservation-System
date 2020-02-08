<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="CSS/CngPwd.css" media="screen">
	
	<script>
	function validate()
	{
		var pass=document.getElementById("pass1").value;
		var pass1=/^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,11}$/;
		if(!pass.match(pass1))
			{
			alert("enter valid password");
			return false;
			}
		var cpass=document.getElementById("pass2").value;
		if(!pass.match(cpass))
			{
			alert("New password and confirm password should be same");
			return false;
			}
	}
	</script>
</head>

<body>
	<form id="body" action="RegistrationController" target="_parent" method="post" onsubmit="return validate()">
	<table>
	<tr><td>Enter New Password : </td><td><input type="password" name="pass1" id="pass1"></td></tr>
	<tr><td>Confirm Password : </td><td><input type="password" name="pass2" id="pass2"></td></tr>
	<tr><td><input id="cp" type="Submit" value="change password" name="trsButton"></td></tr>
	</table>
	</form>
</body>
</html>