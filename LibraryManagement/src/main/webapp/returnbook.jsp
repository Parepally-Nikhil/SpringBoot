<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css">
<style>
*{
			padding:0px;
			margin:0px;
		}
		ul{
			list-style-type:none;
			
			
		}
		ul li a:hover{
		
		font-size:30px;
		background-color:green;
		color:white;
		}
		ul li a{
			display:block;
			text-decoration:none;
			text-align:center;
			color:pink;
		}

		ul li{
		width:200px;
		height:50;
		background-color:;
		
		float:left;
		line-height:50px;		
		font-size:20px;
		}
		ul li ul li{
			display:none;
		}
		ul li:hover ul li{
			display:block;
		}
</style>
</head>
<body>
<%
String k=(String)request.getAttribute("k");
if(k!=null){
	out.println("<script>alert('Please enter valid  credentials')</script>");
} 
String go=(String)request.getAttribute("go");
if(go!=null){
	out.println("<script>alert('Kindly first check fine and then return')</script>");
}
%>
<header style="padding:50px">
			<h1 align="center">LIBRARY MANAGEMENT SYSTEM</h1>
			<section>
			<b><ul>
				<li><a href="index.html"> HOME </a></li>
				
				<li><a href="aboutus.html"> ABOUT US </a></li>
				<li><a href="contactus.html"> CONTACT US </a></li>
				<li><a href="index.jsp">LOG OUT</a></li>
			</ul></b>
			</section>
			
		</header>
	<br>
	<div>
	<h2 align="center">Return Book</h2>
	<center>
		<form action="returnBookFormData">
			<table align="center">

				<tr>
					<td>Book Id:</td>
					<td><input type="text" name="bid" required></td>
				</tr>
				<tr>
					<td>Student Id:</td>
					<td><input type="text" name="sid" required></td>
				</tr>
<!-- 				<tr> -->
<!-- 					<td>Return Date:</td> -->
<!-- 					<td><input type="date" name="rdate" required></td> -->
<!-- 				</tr> -->

				<tr>
					<td></td>
					<td align="center"><input type="submit" value="Return Book"
						style="width: 132px"></td>
				</tr>
				<tr>
					<td style="color:red">Want to check fine?</td>
					<td align="center"><a href="checkFine" ><input type="button" value="Check Fine" style="width: 132px;background-color:red"></a></td>
					
				</tr>
				<tr>
					<td></td>
					<td align="center"><a href="librariansection.jsp"><input
							type="button" value="Back"></a></td>
				</tr>
			</table>

		</form>
		</center>
	</div>
	<footer style="padding:5px">
			<center><h2>&copy;By Parepally Nikhil</h2></center>
	</footer>
</body>
</html>