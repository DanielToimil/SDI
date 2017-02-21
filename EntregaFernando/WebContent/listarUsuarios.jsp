<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="comprobarNavegacion.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="cambiarEstado" method="POST">
	<table border="1" align="center">
			<tr>
				<th>Login</th>
				<th>Email</th>
				<th>IsAdmin</th>
				<th>Status</th>
				<th>Cambiar Estado</th>
				<th>Eliminar usuario</th>
			</tr>
		<c:forEach var="entry" items="${listaUsuarios}" varStatus="i">
			<tr id="item_${i.index}">
				<td>${entry.login}</td>
				<td>${entry.email}</td>
				<td>${entry.isAdmin}</td>
				<td>${entry.status}</td>
				<td><input type="checkbox" name="cambiarEstado${entry.login}"/></td>
				<td><input type="checkbox" name="eliminar${entry.login}"/></td>
			</tr>
		</c:forEach>
	</table>
	<input type="submit" onclick="return confirm('¿Seguro que desea modificar los datos? Si eliminas un usuario no se podra deshacer')" value="Modificar usuario">
	</form>
	<%@ include file="pieDePagina.jsp" %>
</body>
</html>