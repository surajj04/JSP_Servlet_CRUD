<%@ page import="org.bytetech.model.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Student Detail</title>
</head>
<body>
	<h1>Student Detail</h1>

	<h3>
		<% 
            Student s1 = (Student) request.getAttribute("student");
            if (s1 != null && s1.getName() != null) {
                out.println(s1);
            } else {
                out.println("Student not found!!!");
            }
        %>
	</h3>
</body>
</html>
