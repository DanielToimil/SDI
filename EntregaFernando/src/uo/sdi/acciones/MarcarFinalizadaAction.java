package uo.sdi.acciones;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		
		List<Task> listaTareasInbox;
		List<Task> listaTareasHoy;
		List<Task> listaTareasSemana;
		
		String tituloTareaNueva = request.getParameter("nombreTarea");
		String comentarioTareaNueva = request.getParameter("comentarioTarea");
		String categoriaTareaNueva = request.getParameter("categoriaTarea");
		
		Date fechaPlaneadaTarea = null;
		
		try {
			TaskService ts = Services.getTaskService();
			
			listaTareasInbox= ts.findInboxTasksByUserId(user.getId());
			listaTareasHoy= ts.findTodayTasksByUserId(user.getId());
			listaTareasSemana = ts.findWeekTasksByUserId(user.getId());
			
			for(int i = 0; i<listaTareasInbox.size(); i++){
				Object checkboxFinalizada = request.getParameter("marcarFinalizadaInbox"+listaTareasInbox.get(i).getId());
				Object checkboxEditar = request.getParameter("editarTareaInbox"+listaTareasInbox.get(i).getId());
				if(checkboxFinalizada != null){
					ts.markTaskAsFinished(listaTareasInbox.get(i).getId());
				}
				if(checkboxEditar!=null){
					listaTareasInbox.get(i).setTitle(tituloTareaNueva);
					listaTareasInbox.get(i).setComments(comentarioTareaNueva);
					listaTareasInbox.get(i).setCategoryId(Long.parseLong(categoriaTareaNueva));
					fechaPlaneadaTarea=formatter.parse(request.getParameter("fechaTarea"));
					listaTareasInbox.get(i).setPlanned(fechaPlaneadaTarea);
					ts.updateTask(listaTareasInbox.get(i));
				}

			}
			
			for(int i = 0; i<listaTareasHoy.size(); i++){
				Object checkboxFinalizada = request.getParameter("marcarFinalizadaHoy"+listaTareasHoy.get(i).getId());
				Log.debug("marcar"+listaTareasHoy.get(i).getId());
				Object checkboxEditar = request.getParameter("editarTareaHoy"+listaTareasHoy.get(i).getId());
				if(checkboxFinalizada != null){
					ts.markTaskAsFinished(listaTareasHoy.get(i).getId());
				}
				if(checkboxEditar!=null){
					listaTareasHoy.get(i).setTitle(tituloTareaNueva);
					listaTareasHoy.get(i).setComments(comentarioTareaNueva);
					listaTareasHoy.get(i).setCategoryId(Long.parseLong(categoriaTareaNueva));
					fechaPlaneadaTarea=formatter.parse(request.getParameter("fechaTarea"));
					listaTareasHoy.get(i).setPlanned(fechaPlaneadaTarea);
					ts.updateTask(listaTareasHoy.get(i));
				}

			}
			
			for(int i = 0; i<listaTareasSemana.size(); i++){
				Object checkboxFinalizada = request.getParameter("marcarFinalizadaSemana"+listaTareasSemana.get(i).getId());
				Object checkboxEditar = request.getParameter("editarTareaSemana"+listaTareasSemana.get(i).getId());
				if(checkboxFinalizada != null){
					ts.markTaskAsFinished(listaTareasSemana.get(i).getId());
				}
				if(checkboxEditar!=null){
					listaTareasSemana.get(i).setTitle(tituloTareaNueva);
					listaTareasSemana.get(i).setComments(comentarioTareaNueva);
					listaTareasSemana.get(i).setCategoryId(Long.parseLong(categoriaTareaNueva));
					fechaPlaneadaTarea=formatter.parse(request.getParameter("fechaTarea"));
					listaTareasSemana.get(i).setPlanned(fechaPlaneadaTarea);
					ts.updateTask(listaTareasSemana.get(i));
				}

			}
			
			
			request.setAttribute("listaTareasInbox", listaTareasInbox);
			request.setAttribute("listaTareasHoy", listaTareasHoy);
			request.setAttribute("listaTareasSemana", listaTareasSemana);
			new ListarTareasAction().execute(request, response);
		}
		catch (BusinessException b) {
			Log.debug("Algo ha ocurrido marcando la tarea como finalizada");
			resultado="FRACASO";
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultado;
	}
	
	@Override
	public String toString() {
		return getClass().getName();
	}
	
}
