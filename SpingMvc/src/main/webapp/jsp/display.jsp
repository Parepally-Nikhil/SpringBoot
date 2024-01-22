<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.*,com.example.demo.Address" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% 
List<Address> al=(List<Address>)request.getAttribute("show");

for(int i=0;i<al.size();i++){
	out.println(al.get(i).getCity()+" "+al.get(i).getState());
}
%>
</body>
</html>