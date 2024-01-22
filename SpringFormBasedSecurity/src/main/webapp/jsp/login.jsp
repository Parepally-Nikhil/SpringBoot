<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
${SPRING_SECURITY_LAST_EXCEPTION.message}
<form action="/signin" method="post">
<table>
<tr>
<td>User :</td>
<td><input type="text" name="username"></td>
</tr>
<tr>
<td>Password :</td>
<td><input type="password" name="password"></td>
</tr>
<tr>
<td><input type="submit" value="submit"></td>
</tr>
</table>
</form>
<a href="signup">signup</a>
</body>
</html>