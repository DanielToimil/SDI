<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="comprobarNavegacion.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<title>TaskManager - Listado de Tareas</title>
</head>
<body>
	<table border="1" align="center">
			<tr>
				<th>ID</th>
				<th>Comentario</th>
				<th>Planeado</th>
			</tr>
		<c:forEach var="entry" items="${listaTareasInbox}" varStatus="i">
			<tr id="item_${i.index}">
				<td>${entry.id}</td>
				<td>${entry.comments}</td>
				<td>${entry.planned}</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<br>
	<table border="1" align="center">
			<tr>
				<th>ID</th>
				<th>Comentario</th>
				<th>Planeado</th>
			</tr>
		<c:forEach var="entry" items="${listaTareasHoy}" varStatus="i">
			<tr id="item_${i.index}">
				<td>${entry.id}</td>
				<td>${entry.comments}</td>
				<td>${entry.planned}</td>
			</tr>
		</c:forEach>
	</table>
	<a id="añadirTarea_link_id" href="añadirTarea">Añadir Tarea</a>
	<%@ include file="pieDePagina.jsp" %>
</body>
</html>