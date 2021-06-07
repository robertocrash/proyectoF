package com.elorrieta.cms.controladores.backoffice;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elorrieta.cms.modelo.Personaje;
import com.elorrieta.cms.modelo.dao.PersonajeDAO;

/**
 * Servlet implementation class PersonajesListarController
 */
@WebServlet("/backoffice/personajes-listar")
public class PersonajesListarController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String filtro = request.getParameter("filtro");
		ArrayList<Personaje> lista = new ArrayList<Personaje>();

		if (filtro == null) {
			lista = PersonajeDAO.getAll();
		} else {
			request.setAttribute("filtro", filtro);
			request.setAttribute("personajes", lista);
			request.getRequestDispatcher("personajes.jsp?page=personajes").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
