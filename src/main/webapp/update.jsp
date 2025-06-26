<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.jsp.employee.Employee"%>
<%
    Employee e = (Employee) request.getAttribute("employee");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>update</title>
</head>
<body>
	<form action="updateEmployee" method="post">
		<!-- Hidden ID field -->
		<input type="hidden" name="empid" value="<%= e.getEmpId() %>">
		Employee Name :<input type="text" name="empname"><br> <br>
		Employee Age :<input type="number" name="age"><br> <br>
		Employee Salary:<input type="number" name="salary"><br> <br>
		Employee email:<input type="text" name="email"><br> <br>
		Employee password:<input type="password" name="password"><br>
		<br> Employee address : <label>House Number:</label> <input
			type="text" name="houseNumber"><br> <br> <label>Street:</label>
		<input type="text" name="street"><br> <br> <label>Pin
			code:</label> <input type="number" name="pincode"><br> <br>
		<label>District:</label> <input type="text" name="district"><br>
		<br> <label>State:</label> <input type="text" name="state"><br>
		<br> <label>Country:</label> <input type="text" name="country"><br>
		<br> <input type="submit" value="Submit">
	</form>
</body>
</html>