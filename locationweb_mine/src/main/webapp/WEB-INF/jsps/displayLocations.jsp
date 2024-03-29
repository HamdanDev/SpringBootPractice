<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display Locations</title>
</head>
<body>


	<h3>Locations :</h3>

	<table border="1">
		<tr>
			<th>Id</th>
			<th>Code</th>
			<th>Name</th>
			<th>Type</th>
			<th>Delete</th>
			<th>Update</th>
		</tr>

		<c:forEach items="${locations }" var="location">

			<tr>
				<td>${location.id}</td>
				<td>${location.code}</td>
				<td>${location.name}</td>
				<td>${location.type}</td>
				<th><a href="deleteLocation?id=${location.id}">delete</a></th>
				<th><a href="showUpdate?id=${location.id}">edit</a></th>
			</tr>

		</c:forEach>

	</table>
	${message }
	<a href="showCreate">add location</a>

</body>
</html>