package uo.sdi.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import alb.util.log.Log;
import uo.sdi.business.Services;
import uo.sdi.business.TaskService;
import uo.sdi.business.UserService;
import uo.sdi.business.exception.BusinessException;
import uo.sdi.dto.Task;
import uo.sdi.dto.User;

public class AñadirTareaAction implements Accion{

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		String resultado="EXITO";
		String nombreTarea=request.getParameter("nombreTarea");
		
		try{
			if(nombreTarea != null){
					Task task = new Task(nombreTarea);
					TaskService taskService = Services.getTaskService();
					taskService.createTask(task);
			}
		}catch(BusinessException b){
			Log.debug("Error al crear la tarea con nombre [%s]", 
					nombreTarea);
			resultado="FRACASO";
		}
		return resultado;
	}

}
