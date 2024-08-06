<%@ page import="org.bytetech.model.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Remove Student</title>
</head>
<body>
	<h1>Remove Student</h1>
	
	<form action="removeStudent" method="post">
		<input type="text" name="id" placeholder="Enter Id">
		<input type="submit">
	</form>
	
</body>
</html>
