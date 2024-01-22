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
/* String d=(String)request.getAttribute("d");
if(d!=null){
	out.println("<script>alert('Please enter valid librarian id')</script>");
}  */

String ex=(String)request.getAttribute("ex");
if(ex!=null){
	out.println("<script>alert('Sorry! cannot delete librarian as he issued some books to students')</script>");
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
<h2 align="center">Delete Librarian</h2>
<center>
<form action="deleteLibrarianFormData">
<table align="center">
<tr>
<td>Enter Lid:</td>
<td><input type="text" name="librarianId"></td>
</tr>
<tr>
<td></td>
<td align="center"><input type="submit" value="Delete" style="width:100px"></td>
</tr>
<tr>
<td></td>
<td align="center"><a href="adminsection.jsp"><input type="button" value="Back"></a></td>
</tr>
</table>

</form>
</center>
<%
String d=(String)request.getAttribute("d");
if(d!=null){
	
	//out.println("<script>alert(a);</script>");
	out.println("<p style='color:red;font-size:25px;position:relative;left:160px'>"+d+"</p>");
}
%>
<br>
</div>
<footer style="padding:5px">
			<center><h2>&copy;By Parepally Nikhil</h2></center>
</footer>
</body>
</html>