<%@ page language="java" import="java.util.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title></title>
		<link rel="stylesheet" type="text/css" href="CSS/datePlace.css" media="screen">
		
		<script type="text/javascript">
			function date(){
			var today = new Date();
			var dd = today.getDate();
			var mm = today.getMonth()+1;
			var yyyy = today.getFullYear();
			if(dd<10){
				dd='0'+dd;
			}
			if(mm<10){
				mm='0'+mm;
			}
			today = yyyy+'-'+mm+'-'+dd;
			document.getElementById("dateoftravel").setAttribute("min",today);
			}
		</script>
		
	</head>

	<body>
		<form  target="temp" action="TrainController" method="post">
			<table style="align:center;width:100%;height:100%;">
				<tr>
				<td><h2 id="h2">FROM</h2></td>
				<td class="tdata">
				<select name="from" class="in">
				<option value="MAS">MGR Chennai</option>
				<option value="KPD">Katpadi</option>
				<option value="KPN">Kuppam</option>
				<option value="BNC">Bangalore Cantt.</option>
				<option value="KSR">KSR Bengaluru</option>
				<option value="JTJ">Jolarpettai</option>
				<option value="KJM">Krishnarajapuram</option>
				<option value="BNCE">Bangalore East</option>
				<option value="WFD">White Field</option>
				<option value="BWT">Bangarapet</option>
				<option value="WJR">Walajah Road</option>
				<option value="SHU">Sholinghur</option>
				<option value="PER">Perambur</option>
				<option value="AB">Ambur</option>
				<option value="AJJ">Arakkonam</option>
				<option value="RMGM">Ramanagaram</option>
				<option value="MLO">Malor</option>
				<option value="GYM">Gudiyattam</option>
				<option value="MCN">Mukundarayapuram</option>
				</select>
				</td>
				</tr>
				<tr>
				<td><h2 id="h2">TO</h2></td>
				<td class="tdata">
				<select name="to" class="in">
				<option value="MAS">MGR Chennai</option>
				<option value="KPD">Katpadi</option>
				<option value="KPN">Kuppam</option>
				<option value="BNC">Bangalore Cantt.</option>
				<option value="KSR">KSR Bengaluru</option>
				<option value="JTJ">Jolarpettai</option>
				<option value="KJM">Krishnarajapuram</option>
				<option value="BNCE">Bangalore East</option>
				<option value="WFD">White Field</option>
				<option value="BWT">Bangarapet</option>
				<option value="WJR">Walajah Road</option>
				<option value="SHU">Sholinghur</option>
				<option value="PER">Perambur</option>
				<option value="AB">Ambur</option>
				<option value="AJJ">Arakkonam</option>
				<option value="RMGM">Ramanagaram</option>
				<option value="MLO">Malor</option>
				<option value="GYM">Gudiyattam</option>
				<option value="MCN">Mukundarayapuram</option>
				</select>
				</td>
				</tr>
				<tr>
				<td><h2 id="h2">DATE</h2></td>
				<td class="tdata">
				<input type="date" name="date" id="dateoftravel" max="2019-08-31" style="border-radius:6px;width:140px;height:25px;border-style:groove;"></input>
				</td>
				</tr>
				<tr><td colspan="2"><input id ="in" type="submit" name="trsButton" value="CHECK AVAILABILITY"></td></tr>
			</table>
			
			<script type="text/javascript">
				date();
			</script>
		</form>
	</body>
</html>