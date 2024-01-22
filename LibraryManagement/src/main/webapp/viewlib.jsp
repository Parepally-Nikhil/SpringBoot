<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
	
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
		<center>
		<table border="1" bgcolor="black" style="border-color:white">
		<tr>
		<td style="color:white">Librarian Id</td>
		<td style="color:white">Librarian Name</td>
		<td style="color:white">Librarian Email</td>
		<td style="color:white">Librarian Address</td>
		<td style="color:white">Librarian Gender</td>
		<td style="color:white">Librarian Contactno</td>
		</tr>
		<c:forEach var="librarian" items="${viewlib}">
			<tr>
			<td>${librarian.librarianId}</td>
			<td>${librarian.librarianName}</td>
			<td>${librarian.librarianEmail}</td>
			<td>${librarian.librarianAddress}</td>
			<td>${librarian.librarianGender}</td>
			<td>${librarian.librarianContactno}</td>
			</tr>
		</c:forEach>
		</table>
		<tr>

<a href="adminsection.jsp"><input type="button" value="Back"></a>

		</center>
		<footer style="padding:5px">
			<center><h2>&copy;By Parepally Nikhil</h2></center>
		</footer>		
</body>
</html>