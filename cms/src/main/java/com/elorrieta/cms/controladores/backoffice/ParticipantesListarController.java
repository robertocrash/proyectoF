package com.elorrieta.cms.controladores.backoffice;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elorrieta.cms.modelo.Participante;
import com.elorrieta.cms.modelo.dao.ParticipanteDAO;

/**
 * Servlet implementation class ParticipantesListarController
 */
@WebServlet("/backoffice/participantes-listar")
public class ParticipantesListarController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String filtro = request.getParameter("filtro");
		ArrayList<Participante> lista = new ArrayList<Participante>();

		if (filtro == null) {
			lista = ParticipanteDAO.getAll();
		} else {
			lista = ParticipanteDAO.filtrar(filtro);
		}

		request.setAttribute("filtro", filtro);
		request.setAttribute("participantes", lista);
		request.getRequestDispatcher("participantes.jsp?page=participantes").forward(request, response);

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
