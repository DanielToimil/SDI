package uo.sdi.acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import alb.util.log.Log;
import uo.sdi.business.AdminService;
import uo.sdi.business.Services;
import uo.sdi.business.TaskService;
import uo.sdi.business.UserService;
import uo.sdi.business.exception.BusinessException;
import uo.sdi.dto.Task;
import uo.sdi.dto.User;
import uo.sdi.dto.types.UserStatus;
import uo.sdi.dto.util.Cloner;


public class MarcarFinalizadaAction implements Accion {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		String resultado="EXITO";
		
		HttpSession session=request.getSession();
		User user=((User)session.getAttribute("user"));
		
		List<Task> listaTareasInbox; //=(List<Task>) session.getAttribute("listaTareasInbox");
		List<Task> listaTareasHoy; //=(List<Task>) session.getAttribute("listaTareasHoy");
		
		try {
			TaskService ts = Services.getTaskService();
			
			listaTareasInbox= ts.findInboxTasksByUserId(user.getId());
			listaTareasHoy= ts.findTodayTasksByUserId(user.getId());
			
			for(int i = 0; i<listaTareasInbox.size(); i++){
				Object checkboxFinalizada = request.getParameter("marcarFinalizadaInbox"+listaTareasInbox.get(i).getId());
				if(checkboxFinalizada != null){
					ts.markTaskAsFinished(listaTareasInbox.get(i).getId());
				}
			}
			
			for(int i = 0; i<listaTareasHoy.size(); i++){
				Object checkboxFinalizada = request.getParameter("marcarFinalizadaHoy"+listaTareasHoy.get(i).getId());
				if(checkboxFinalizada != null){
					ts.markTaskAsFinished(listaTareasHoy.get(i).getId());
				}
			}
			
			
			request.setAttribute("listaTareasInbox", listaTareasInbox);
			request.setAttribute("listaTareasHoy", listaTareasHoy);
			new ListarTareasAction().execute(request, response);
		}
		catch (BusinessException b) {
			Log.debug("Algo ha ocurrido marcando la tarea como finalizada");
			resultado="FRACASO";
		}
		return resultado;
	}
	
	@Override
	public String toString() {
		return getClass().getName();
	}
	
}