package uo.sdi.acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import alb.util.log.Log;
import uo.sdi.business.AdminService;
import uo.sdi.business.Services;
import uo.sdi.business.UserService;
import uo.sdi.business.exception.BusinessException;
import uo.sdi.dto.User;
import uo.sdi.dto.types.UserStatus;
import uo.sdi.dto.util.Cloner;


public class CambiarEstadoAction implements Accion {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		String resultado="EXITO";
		
		HttpSession session=request.getSession();
		
		List<User> listaUsuarios =(List<User>) session.getAttribute("listaUsuarios");
		
		try {
			AdminService as = Services.getAdminService();
			for(int i = 0; i<listaUsuarios.size(); i++){
				Object checkboxEstado = request.getParameter("cambiarEstado"+listaUsuarios.get(i).getLogin());
				Object checkboxEliminar = request.getParameter("eliminar"+listaUsuarios.get(i).getLogin());
				if(checkboxEliminar != null){
					as.deepDeleteUser(listaUsuarios.get(i).getId());
				}
				else{
					if(checkboxEstado != null){
						if(listaUsuarios.get(i).getStatus() == UserStatus.ENABLED)
							as.disableUser(listaUsuarios.get(i).getId());
						else
							as.enableUser(listaUsuarios.get(i).getId());
					}
				}
			}
			new ListarUsuariosAction().execute(request, response);
		}
		catch (BusinessException b) {
			Log.debug("Algo ha ocurrido actualizando el estado");
			resultado="FRACASO";
		}
		return resultado;
	}
	
	@Override
	public String toString() {
		return getClass().getName();
	}
	
}
