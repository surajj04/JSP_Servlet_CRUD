<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Addition Success</title>
</head>
<body>
	<%
		String message = (String) request.getAttribute("message");
	%>
	<h2><%=message %></h2>
	<a href="index.jsp">Go to home</a>
</body>
</html>
