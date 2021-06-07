package com.elorrieta.cms.controladores.backoffice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elorrieta.cms.modelo.Perro;
import com.elorrieta.cms.modelo.Raza;
import com.elorrieta.cms.modelo.dao.PerroDAO;
import com.elorrieta.cms.modelo.dao.RazaDAO;

/**
 * Servlet implementation class PerroController
 */
@WebServlet("/backoffice/perros")
public class PerroController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// coger parametros

		// logica de negocio

		// envio atributos para la JSP
		request.setAttribute("razas", RazaDAO.getAll());
		request.setAttribute("perros", PerroDAO.getAll());

		// ir a la JSP
		request.getRequestDispatcher("perros.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// recoger parametros
		String nombre = request.getParameter("nombre");
		String historia = request.getParameter("historia");
		int idraza = Integer.parseInt(request.getParameter("idraza"));

		try {
			// Crear Perro y Raza, para la insert no necesito el nombre de la raza
			Raza r = new Raza();
			r.setId(idraza);

			Perro p = new Perro();
			p.setNombre(nombre);
			p.setHistoria(historia);
			p.setRaza(r);

			// enviamos este atributo para poder pintar el perro en el formulario
			request.setAttribute("perro", p);

			// insertar en la bbdd usando el DAO
			PerroDAO.insert(p);

		} catch (Exception e) {

			e.printStackTrace();
			request.setAttribute("mensaje", "Lo sentimos pero el nombre del perro ya existe");
		} finally {

			// llamamos al GET para que liste todos los perros
			doGet(request, response);
		}

	}

}
