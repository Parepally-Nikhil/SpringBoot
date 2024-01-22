<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:forEach var="employee" items="${empall}">
${employee.getId()}<br>
${employee.getName()}<br>
${employee.getDesig()}<br>
${employee.getSalary()}<br>

</c:forEach>

<c:forEach var="employee" items="${emp}">
${employee.getId()}<br>
${employee.getName()}<br>
${employee.getDesig()}<br>
${employee.getSalary()}<br>

</c:forEach>
</body>
</html>