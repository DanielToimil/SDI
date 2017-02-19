package uo.sdi.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import alb.util.log.Log;
import uo.sdi.business.Services;
import uo.sdi.business.UserService;
import uo.sdi.business.exception.BusinessException;
import uo.sdi.dto.User;

public class RegistrarseAction implements Accion{

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		String resultado="EXITO";
		String nombreUsuario=request.getParameter("nombreUsuario");
		String contraseña = request.getParameter("contrasenia");
		String email=request.getParameter("email");
		String repecontraseña = request.getParameter("repeContrasenia");
		try{
			if(nombreUsuario != null && contraseña != null && email != null && repecontraseña != null){
				if(contraseña.equals(repecontraseña));
					User nuevo = new User(nombreUsuario, email, contraseña);
					UserService userService = Services.getUserService();
					userService.registerUser(nuevo);

					
			}
		}catch(BusinessException b){
			Log.debug("Error al crear usuario con login [%s] y email [%s]", 
					nombreUsuario,email);
			resultado="FRACASO";
		}
		return resultado;
	}

}
