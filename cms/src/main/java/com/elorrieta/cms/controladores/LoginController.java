package com.elorrieta.cms.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.elorrieta.cms.modelo.Usuario;
import com.elorrieta.cms.modelo.dao.UsuarioDAO;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String mensaje = "";
		String vista = "";
		HttpSession session = request.getSession();

		// recoger parametros
		String nombre = request.getParameter("nombre");
		String pass = request.getParameter("contraseina");

		// logica de negocio
		Usuario usuario = UsuarioDAO.login(nombre, pass);

		if (usuario != null) {
			mensaje = "Ongi Etorri";

			// comprobar el ROL
			if (Usuario.ROL_ADMIN == usuario.getRol()) {
				vista = "backoffice/participantes-listar"; // nombre del controlador, no quiero ir a la JSP
			} else {
				vista = "frontoffice/perfil.jsp";
			}

			// guardamos el usuario logeado en session como un atributo

			session.setAttribute("usuario_logeado", usuario);
			session.setMaxInactiveInterval(60 * 5); // 5 min
			// session.setMaxInactiveInterval(5); // 5 segundos

		} else {
			mensaje = "Credenciales incorrectas, prueba de nuevo";
			vista = "index.jsp?page=login";
		}

		// enviar atributos para vistar
		session.setAttribute("mensaje", mensaje);

		// Ir a una vista
		// request.getRequestDispatcher(vista).forward(request, response);
		response.sendRedirect(vista);

	}

}
