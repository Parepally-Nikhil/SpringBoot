<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Insert
<form action="insertData">
Enter city:<input type="text" name="city">
Enter state:<input type="text" name="state">
<input type="submit" value="Submit">
</form>

Update
<form action="updateData">
Enter city:<input type="text" name="city">
Enter state:<input type="text" name="state">
<input type="submit" value="Submit">
</form>

Delete
<form action="deleteData">
Enter city:<input type="text" name="city">
<input type="submit" value="Submit">
</form>

<a href="selectData">Display data</a>
</body>
</html>