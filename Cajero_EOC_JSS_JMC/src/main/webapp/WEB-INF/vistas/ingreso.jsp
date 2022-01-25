<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link href="/style.css" rel="stylesheet"/>
	<title>Ingresar dinero</title>
</head>
<body>
	<div class="divInput">
		<form action="/cuenta/ingresar" method="post">
			<input type="number" name="cantidad" placeholder="Introduce cantidad a ingresar">
			<button>Ingresar</button>
		</form>
	</div>
</body>
</html>