<%@ page import="org.bytetech.model.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Update Student</title>
</head>
<body>
	<h1>Update Student</h1>
	
	<form action=updateStudent method="post">
		<input type="text" name="id" placeholder="Enter Id" > <br> <br>
		<input type="text" name="name" placeholder="Enter Name"  > <br> <br>
		<input type="text" name="class" placeholder="Enter Class" > <br> <br>
		<input type="number" name="marks" placeholder="Enter Marks" > <br> <br>
		<input type="submit" value="Update"> <br> <br>
	</form>
	
</body>
</html>
