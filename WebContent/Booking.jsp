<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Booking</title>
<style>
td,th{
 text-align:center;
 padding:5px;
}
input{
 border-radius:5px;
 text-align:center;
}
</style>
</head>
<body  bgcolor=#1a116b>
<form target="temp" action="TrainController" method="post">
<table style="width:100%;height:100%;color:white;">
<th>NAME</th>
<th>AGE</th>
<th>GENDER</th>
<th>CLASS</th>
<%
   int n;
   if(request.getParameter("tickets")!=null){
   n = Integer.parseInt(request.getParameter("tickets"));
   session.setAttribute("tick",n);
   }else{
   n = (Integer)session.getAttribute("tick");
   }
   int i;
   for(i=1;i<=n;i++)
   {   
	   out.println("<tr>");
	   out.println("<td>"+i+"  <input type=\"text\" name=\"name"+i+"\"/></td>");
	   out.println("<td><input type=\"text\" name=\"age"+i+"\"/></td>");
	   out.println("<td><input type=\"radio\" name=\"gender"+i+"\" value=\"Male\">Male</input>");
	   out.println("<input type=\"radio\" name=\"gender"+i+"\" value=\"Female\">Female</input>");
	   out.println("<input type=\"radio\" name=\"gender"+i+"\" value=\"Others\">Others</input></td>");
	   out.println("<td><input type=\"radio\" name=\"class"+i+"\" value=\"sleeper\">SLEEPER</input>");
	   out.println("<input type=\"radio\" name=\"class"+i+"\" value=\"ac\">AC</input></td>");
	   out.println("</tr>");
   }
   session.setAttribute("passengers",i-1);
   if(n==0){
	   out.println("<script>document.getElementById('sub').style.visibility = \"hidden\";<script>");
   }
%>
<tr><td colspan="4"><input id="sub" type="submit" value="BOOK" name="trsButton" style="background-color:green;border-radius:6px;border-style:inset;color:white;width:100px;height:20px;"/></td></tr>
</table>
</form>
</body>
</html>