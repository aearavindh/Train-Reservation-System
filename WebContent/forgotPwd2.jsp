<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>

<style type="text/css">
body
{
	font-family: Century Gothic, Arial, Times New Roman;
	background-color: white;
	text-align: center; 
	width: 30%;
	margin: auto;
}
#body
{
	background-color: #1a116b;
	color: white;
	padding: 15px;
	margin: 55% auto auto auto;
	border-radius: 25px;
	box-shadow: 10px 10px 5px grey;
}

#securityAns
{
	border-radius:25px;
}

</style>


</head>

<body>
<form id="body" name="forgot2" action="RegistrationController" method="post">
<c:choose>
<c:when test="${RegistrationBean.securityQues=='m'}">
What is your mother's maiden name.
</c:when>
<c:when test="${RegistrationBean.securityQues=='p'}">
What is your pet name.
</c:when>
<c:when test="${RegistrationBean.securityQues=='f'}">
What is your favourite color.
</c:when>
</c:choose>
<br><br>
Enter your Answer : <input type="text" name="securityAns" id="securityAns"><label id="lbl" style="visibility:hidden"></br></br>Wrong Answer</label><br>
<input type="submit" value="Submit Answer" name="trsButton">
<%
  if(((String)session.getAttribute("flag")).equals("invalid")){
	  out.println("<script>document.getElementById(\"lbl\").style.visibility = \"visible\";");
	  out.println("document.getElementById(\"in\").style.border = \"1px solid red\";</script>");
  }
  session.setAttribute("flag", "valid");
%>

</form>
</body>
</html>