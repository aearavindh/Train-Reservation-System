<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
	<title>Change Password</title>
	<link rel="stylesheet" type="text/css" href="CSS/changepwd.css" media="all">
	<script>
	function validate()
	{
		var pass=document.getElementById("Npass").value;
		var pass1=/^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,11}$/;
		if(!pass.match(pass1))
			{
			alert("enter valid password");
			return false;
			}
		var cpass=document.getElementById("Conpass").value;
		if(!pass.match(cpass))
			{
			alert("New password and confirm password should be same");
			return false;
			}
	
	}</script>
</head>

<body>
	<form name="changeForm" action="RegistrationController" onsubmit="return validate()" method="post">
		<table>
			<tr><td>Username</td><td><input type="text" name="uname" id="uname" required></td></tr>
			<tr><td>Old Password</td><td><input type="password" name="Opass" id="Opass" required></td></tr>
			<tr><td>New Password</td><td><input type="password" name="Npass" id="Npass" required></td></tr>
			<tr><td>Confirm Password</td><td><input type="password" name="Conpass" id="Conpass" required></td></tr>
			<tr><td><input type="submit" id="cp" value="submit" name="trsButton"></td></tr>
		</table>
	</form>
	<footer>Copyright © Wipro Technologies Limited</footer>
</body>
</html>