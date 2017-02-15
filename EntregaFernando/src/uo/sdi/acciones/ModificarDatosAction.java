package uo.sdi.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import alb.util.log.Log;
import uo.sdi.business.Services;
import uo.sdi.business.UserService;
import uo.sdi.business.exception.BusinessException;
import uo.sdi.dto.User;
import uo.sdi.dto.util.Cloner;


public class ModificarDatosAction implements Accion {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		String resultado="EXITO";
		
		String nuevoEmail=request.getParameter("email");
		String nuevaContraseña = request.getParameter("nuevaContrasenia");
		String repeContraseña = request.getParameter("repeContrasenia");
		HttpSession session=request.getSession();
		
		User user=((User)session.getAttribute("user"));
		
		User userCloneEmail=Cloner.clone(user);
		User userCloneNuevaContraseña = Cloner.clone(user);
		
		userCloneEmail.setEmail(nuevoEmail);
		userCloneNuevaContraseña.setPassword(nuevaContraseña);
		try {
			if(nuevoEmail != null){
			if(user.getEmail()!= userCloneEmail.getEmail()){
				UserService userService = Services.getUserService();
				userService.updateUserDetails(userCloneEmail);
				Log.debug("Modificado email o de [%s] con el valor [%s]", 
						userCloneEmail.getLogin(), nuevoEmail);
				session.setAttribute("user",userCloneEmail);
			}
			}
			
			if(nuevaContraseña != null){
			if(user.getPassword() != userCloneNuevaContraseña.getPassword() && nuevaContraseña.equals(repeContraseña)){
				UserService userService = Services.getUserService();
				userService.updateUserDetails(userCloneNuevaContraseña);
				Log.debug("Modificado contraseña de [%s] con el valor [%s]", 
						userCloneNuevaContraseña.getLogin(), nuevaContraseña);
				session.setAttribute("user",userCloneNuevaContraseña);
			}
			}
		}
		catch (BusinessException b) {
			Log.debug("Algo ha ocurrido actualizando el email o contraseña de [%s] a [%s]: %s", 
					user.getLogin(),nuevoEmail,b.getMessage());
			resultado="FRACASO";
		}
		return resultado;
	}
	
	@Override
	public String toString() {
		return getClass().getName();
	}
	
}
