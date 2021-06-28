<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	For Adding a member: <br>
	<form action="addAlien">
		<input type="text" name="aid" placeholder="Enter ID"><br>
		<input type="text" name="aname" placeholder="Enter Name"><br>
		<input type="text" name="tech" placeholder="Enter Language"><br>
		<input type="submit"><br>
	</form>
	<br>
	For Accessing Data <br>
	<form action="getAlien">
		<input type="text" name="aid" placeholder="Enter ID"><br>
		<input type="submit"><br>
	</form>
	<br>
	For Updating Data <br>
	<form action="updateAlien">
		<input type="text" name="aid" placeholder="Enter ID"><br>
		<input type="text" name="aname" placeholder="Enter New Name"><br>
		<input type="text" name="tech" placeholder="Enter New Language"><br>
		<input type="submit"><br>
	</form>
	<br>
</body>
</html>