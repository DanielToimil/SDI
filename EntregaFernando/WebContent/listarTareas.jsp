<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="comprobarNavegacion.jsp" %>
<jsp:useBean id="today" class="java.util.Date" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<title>TaskManager - Listado de Tareas</title>
</head>
<body>
	<form action="marcarFinalizada" method="POST">
	<table border="1" align="center">
			<tr>
				<th>ID</th>
				<th>Nombre</th>
				<th>Comentario</th>
				<th>Planeado</th>
				<th>Categoria</th>
				<th>Marcar Finalizada</th>
				<th>Editar Tarea</th>
			</tr>
		<c:forEach var="entry" items="${listaTareasInbox}" varStatus="i">
			<tr id="item_${i.index}">
				<td>${entry.id}</td>
				<td>${entry.title}</td>
				<td>${entry.comments}</td>
		        <c:choose>
		            <c:when test="${entry.planned le today}">
		                <td><FONT COLOR="red"> ${entry.planned} </FONT></td> 
		            </c:when>
		            <c:otherwise>
		                <td> ${entry.planned} </td> 
		            </c:otherwise>
		        </c:choose>
				<td>${entry.categoryId}</td>
				<td><input type="checkbox" name="marcarFinalizadaInbox${entry.id}"/></td>
				<td><input type="checkbox" name="editarTarea${entry.id}"/></td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<br>
	<table border="1" align="center">
			<tr>
				<th>ID</th>
				<th>Nombre</th>
				<th>Comentario</th>
				<th>Planeado</th>
				<th>Categoria</th>
				<th>Marcar Finalizada</th>
				<th>Editar tarea</th>
			</tr>
		<c:forEach var="entry" items="${listaTareasHoy}" varStatus="i">
			<tr id="item_${i.index}">
				<td>${entry.id}</td>
				<td>${entry.title}</td>
				<td>${entry.comments}</td>
				<c:choose>
		            <c:when test="${entry.planned le today}">
		                <td><FONT COLOR="red"> ${entry.planned} </FONT></td> 
		            </c:when>
		            <c:otherwise>
		                <td> ${entry.planned} </td> 
		            </c:otherwise>
		        </c:choose>
				<td>${entry.categoryId}</td>
				<td><input type="checkbox" name="marcarFinalizadaHoy${entry.id}"/></td>
				<td><input type="checkbox" name="editarTarea${entry.id}"/></td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<input type="submit" value="Marcar Finalizada">
	</form>
	<a id="añadirTarea_link_id" href="añadirTarea">Añadir Tarea</a>
	<%@ include file="pieDePagina.jsp" %>
</body>
</html>