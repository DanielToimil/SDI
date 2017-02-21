package uo.sdi.acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import alb.util.log.Log;
import uo.sdi.business.AdminService;
import uo.sdi.business.Services;
import uo.sdi.business.exception.BusinessException;
import uo.sdi.dto.Category;
import uo.sdi.dto.User;

public class ListarUsuariosAction implements Accion {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		String resultado = "EXITO";
		HttpSession session=request.getSession();
		User user=((User)session.getAttribute("user"));
		
		List<User> listaUsuarios;
		
		try{
			AdminService adminService = Services.getAdminService();
			listaUsuarios = adminService.findAllUsers();
			session.setAttribute("listaUsuarios", listaUsuarios);
			Log.debug("Obtenida lista de Usuarios conteniendo [%d] usuarios", 
					listaUsuarios.size());
		}catch(BusinessException b){
			Log.debug("Algo ha ocurrido obteniendo lista de usuaarios: %s",
					b.getMessage());
			resultado="FRACASO";
		}
		
		return resultado;
	}

}
