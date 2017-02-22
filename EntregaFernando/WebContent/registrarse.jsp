<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pagina Registro</title>
</head>
<body>
	<form action="registrarse" method="post" name="registarse_form_name">
	
	 	<center><h1>Registrese</h1></center>
	 	<hr><br>
	 	
	 	<table align="center">
	    	<tr> 
	    		<td align="right">Cree un identificador de usuario</td>
		    	<td><input type="text" name="nombreUsuario" align="left" size="15"></td>
	      	</tr>
	      	<tr> 
	    		<td align="right">E-mail</td>
		    	<td><input type="text" name="email" align="left" size="15"></td>
	      	</tr>
	      	<tr> 
	    		<td align="right">Contraseña</td>
		    	<td><input type="text" name="contrasenia" align="left" size="15"></td>
	      	</tr>
	      	<tr> 
	    		<td align="right">Repetir Contraseña</td>
		    	<td><input type="text" name="repeContrasenia" align="left" size="15"></td>
	      	</tr>
	      	<tr>
	    	    <td><input type="submit" value="Enviar"/></td>
	      	</tr>
	      </table>
	</form>
</body>
</html>