<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.example.demo.Employee" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
Employee e=(Employee)request.getAttribute("empobj");
%>
<%=""+e.getId()+" "+e.getName()+" "+e.getDesig()+" "+e.getSalary() %>

${empobj.id}
${empobj.name}
${empobj.desig}
${empobj.salary}
</body>
</html>