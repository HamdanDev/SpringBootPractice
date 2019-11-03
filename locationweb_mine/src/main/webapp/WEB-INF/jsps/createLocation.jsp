<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Create Location</title>
	</head>
	<body>
		<form action="saveLoc" method="post">
		 	<pre>
				Id : 	<input type="text" name="id"/> 
				Code : 	<input type="text" name="code"/> 
				Name : 	<input type="text" name="name"/> 
				Type : 
					City 	<input type="radio" name="type" value = "City"/> 
					Village <input type="radio" name="type" value = "Village"/>
				<input type="submit" value="save"/>
			</pre>
		</form>
	
	${message}
	
	<a href="displayLocations">view all</a>
	
	<a href="generateReport">generate Report</a>
	
	</body>
</html>