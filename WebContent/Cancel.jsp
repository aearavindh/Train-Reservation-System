<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Cancel</title>
	<link rel="stylesheet" type="text/css" href="CSS/Cancel.css" media="screen">
</head>

<body bgcolor=LightGrey>
	<marquee id="marquee">Click on the ticket number to cancel ticket.</marquee>
	<form action="TrainController" onsubmit="return confirm('You are about to cancel this ticket');" method="post" target="temp">
	<table width="100%">
	<th id="Train">T NO</th>
	<th>ID</th>
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
	<c:set var="t" value="${ticket.status}"/>
	<c:set var="tno" value="${ticket.ticketNo}"/>
	<%
	String st = (String)pageContext.getAttribute("t");
	String s = "Booked";
	Integer tno = (Integer)pageContext.getAttribute("tno");
	if(s.equals(st.trim())){
		out.println("<tr bgcolor=\"#ffffff\"><td><input id='cancelTicket' type='submit' name='trsButton' value='"+tno+"'/></td>");
	}else{
		out.println("<tr bgcolor=\"#ebebe0\"><td>"+tno+"</td>");
	}
	%>
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
	</form>
</body>
</html>