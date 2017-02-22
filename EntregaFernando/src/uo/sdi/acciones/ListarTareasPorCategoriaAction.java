package uo.sdi.acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import alb.util.log.Log;
import uo.sdi.business.Services;
import uo.sdi.business.TaskService;
import uo.sdi.business.exception.BusinessException;
import uo.sdi.dto.User;

public class ListarTareasPorCategoriaAction implements Accion{

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		String resultado = "EXITO";
		
		Long id = Long.valueOf(request.getParameter("id"));
		
		/*
		HttpSession session=request.getSession();
		User user=((User)session.getAttribute("user"));
		*/
		//List<uo.sdi.dto.Category> listaCategoriasUsuario;
		
		List<uo.sdi.dto.Task> listaTareasporCategoria;
		
		try{
			TaskService taskService = Services.getTaskService();
			//listaCategoriasUsuario = taskService.findCategoriesByUserId(user.getId());
			listaTareasporCategoria = taskService.findTasksByCategoryId(id);
			
			request.setAttribute("listaTareasPorCategoria", listaTareasporCategoria);
			Log.debug("Obtenida lista de tareas de la categoria [%d] conteniendo [%d] tareas", 
					id, listaTareasporCategoria.size());
			
		}	catch (BusinessException b) {
			Log.debug("Algo ha ocurrido obteniendo lista de tareas: %s",
					b.getMessage());
			resultado="FRACASO";
		}
		return resultado;
	}

}
