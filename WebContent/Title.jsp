<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title></title>
		
		<script type="text/javascript">
			 function toggleMenu(){
				 var x = document.getElementById('sidebar');
				 if(x.style.left=="-25%")
					 x.style.left="0%";
				 else
				     x.style.left="-25%";
			 }
		</script>
		
		<link rel="stylesheet" type="text/css" href="CSS/title.css" media="screen" />
		
	</head>
	
	<form action="TrainController" method="post" target="_parent">
		<div id="sidebar">
		  <div class="toggle-btn" onclick="toggleMenu()">
		  <img src="Images/whiteIcon.png"/>
		  </div>
		  <ul>
		  <li id="Name">${username}</li>
		  <li><a href="changepwd.jsp" target="temp">Change Password</a></li>
		  <li><input id="logout" type="submit" value="LOGOUT" name="trsButton"/></li>
		  </ul>
		</div>
	</form>
	<body>
	<div id="title">
		<h1>TRAIN RESERVATION SYSTEM</h1>
		<h3>INDIAN RAILWAYS</h3>
	</div>
	</body>
	
</html>