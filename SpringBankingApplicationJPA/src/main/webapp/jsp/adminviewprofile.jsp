<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*,com.library.demo.Admin"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:forEach var="admin" items="${adminprofile}">
${admin.getAdminId()}<br>
${admin.getAdminName()}<br>
${admin.getAdminMobile()}<br>
${admin.getAdminEmail()}<br>

</c:forEach>
</body>
</html>