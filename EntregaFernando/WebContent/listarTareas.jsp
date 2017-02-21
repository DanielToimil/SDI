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
	<center><h1>Lista Tareas Inbox</h1></center>
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
				<td><input type="checkbox" name="editarTareaInbox${entry.id}"/></td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<br>
	<center><h1>Lista Tareas Hoy</h1></center>
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
				<td><input type="checkbox" name="editarTareaHoy${entry.id}"/></td>
			</tr>
		</c:forEach>
	</table>
	<center><h1>Editar Tarea</h1></center>
	 	<hr><br>
	 	<table align="center">
	    	<tr> 
	    		<td align="right">Nombre para la tarea</td>
		    	<td><input type="text" name="nombreTarea" align="left" size="15"></td>
	      	</tr>
	      	<tr> 
	    		<td align="right">Comentario de la tarea</td>
		    	<td><input type="text" name="comentarioTarea" align="left" size="15"></td>
	      	</tr>
	      	<tr> 
	    		<td align="right">Fecha planeada</td>
		    	<td><input type="text" name="fechaTarea" align="left" size="15"></td>
	      	</tr>
	      </table>
	<br>
	<center><input type="submit" value="Finalizar Tarea/Editar"></center>
	</form>
	<a id="añadirTarea_link_id" href="añadirTarea">Añadir Tarea</a>
	<%@ include file="pieDePagina.jsp" %>
</body>
</html>