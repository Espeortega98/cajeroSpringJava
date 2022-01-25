<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Extraer dinero</title>
	<link href="/style.css" rel="stylesheet"/>
</head>
<body>
	<div class="divInput">
		<form action="/cuenta/extraer" method="post">
			<input type="number" name="cantidad" placeholder="Introduce cantidad">
			<button>Extraer</button>
		</form>
	</div>

</body>
</html>