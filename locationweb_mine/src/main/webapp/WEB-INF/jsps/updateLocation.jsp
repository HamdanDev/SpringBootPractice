<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>edit Location</title>
</head>
<body>
	<form action="updateLoc" method="post">
		<pre>
			Id: <input type="text" name="id" value="${location.id}" readonly />
			Code: <input type="text" name="code" value="${location.code}" /> Name:
			<input type="text" name="name" value="${location.name}" /> Type : City
			<input type="radio" name="type" value="City"
					${location.type == 'City' ? 'checked' : '' } /> Village <input
					type="radio" name="type" value="Village"
					${location.type == 'Village' ? 'checked' : '' } /> <input
					type="submit" value="save" />
		</pre>
	</form>

	<a href="displayLocations">view all</a>

</body>
</html>