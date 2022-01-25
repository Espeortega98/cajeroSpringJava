<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Inicio</title>
	<link href="/style.css" rel="stylesheet"/>
</head>
<body>
	<h2 id="h2Login">Accede a tu cuenta</h2>
	<div class="divInput">
		<form action="/inicio" method="post">
			<input type="number" name="idCuenta" placeholder="Introduce nº cuenta">
			<button>Entrar</button>
		</form>
	</div>
</body>
</html>