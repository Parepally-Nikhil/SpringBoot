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
<body align="center">
<%
String b=(String)request.getAttribute("b");
if(b!=null){
	out.println("<script>alert('Books added successfully')</script>");
}

String c=(String)request.getAttribute("c");
if(c!=null){
	out.println("<script>alert('Book deleted successfully')</script>");
}

String g=(String)request.getAttribute("g");
if(g!=null){
	out.println("<script>alert('Book issued successfully')</script>");
}

String j=(String)request.getAttribute("j");
if(j!=null){
	out.println("<script>alert('Book returned successfully')</script>");
}

String k=(String)request.getAttribute("k");
if(k!=null){
	out.println("<script>alert('Please enter valid credentials')</script>");
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
<h2 style="background-color:black;color:pink">Librarian Section</h2>

<a href="addBooks"><input type="button" value="Add Books" style="width:132px"></a><br><br>
<a href="deleteBook"><input type="button" value="Delete Book" style="width:132px"></a><br><br>
<a href="viewBooks"><input type="button"  value="View Books" style="width:132px"></a><br><br>
<a href="issueBook"><input type="button" value="Issue Book" style="width:132px"></a><br><br>
<a href="viewIssuedBooks"><input type="button" value="View Issued Books" style="width:132px"></a><br><br>
<a href="returnBook"><input type="button"  value="Return Book" style="width:132px"></a><br><br>
<a href="libLogout"><input type="button"  value="Logout" style="width:132px"></a><br><br>
<footer style="padding:5px">
			<center><h2>&copy;By Parepally Nikhil</h2></center>
</footer>
</body>
</html>