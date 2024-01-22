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
<%
String q=(String)request.getAttribute("q");
if(q!=null){
	out.println("<script>alert('Sorry! Quantity cannot be <=zero')</script>");
} 
  
String date=(String)request.getAttribute("date");
if(date!=null){
	out.println("<script>alert('Please enter correct date i.e, today date')</script>");
}
%>
<header style="padding:50px" align="center">
			<h1 align="center">LIBRARY MANAGEMENT SYSTEM</h1>
			<section>
			<b>
			<ul>
				<li><a href="index.html"> HOME </a></li>
				
				<li><a href="aboutus.html"> ABOUT US </a></li>
				<li><a href="contactus.html"> CONTACT US </a></li>
				<li><a href="index.jsp">LOG OUT</a></li>
			</ul>
			</b>
			</section>
			
</header>
<br>
<div>
<h2 align="center">Add Books</h2>
<center>
<form:form action="addBooksFormData" modelAttribute="book">
<table align="center">

<tr>
<td>Book Name:</td>
<td><form:input path="bookName"/></td>
</tr>

<tr>
<td colspan="2" style="font-size:15px"><form:errors path="bookName" cssClass="error"/></td>
<td></td>
</tr>

<!-- <tr> -->
<!-- <td>Book Name:</td> -->
<!-- <td><input type="text" name="bookName" required></td> -->
<!-- </tr> -->

<tr>
<td>Author:</td>
<td><form:input path="bookAuthor"/></td>
</tr>

<tr>
<td colspan="2" style="font-size:15px"><form:errors path="bookAuthor" cssClass="error"/></td>
<td></td>
</tr>

<!-- <tr> -->
<!-- <td>Author:</td> -->
<!-- <td><input type="text" name="bookAuthor" required></td> -->
<!-- </tr> -->

<tr>
<td>Publisher:</td>
<td><form:input path="bookPublisher"/></td>
</tr>

<tr>
<td colspan="2" style="font-size:15px"><form:errors path="bookPublisher" cssClass="error"/></td>
<td></td>
</tr>

<!-- <tr> -->
<!-- <td>Publisher:</td> -->
<!-- <td><input type="text" name="bookPublisher" required></td> -->
<!-- </tr> -->

<!-- <tr> -->
<!-- <td>Quantity:</td> -->
<%-- <td><form:input path="bookQuantity"/></td> --%>
<!-- </tr> -->

<!-- <tr> -->
<%-- <td colspan="2" style="font-size:15px"><form:errors path="bookQuantity" cssClass="error"/></td> --%>
<!-- <td></td> -->
<!-- </tr> -->

<tr>
<td>Quantity:</td>
<td><input type="number" name="bookQuantity" required></td>
</tr>



<tr>
<td>Adding Date:</td>
<td><input type="date" name="bookAddDate" required></td>
</tr>

<tr>
<td></td>
<td align="center"><input type="submit" value="Add Books" style="width:132px"></td>
</tr>
<tr>
<td></td>
<td align="center"><a href="librariansection.jsp"><input type="button" value="Back"></a></td>
</tr>

</table>
</form:form>
</center>

<br>
</div>
<footer style="padding:5px">
			<center><h2>&copy;By Parepally Nikhil</h2></center>
</footer>
</body>
</html>