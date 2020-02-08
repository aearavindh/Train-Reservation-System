<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title></title>
		<link rel="stylesheet" type="text/css" href="CSS/Availability.css" media="screen">
	</head>
	
	<body bgcolor=LightGrey>
		<form target="temp" action="TrainController" method="post">
		<table width="100%">
				<th>TRAIN NUMBER</th>
				<th>TRAIN NAME</th>
				<th>ARRIVAL TIME</th>
				<th>DEPARTURE TIME</th>
				<th>SLEEPER CLASS</th>
				<th>AC</th>
				<c:forEach items="${TrainArray}" var="train">
				<tr>
				<td><input id="checkTrain" type="submit" name="trsButton" value=${train.tNumber} /></td>
				<td>${train.tName}</td>
				<td>${train.arrivalTime}</td>
				<td>${train.departureTime}</td>
				<td>${train.sleeperFare}</td>
				<td>${train.acFare}</td>
				</tr>
				</c:forEach>
		</table>
		</form>
	</body>
</html>