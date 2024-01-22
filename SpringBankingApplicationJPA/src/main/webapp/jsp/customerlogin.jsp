<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String b=(String)request.getAttribute("b");
if(b!=null){
	out.println("<script>alert('Password changed successfully')</script>");
}
%>

<form action="customerloginform">
Enter customer id:<input type="text" name="customerId"><br>
Enter password:<input type="password" name="customerPassword"><br>
<input type="submit" name="Login"><br><br>
Don't have account?<a href="customersignup">apply here</a>
</form>

</body>
</html>