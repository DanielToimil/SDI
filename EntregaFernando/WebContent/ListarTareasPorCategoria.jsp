<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border="1" align="center">
			<tr>
				<th>ID</th>
				<th>Nombre</th>
				<th>Comentario</th>
				<th>Planeado</th>
				<th>Categoria</th>
			</tr>
		<c:forEach var="entry" items="${listaTareasPorCategoria}" varStatus="i">
			<tr id="item_${i.index}">
				<td>${entry.id}</td>
				<td>${entry.title}</td>
				<td>${entry.comments}</td>
				<td>${entry.planned}</td>
				<td>${entry.categoryId}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>