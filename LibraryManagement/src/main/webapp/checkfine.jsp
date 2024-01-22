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
	<h2 align="center">Check Book Fine</h2>
	<center>
		<form action="checkFineFormData" method="post">
			<table align="center">

				<tr>
					<td>Book Id:</td>
					<td><input type="text" name="bid" required></td>
				</tr>
				<tr>
					<td>Student Id:</td>
					<td><input type="text" name="sid" required></td>
				</tr>
				<tr>
					<td>Return Date:</td>
					<td><input type="date" name="rdate" required></td>
				</tr>

				<tr>
					<td></td>
					<td align="center"><input type="submit" value="Check"
						style="width: 132px"></td>
		
				</tr>
				<tr>
					<td></td>

					<td align="center"><a href="returnbook.jsp"><input
							type="button" value="Back"></a></td>
				</tr>

			</table>

		</form>
		</center>
	</div>
	<center style="position:absolute;left:11%;bottom:20%">
		<table border="1" bgcolor="black" style="border-color:white">
		<tr>
		<td style="color:white">Issue Id</td>
		<td style="color:white">Book Id</td>
		<td style="color:white">Student Id</td>
		<td style="color:white">Student Name</td>
		<td style="color:white">Student Contact</td>
		<td style="color:white">Issued Date</td>
		<td style="color:white">Due Date</td>
		<td style="color:white">Fine</td>
		<td style="color:white">Librarian Id</td>
		</tr>
		
			<tr>
			<td>${issueBook.id}</td>
			<td>${issueBook.book.bookId}</td>
			<td>${issueBook.student.studentId}</td> 
			<td>${issueBook.student.studentName}</td>
			<td>${issueBook.student.studentContact}</td>
			<td>${issueBook.issuedDate}</td>
			<td>${issueBook.dueDate}</td>
			<td>${issueBook.fine}</td>
			<td>${issueBook.librarian.librarianId}</td>
			</tr>
		
		</table>

		</center>
		
	<footer style="padding:5px">
			<center><h2>&copy;By Parepally Nikhil</h2></center>
	</footer>
</body>
</html>