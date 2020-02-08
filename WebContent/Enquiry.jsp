<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Train Enquiry</title>
<%  String st = (String)session.getAttribute("username");
    if(st==null){
	response.sendRedirect("LandingPage.jsp");
	}
%>
	</head>
	
	<frameset rows="15%,*,13%" frameborder="no">
		<frame src="Title.jsp" />
			<frameset cols="30%,*" frameborder="no">
				<frameset rows="20%,*" frameborder="no">
					<frame src="Button.jsp"/>
					<frame src="DateAndPlace.jsp" name="temp1"/>
				</frameset>
				<frame src="Welcome.jsp" name="temp"/>
			</frameset>
		<frame src="Footer.jsp"/>
	</frameset>
	
	<body>
	</body>
</html>