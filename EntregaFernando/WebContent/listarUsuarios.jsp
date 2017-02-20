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
	<table border="1" align="center">
			<tr>
				<th>Login</th>
				<th>Email</th>
				<th>IsAdmin</th>
				<th>Status</th>
				<th>Cambiar Estado</th>
			</tr>
		<c:forEach var="entry" items="${listaUsuarios}" varStatus="i">
			<tr id="item_${i.index}">
				<td>${entry.login}</td>
				<td>${entry.email}</td>
				<td>${entry.isAdmin}</td>
				<td>${entry.status}</td>
				<!--Me queda aqui darle evento al boton para poder llamar a los metodos de Admin Service 
				(Enable/DisableUserCommand)-->
				<td><input type="button" name="cambiar estado"/></td>
			</tr>
		</c:forEach>
	</table>
	<%@ include file="pieDePagina.jsp" %>
</body>
</html>