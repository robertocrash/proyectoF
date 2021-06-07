package com.elorrieta.cms.controladores.backoffice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elorrieta.cms.modelo.Participante;
import com.elorrieta.cms.modelo.dao.ParticipanteDAO;

/**
 * Servlet implementation class ParticipantesEditar
 */
@WebServlet("/backoffice/participantes-editar")
public class ParticipantesEditar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));

		Participante p = new Participante();
		String titulo = "Crear Nuevo Participante";

		if (id > 0) {
			titulo = "Modificar Participante";
			p = ParticipanteDAO.getById(id);
		}

		request.setAttribute("titulo", titulo);
		request.setAttribute("participante", p);
		request.getRequestDispatcher("formulario.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// recoger parametro del formulario
		int id = Integer.parseInt(request.getParameter("id"));
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		String email = request.getParameter("email");
		String avatar = request.getParameter("avatar");

		// creamos POJO de Participante con los datos del formulario
		Participante p = new Participante();
		p.setId(id);
		p.setNombre(nombre);
		p.setApellidos(apellidos);
		p.setEmail(email);
		p.setAvatar(avatar);

		try {
			if (id == 0) {
				ParticipanteDAO.insert(p);
			} else {
				ParticipanteDAO.update(p);
			}

			request.setAttribute("mensajeTipo", "primary");
			request.setAttribute("mensaje", "Datos Guardados");

		} catch (Exception e) {
			request.setAttribute("mensajeTipo", "danger");
			request.setAttribute("mensaje", "El email esta repetido");

		}

		request.setAttribute("titulo", "Modificar Participante");
		request.setAttribute("participante", p);
		request.getRequestDispatcher("formulario.jsp").forward(request, response);

	}

}
