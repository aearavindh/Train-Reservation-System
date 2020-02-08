<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Travel</title>
<link rel="stylesheet" type="text/css" href="CSS/Travel.css" media="screen">
</head>
<body bgcolor=LightGrey>
<table width="100%">
<th id="id">ID</th>
<th>NAME</th>
<th>GENDER</th>
<th>AGE</th>
<th>TRAIN NUMBER</th>
<th>TRAIN NAME</th>
<th>FROM</th>
<th>TO</th>
<th>AMOUNT</th>
<th>DATE OF TRAVEL</th>
<th>DATE OF BOOKING</th>
<th id="status">STATUS</th>
<c:forEach items="${Tickets}" var="ticket">
<tr>
<td>${ticket.bookingId}</td>
<td>${ticket.name}</td>
<td>${ticket.gender}</td>
<td>${ticket.age}</td>
<td>${ticket.tNumber}</td>
<td>${ticket.tName}</td>
<td>${ticket.from}</td>
<td>${ticket.to}</td>
<td>${ticket.amount}</td>
<td>${ticket.dateOfTravel}</td>
<td>${ticket.dateOfBooking}</td>
<td>${ticket.status}</td>
</tr>
</c:forEach>
</table>
</body>
</html>