<%@ page import="org.bytetech.model.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="true"%>
<html>
<head>
<title>Add Student</title>
</head>
<body>
	<h1>Add Student</h1>
	
	<form action="addStudent" method="get">
		<input type="text" name="name" placeholder="Enter name"> <br> <br>
		<input type="text" name="class" placeholder="Enter class"> <br> <br>
		<input type="number" name="marks" placeholder="Enter marks"> <br> <br>
		<input type="submit"> <br> <br>
	</form>
	
	
</body>
</html>
