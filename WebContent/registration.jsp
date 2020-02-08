<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
	<title>Registration page</title>
	<link rel="stylesheet" type="text/css" href="CSS/register.css" media="screen">
	<script>
	function validationForm()
	{
		var pass=document.getElementById("pass").value;
		var pass1=/^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,11}$/;
		if(!pass.match(pass1))
			{
			alert("enter valid password");
			return false;
			}
		var cpass=document.getElementById("cpass").value;
		if(!pass.match(cpass))
			{
			alert("passwords should be same");
			return false;
			}
		var email=document.getElementById("email").value;
		var email1="^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$";
		if(!email.match(email1))
			{
			alert("enter valid emailid");
			return false;
			}
		var num=document.getElementById("phno").value;
		var num1="[0-9]{10}";
		if(!num.match(num1))
			{
			alert("enter valid phone number");
			return false;
			}
		}
	</script>
</head>

<body>

	<header><h1>Register Here</h1></header>
	<form name="registerform" action="RegistrationController" target="_parent" onsubmit="return validationForm()" method="post">
	
	<section>
	<table>
		<tr><td>User ID</td>
		<td><input type="text" name="uname" id="uname" required></td>
		</tr>
		
		<tr><td>Password</td>
		<td><input type="password" name="pass" id="pass" title="pwd should atleast contain 1 Uppercase,1 Lowercase,1 Number,1 Specialcharacter and minimum 8 characters" required></td>
		</tr>
		
		<tr><td>Confirm Password</td>
		<td><input type="password" name="cpass" id="cpass" required></td>
		</tr>
		
		<tr><td>First Name</td>
		<td><input type="text" name="fname" id="fname" required></td>
		</tr>
		
		<tr><td>Last name</td>
		<td><input type="text" name="lname" id="lname" required></td>
		</tr>
		
		<tr><td>Gender</td>
		<td><input checked="checked" name="gender" id="gender" type="radio" value="male" /> Male <input name="gender" type="radio" value="female" /> Female <input name="gender" type="radio" value="other" /> Other</td></tr>
		
		<tr><td>Date of birth</td>
		<td><input type="date" name="date" id="date" placeholder="yyyy-mm-dd" required pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}"></td>
		</tr>
		<tr><td>Email</td>
		<td><input type="text" name="email" id="email" required></td>
		</tr>
		<tr><td>Mobile Number</td>
		<td><input type="text" name="mobno" id="phno" required></td>
		</tr>
		
		<tr><td>Choose a security question</td>
		<td><select name="securityQues" id="securityQues" required>
		<option></option>
		<option value="m">What is your mother's maiden name?</option>
		<option value="p">What is your pet name?</option>
		<option value="c">What is your favourite colour?</option>
		</select>
		</td></tr>
		<tr><td>Enter answer for the above question</td><td><input type="text" id="securityAns" name="securityAns" required></td></tr>
		
		<tr><td>Nationality</td>
		<td><input type="text" name="nationality" id="nationality" required></td>
		</tr>
		
		<tr><td>Address</td>
		<td><textarea rows="4" cols="50"  name="address" id="address" required></textarea></td>
		</tr>
		
	</table>
	</section>
	
	<footer><input type="submit"  value="Sign Up" name="trsButton" ></footer>
</form>
</body>
</html>