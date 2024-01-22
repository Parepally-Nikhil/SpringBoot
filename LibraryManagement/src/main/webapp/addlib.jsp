<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
		
		.error{color:red}
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

<br>
<div>
<h2 align="center">Add Librarian</h2>
<center>
<form:form action="addLibrarianFormData" modelAttribute="lib">
<table>

<tr>
<td>Name:</td>
<td><form:input path="librarianName"/></td>
</tr>

<tr>
<td colspan="2" style="font-size:15px"><form:errors path="librarianName" cssClass="error"/></td>
<td></td>
</tr>

<!-- <tr> -->
<!-- <td>Name:</td> -->
<!-- <td><input type="text" name="librarianName" required></td> -->
<!-- </tr> -->

<tr>
<td>Password:</td>
<td><form:password path="librarianPassword"/></td>
</tr>

<tr>
<td colspan="2" style="font-size:15px"><form:errors path="librarianPassword" cssClass="error"/></td>
<td></td>
</tr>

<!-- <tr> -->
<!-- <td>Password:</td> -->
<!-- <td><input type="password" name="librarianPassword" required></td> -->
<!-- </tr> -->

<tr>
<td>Email:</td>
<td><form:input path="librarianEmail" placeholder="use only lower alphabets"/></td>
</tr>

<tr>
<td colspan="2" style="font-size:15px"><form:errors path="librarianEmail" cssClass="error"/></td>
<td></td>
</tr>

<!-- <tr> -->
<!-- <td>Email:</td> -->
<!-- <td><input type="text" name="librarianEmail" required></td> -->
<!-- </tr> -->

<tr>
<td>Address:</td>
<td><form:input path="librarianAddress"/></td>
</tr>

<tr>
<td colspan="2" style="font-size:15px"><form:errors path="librarianAddress" cssClass="error"/></td>
<td></td>
</tr>

<!-- <tr> -->
<!-- <td>Address:</td> -->
<!-- <td><input type="text" name="librarianAddress" required></td> -->
<!-- </tr> -->

<tr>
<td>Gender:</td>
<td><form:radiobutton path="librarianGender" value="Male"/>male<form:radiobutton path="librarianGender" value="Female"/>female</td>
</tr>

<tr>
<td colspan="2" style="font-size:15px"><form:errors path="librarianGender" cssClass="error"/></td>
<td></td>
</tr>

<!-- <tr> -->
<!-- <td>Gender:</td> -->
<!-- <td><input type="radio" name="librarianGender" value="Male" required>male<input type="radio" name="librarianGender" value="Female" required>female</td> -->
<!-- </tr> -->

<tr>
<td>Contact No:</td>
<td><form:input path="librarianContactno"/></td>
</tr>

<tr>
<td colspan="2" style="font-size:15px"><form:errors path="librarianContactno" cssClass="error"/></td>
<td></td>
</tr>

<!-- <tr> -->
<!-- <td>Contact No:</td> -->
<!-- <td><input type="text" name="librarianContactno" required></td> -->
<!-- </tr> -->

<tr>
<td></td>
<td><input type="submit" value="Add Librarian" style="position:relative;left:17px;width:132px"></td>
</tr>

<tr>
<td></td>

<td><a href="adminsection.jsp"><input type="button" value="Back" style="position:relative;left:60px"></a></td>
</tr>

</table>

</form:form>
</center>
</div>
<footer style="padding:5px">
			<center><h2>&copy;By Parepally Nikhil</h2></center>
</footer>
</body>
</html>