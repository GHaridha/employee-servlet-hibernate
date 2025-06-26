<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.jsp.employee.Employee,com.jsp.employee.Address"%>
<%
    Employee e = (Employee) request.getAttribute("employee");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete</title>
</head>
<body>
	<form action="deleteEmployee" method="get">
		<input type="hidden" name="empid" value="<%= e.getEmpId() %>">
		Confirm deletion : <input type="submit" value="Confirm"><br>
	</form>
</body>
</html>