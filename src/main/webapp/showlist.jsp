<%@ page import="org.bytetech.model.Student"%>
<%@ page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="true"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Student List</title>
<style>
table, th, td {
  border:1px solid black;
}

</style>
</head>
<body>

	<h2>Students List</h2>
	<a href="index.jsp">Go to home</a>
	<br>
	<br>
	<%
		List<Student> students = (List<Student>) request.getAttribute("students");
		if (students != null) {
	%>

	<table style="width: 100%">
		<tr>
			<th>Student Id</th>
			<th>Name</th>
			<th>Class</th>
			<th>Marks</th>
		</tr>
		<% for(Student s : students) { %>
		<tr style="text-align: center;">
			<td><%= s.getId() %></td>
			<td><%= s.getName() %></td>
			<td><%= s.get_class() %></td>
			<td><%= s.getMarks() %></td>
		</tr>
		<% } %>
	</table>

	<%
		} else {
			out.println("<p>No students found.</p>");
		}
	%>

</body>
</html>
