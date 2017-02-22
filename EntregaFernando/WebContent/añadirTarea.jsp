<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Añadir Tarea</title>
</head>
<body>
	<form action="añadirTarea" method="post" name="registarse_form_name">
	
	 	<center><h1>Añadir Tarea</h1></center>
	 	<hr><br>
	 	<a>Tiene que ir despues de mostrar el listar categorias</a>
	 	
	 	<table align="center">
	    	<tr> 
	    		<td align="right">Nombre para la tarea</td>
		    	<td><input type="text" name="nombreTarea" align="left" size="15"></td>
	      	</tr>
	      	<tr>
	    	    <td><input type="submit" value="Enviar"/></td>
	      	</tr>
	      </table>
	</form>
</body>
</html>