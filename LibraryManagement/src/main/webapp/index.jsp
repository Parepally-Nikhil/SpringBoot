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
		background-color:pink0;
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
<body align="center">
<header style="padding:50px">
			<h1 align="center">LIBRARY MANAGEMENT SYSTEM</h1>
			<section>
			<ul>
				<li><a href="index.jsp"> HOME </a></li>
				
				<li><a href="aboutus.jsp"> ABOUT US </a></li>
				<li><a href="contactus.jsp"> CONTACT US </a></li>
				<li><a href="index.jsp">LOG OUT</a></li>
			</ul>
			</section>
			
		</header>
<font size="5" color="violet"><marquee bgcolor="black"><b>WELCOME TO LIBRARY MANAGEMENT SYSTEM</b></marquee></font>
<br><br><br><br>
<a href="adminLogin"><input type="button" value="ADMIN LOGIN" style="width:132px"></a><br><br>
<a href="librarianlogin"><input type="button"  value="LIBRARIAN LOGIN"></a>

<footer style="padding:5px">
			<center><h2>&copy;By Parepally Nikhil</h2></center>
</footer>
</body>
</html>