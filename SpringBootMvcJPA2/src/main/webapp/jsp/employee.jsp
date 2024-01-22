<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="insertemployeedata">
Enter employee id:<input type="number" name="id"><br>
Enter employee name:<input type="text" name="name"><br>
Enter employee designation:<input type="text" name="desig"><br>
Enter employee salary:<input type="number" name="salary"><br>
<input type="submit" value="InsertEmpData">
</form>
<br>

<form action="getemployeedata">
Enter employee id:<input type="number" name="Id"><br>
<input type="submit" value="GetEmpData">
</form>

<form action="deleteemployeedata">
Enter employee id:<input type="number" name="Id"><br>
<input type="submit" value="DeleteEmpData">
</form>
<br>

<form action="updateemployeedata">
Enter employee id:<input type="number" name="Id"><br>
Enter employee name:<input type="text" name="name"><br>
Enter employee designation:<input type="text" name="desig"><br>
Enter employee salary:<input type="number" name="salary"><br>
<input type="submit" value="UpdateEmpData"><br>
</form>
<br>

<form action="selectemployeedata">
<input type="submit" value="DisplayEmpsData"><br>
</form>
<br>

<form action="findbydesig">
Enter employee designation:<input type="text" name="desig"><br>
<input type="submit" value="FindByDesig"><br>
</form>
<br>

<form action="findbyname">
Enter employee name:<input type="text" name="name"><br>
<input type="submit" value="FindByName"><br>
</form>
<br>

<form action="findbyid">
Enter employee id:<input type="number" name="id"><br>
<input type="submit" value="FindById"><br>
</form>
<br>

<form action="findbysalaryg">
Enter employee salary:<input type="number" name="salary"><br>
<input type="submit" value="FindBySalaryGreaterThan"><br>
</form>
<br>

<form action="findbysalaryl">
Enter employee salary:<input type="number" name="salary"><br>
<input type="submit" value="FindBySalaryLessthan"><br>
</form>
<br>

<form action="findbynamesorted">
<input type="submit" value="FindByNameSorted">=>printing data using userdefined method i.e, FindByNameSorted that's why i have used @Query in EmployeeDao
</form>
<br>

<form action="findbynamesortedpredefined">
<input type="submit" value="FindByNameSorted">=>printing data using predefined method i.e, FindByOrderByName that's why i have not used @Query in EmployeeDao
</form>
<br>

<form action="findbydesigorderbyname">
Enter employee designation:<input type="text" name="desig"><br>
<input type="submit" value="FindByDesigOrderByName"><br>
</form>
<br>
</body>
</html>