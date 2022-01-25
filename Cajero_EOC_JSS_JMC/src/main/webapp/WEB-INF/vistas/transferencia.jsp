<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Transferencias</title>
	<link href="/style.css" rel="stylesheet"/>
</head>
<body>
	<div class="divInput">
		<form action="/cuenta/transferencia" method="post">
			<input type="number" name="cantidad" placeholder="Introduce cantidad">
			<input type="number" name="destino" placeholder="Introduce cuenta destino">
			<button>Enviar</button>
		</form>
	</div>
</body>
</html>