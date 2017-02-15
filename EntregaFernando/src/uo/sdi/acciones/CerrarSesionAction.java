package uo.sdi.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CerrarSesionAction implements Accion {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		String resultado="EXITO";
		HttpSession session = request.getSession();
		session.invalidate();
		return resultado;//comentario de prueba para ver si se actualiza
	}
	
	@Override
	public String toString() {
		return getClass().getName();
	}
	
}
