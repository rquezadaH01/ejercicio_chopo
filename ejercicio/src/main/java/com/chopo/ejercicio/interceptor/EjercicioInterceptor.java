package com.chopo.ejercicio.interceptor;

import com.chopo.ejercicio.util.EjercicioConstantes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.websocket.SessionException;

@Component
public class EjercicioInterceptor implements HandlerInterceptor {

	private static final Logger LOGGER = LoggerFactory.getLogger(EjercicioInterceptor.class);

	/**
	 * Constructor de clase que sirve para inicializar el objeto y establecer sus
	 * propiedades y valores predeterminados
	 */
	public EjercicioInterceptor() {
		super();
	}

	/**
	 * Método para realizar operaciones antes de enviar la solicitud al controlador.
	 * 
	 * @param request  petición de llegada al servicio.
	 * @param response respuesta efectuada por el servicio.
	 * @param handler
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		LOGGER.info("EjercicioInterceptor -> Interceptando petición.");

		String sesion = null;

		String path = request.getRequestURI();
		

		/**
		 * Se valida el path
		 */
		if (path.contains(EjercicioConstantes.BASE_PATH + EjercicioConstantes.PATH_CONSULTAR)) {
			
			sesion = request.getHeader(EjercicioConstantes.ID_CLIENT_SESSION);
			
			if(sesion.equals("78965088")) {
				return true;
			}
			else {
				throw new SessionException(path, null, null);
			}

		}
	 
		return true;
	}

	/**
	 * Método para realizar operaciones antes de enviar la respuesta al cliente.
	 * 
	 * @param request      petición de llegada al servicio.
	 * @param response     respuesta efectuada por el servicio.
	 * @param handler
	 * @param ModelAndView excepción generada, en caso de darse.
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	/**
	 * Método para realizar operaciones después de completar la solicitud y la
	 * respuesta.
	 * 
	 * @param request  petición de llegada al servicio.
	 * @param response respuesta efectuada por el servicio.
	 * @param handler
	 * @param ex       excepción generada, en caso de darse.
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}
}
