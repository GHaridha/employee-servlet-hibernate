<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="java.util.List, com.jsp.employee.Employee, com.jsp.employee.Address"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Details</title>
</head>
<body>
	<%
	List<Employee> resultList = (List<Employee>) request.getAttribute("employeeList");
	if (resultList != null && !resultList.isEmpty()) {
		for (Employee e : resultList) {
	%>
	<div style="margin-bottom: 20px;">
		<strong>Name:</strong>
		<%=e.getName()%><br>
		<br> <strong>Age: </strong><%=e.getAge()%><br>
		<br> <strong>Salary: </strong><%=e.getSalary()%><br>
		<br> <strong>Email: </strong><%=e.getEmail()%><br>
		<br> <label>House Number:</label> <%=e.getAddress().getHouseNumber() %><br>
		<br> <label>Street:</label><%=e.getAddress().getStreet()%><br> 
		<br> <label>Pin code:</label><%=e.getAddress().getPincode() %><br> 
		<br><label>District:</label><%=e.getAddress().getDistrict() %><br>
		<br> <label>State:</label> <%=e.getAddress().getState() %><br>
		<br> <label>Country:</label> <%=e.getAddress().getCountry() %><br>
	</div>
	<%
	}
	} else {
	%>
	<p>No Employee records found</p>
	<%
	}
	%>
</body>
</html>