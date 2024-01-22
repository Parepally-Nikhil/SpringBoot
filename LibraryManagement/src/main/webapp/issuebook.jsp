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
String e=(String)request.getAttribute("e");
if(e!=null){
	out.println("<script>alert('Book does not exist in the library')</script>");
}

String f=(String)request.getAttribute("f");
if(f!=null){
	out.println("<script>alert('Please enter valid student id')</script>");
}

String h=(String)request.getAttribute("h");
if(h!=null){
	out.println("<script>alert('Sorry! unable to issue book the QUANTITY is 0')</script>");
}

String date=(String)request.getAttribute("date");
if(date!=null){
	out.println("<script>alert('Please enter correct date i.e, today date')</script>");
}

String notallowed=(String)request.getAttribute("notallowed");
if(notallowed!=null){
	out.println("<script>alert('book already taken by the entered studentid')</script>");
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
<h2 align="center">Issue Book</h2>
<center>
<form action="issueBookFormData" method="post">
<table align="center">

<tr>
<td>Book Id:</td>
<td><input type="text" name="bId" required></td>
</tr>
<tr>
<td>Student Id:</td>
<td><input type="text" name="sId" required></td>
</tr>
<tr>
<td>Issuing Date:</td>
<td><input type="date" name="iDate" required></td>
</tr>
<tr>
<td></td>
<td align="center"><input type="submit" value="Issue Book" style="width:132px"></td>
</tr>
<tr>
<td></td>
<td align="center"><a href="librariansection.jsp"><input type="button" value="Back"></a></td>
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