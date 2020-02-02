<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<div>
	<form:form action="save" method="post" modelAttribute="listContact">
		<table>
		<form:hidden path="id"/>
		<tr>
			<td><label>Name</label></td>
			<td><form:input type="text" path="name"/></td>
		</tr>
		<tr>
			<td><label>Email</label></td>
			<td><form:input type="text" path="email"/></td>
		</tr>
		<tr>
			<td><label>Address</label></td>
			<td><form:input type="text" path="address"/></td>
		</tr>
		<tr>
			<td><label>Phone</label></td>
			<td><form:input type="text" path="phone"/></td>
		</tr>
		<tr>
			<td> <input type="submit" value="Save"/></td>
		</tr>
		</table>
	</form:form>
	</div>
	
</body>
</html>