<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
body
{
	font-family: Century Gothic, Arial, Times New Roman;
	background-color: white;
	text-align: center; 
	width: 30%;
	margin: auto;
}
.body
{
	background-color: #1a116b;
	color: white;
	padding: 15px;
	margin: 55% auto auto auto;
	border-radius: 25px;
	box-shadow: 10px 10px 5px grey;
}

#in
{
	border-radius:25px;
}

</style>
</head>
<body>
<div class="body">
<form name="forgotPwdForm" action="RegistrationController" method="post">
Enter your Username : <input id="in" type="text" name="uname1"><br><label id="lbl" style="visibility:hidden">Invalid User Name</label><br>
<input type="submit" name="trsButton" value="Submit">
</div>
<%
  if(((String)session.getAttribute("status")).equals("invalid")){
	  out.println("<script>document.getElementById(\"lbl\").style.visibility = \"visible\";");
	  out.println("document.getElementById(\"in\").style.border = \"1px solid red\";</script>");
  }
  session.setAttribute("status", "valid");
%>
<% session.setAttribute("flag", "valid"); %>

</form>
</body>
</html>