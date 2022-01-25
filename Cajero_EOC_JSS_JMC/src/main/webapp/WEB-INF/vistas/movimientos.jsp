<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link href="/style.css" rel="stylesheet"/>
	<title>Movimientos de la cuenta</title>
</head>
<body>

	<h2>Cuenta: ${sessionScope.cuenta.idCuenta} euros </h2>
	<br>
	<h2>Saldo: ${sessionScope.cuenta.saldo} euros </h2>
	<br>
	<table border="2">
		<tr>
			<th>Cantidad</th>
			<th>Fecha</th>
			<th>Tipo de movimiento</th>
		</tr>
		<tr>
			<c:forEach var="movimiento" items="${requestScope.movimientos}">
			<tr>
				<td>${movimiento.cantidad}</td>
				<td>${movimiento.fecha}</td>
				<td>${movimiento.operacion}</td>
			</tr>
			</c:forEach>
		</tr>
	</table>
		
		<a href="/inicio" id="btnOtras">Otras operaciones</a>
</body>
</html>