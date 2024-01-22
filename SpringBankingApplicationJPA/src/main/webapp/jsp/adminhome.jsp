<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body align="center">
<%
String a=(String)request.getAttribute("a");
if(a!=null){
	out.println("<script>alert('Approved successfully')</script>");
}
%>

<a href="adminviewprofile">view profile</a>
<br><br>
<a href="adminapprove">Show customers to be approved</a>
</body>
</html>