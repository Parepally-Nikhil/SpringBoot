<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="insertstudentdata">
Enter student id:<input type="text" name="studId"><br>
Enter student name:<input type="text" name="studName"><br>
<input type="submit" value="InsertData">
</form>

<form action="getstudentdata">
Enter student id:<input type="text" name="studId"><br>
<input type="submit" value="GetData">
</form>

<form action="deletestudentdata">
Enter student id:<input type="text" name="studId"><br>
<input type="submit" value="DeleteData">
</form>

<form action="updatestudentdata">
Enter student id:<input type="text" name="studId"><br>
Enter student name:<input type="text" name="studName"><br>
<input type="submit" value="UpdateData">
</form>

<form action="selectstudentdata">
<input type="submit" value="DisplayData">
</form>

</body>
</html>