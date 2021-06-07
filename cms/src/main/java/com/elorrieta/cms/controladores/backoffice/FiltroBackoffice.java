package com.elorrieta.cms.controladores.backoffice;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.elorrieta.cms.modelo.Usuario;

/**
 * Filtra todas las peticiones (request) que empiecen por la url "/backoffice/*"
 * <br>
 * Comprueba que el usuario hay sido logeado y tenga el rol de ADMINISTRADOR
 * <br>
 * Para poder comprobarlo usa el atributo de session (Usuario) usuario_logeado
 * 
 */
@WebFilter(dispatcherTypes = { DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.INCLUDE,
		DispatcherType.ERROR }, urlPatterns = { "/backoffice/*" })
public class FiltroBackoffice implements Filter {

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("Estamos filtrando");

		// castear request y response
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		// recuperar usuario de session
		HttpSession session = req.getSession();
		Usuario u = (Usuario) session.getAttribute("usuario_logeado");

		if (u == null) {
			System.out.println("Esta intentando acceder sin logearse o ha caducado la session");
			res.sendRedirect(req.getContextPath() + "/index.jsp");

		} else if (u.getRol() == Usuario.ROL_USUARIO) {
			System.out.println("No tienes permiso para acceder al backoffice");
			res.sendRedirect(req.getContextPath() + "/index.jsp");

		} else { // usuario administrador
			System.out.println("Pase usted señor@ administrador");
			// sigue la ejecucion del programa
			chain.doFilter(request, response);
		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
