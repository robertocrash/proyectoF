package com.elorrieta.cms.ejemplo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @WebServlet("/calcular") es la URL donde esta escuchando esta clase de java
 */
@WebServlet("/calcular")
public class CalculadoraController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// recoger PARAMETROS, CUIDADO siempre son String
		// String op = request.getParameter("operacion");
		int numero1 = Integer.parseInt(request.getParameter("numero1"));
		int numero2 = Integer.parseInt(request.getParameter("numero2"));

		// logica de negocio
		float suma = numero1 + numero2;

		// Esta vez en vez de usar una JSP
		// vamos a escribir la respuesta desde el controlador usando la RESPONSE
		PrintWriter out = response.getWriter();
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.print("<head>");
		out.print("<meta charset=\"ISO-8859-1\">");
		out.print("<title>Resultado</title>");
		out.print("</head>");
		out.print("<body>");
		out.print("El resultado de la suma es " + suma);
		out.print("</body>");
		out.print("</html>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			// recoger PARAMETROS, CUIDADO siempre son String
			String op = request.getParameter("operacion");
			int numero1 = Integer.parseInt(request.getParameter("numero1"));
			int numero2 = Integer.parseInt(request.getParameter("numero2"));

			// logica de negocio
			float resultado = 0;
			String nombreOperacion = "";

			switch (op) {
			case "s": {
				resultado = numero1 + numero2;
				nombreOperacion = "sumar";
				break;
			}
			case "r": {
				resultado = numero1 - numero2;
				nombreOperacion = "restar";
				break;
			}
			case "d": {
				resultado = numero1 / numero2;
				nombreOperacion = "dividir";
				break;
			}
			case "m": {
				resultado = numero1 * numero2;
				nombreOperacion = "multiplicar";
				break;
			}

			}

			// Enviar ATRIBUTOS a la JSP
			request.setAttribute("op", nombreOperacion);
			request.setAttribute("numero1", numero1);
			request.setAttribute("numero2", numero2);
			request.setAttribute("resultado", resultado);

			// IR a la JSP resultado.jsp
			request.getRequestDispatcher("resultado.jsp").forward(request, response);

		} catch (Exception e) {
			request.setAttribute("mensaje", "Por favor escribe numeros");
			request.getRequestDispatcher("calculadora.jsp").forward(request, response);
		}

	}

}
