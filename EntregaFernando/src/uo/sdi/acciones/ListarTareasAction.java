package uo.sdi.acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.jmx.snmp.tasks.Task;

import uo.sdi.business.Services;
import uo.sdi.business.TaskService;
import uo.sdi.business.exception.BusinessException;
import uo.sdi.dto.*;
import uo.sdi.dto.User;
import alb.util.log.Log;

public class ListarTareasAction implements Accion {
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		String resultado="EXITO";
		HttpSession session=request.getSession();
		User user=((User)session.getAttribute("user"));
		
		List<uo.sdi.dto.Task> listaTareasInbox;
		List<uo.sdi.dto.Task> listaTareasHoy;
		
		try {
			TaskService taskService = Services.getTaskService();
			listaTareasInbox= taskService.findInboxTasksByUserId(user.getId());
			request.setAttribute("listaTareas", listaTareasInbox);
			Log.debug("Obtenida lista de tareas Inbox conteniendo [%d] tareas", 
					listaTareasInbox.size());
			
			listaTareasHoy= taskService.findTodayTasksByUserId(user.getId());
			request.setAttribute("listaTareas", listaTareasHoy);
			Log.debug("Obtenida lista de tareas Hoy conteniendo [%d] tareas", 
					listaTareasHoy.size());
		}
		catch (BusinessException b) {
			Log.debug("Algo ha ocurrido obteniendo lista de tareas: %s",
					b.getMessage());
			resultado="FRACASO";
		}
		return resultado;
	}
	
	@Override
	public String toString() {
		return getClass().getName();
	}
	
}
