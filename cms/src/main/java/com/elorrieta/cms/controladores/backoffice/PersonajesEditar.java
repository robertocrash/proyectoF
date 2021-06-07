package com.elorrieta.cms.controladores.backoffice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elorrieta.cms.modelo.Personaje;
import com.elorrieta.cms.modelo.dao.PersonajeDAO;

/**
 * Servlet implementation class PersonajesEditar
 */
@WebServlet("/backoffice/personajes-editar")
public class PersonajesEditar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));

		Personaje p = new Personaje();
		String titulo = "Crear Nuevo Personaje";

		if (id > 0) {
			titulo = "Modificar Personaje";
			p = PersonajeDAO.getById(id);
		}

		request.setAttribute("titulo", titulo);
		request.setAttribute("personaje", p);
		request.getRequestDispatcher("formulario.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// recoger parametros del formulario
		int id = Integer.parseInt(request.getParameter("id"));
		String nombre = request.getParameter("nombre");

		// creamos POJO de Personaje con los datos del formulario
		Personaje p = new Personaje();
		p.setId(id);
		p.setNombre(nombre);

		try {
			if (id == 0) {
				PersonajeDAO.insert(p);
			} else {
				PersonajeDAO.update(p);
			}

			request.setAttribute("mensajeTipo", "primary");
			request.setAttribute("mensaje", "Datos Guardados");

		} catch (Exception e) {
			request.setAttribute("mensajeTipo", "danger");
			request.setAttribute("mensaje", "Algo ha salido mal");
		}

		request.setAttribute("titulo", "Modificar Personaje");
		request.setAttribute("personaje", p);
		request.getRequestDispatcher("formulario.jsp").forward(request, response);

	}

}
