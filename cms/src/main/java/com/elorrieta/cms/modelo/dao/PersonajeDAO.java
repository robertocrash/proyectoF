package com.elorrieta.cms.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.elorrieta.cms.modelo.Personaje;

public class PersonajeDAO {

	/**
	 * Filtra los personajes por nombre.
	 */

	public static ArrayList<Personaje> filtrar(String palabraBusqueda) {

		ArrayList<Personaje> coleccion = new ArrayList<Personaje>();
		String sql = " SELECT id, nombre avatar FROM personaje " + " WHERE nombre LIKE ? " + " ORDER BY id ASC; ";

		try (Connection con = ConnectionHelper.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {

			pst.setString(1, "%" + palabraBusqueda + "%");

			try (ResultSet rs = pst.executeQuery()) { // lanza la consulta SQL y obtiene Resultados RS

				while (rs.next()) { // itero sobre los resultados de la consulta SQL

					// creamos un nuevo Objeto y lo seteamos con los valores del RS
					Personaje p = new Personaje();

					// cogemos los valores de las columnas
					int colId = rs.getInt("id");
					String colNombre = rs.getString("nombre");

					p.setId(colId);
					p.setNombre(colNombre);

					// a�adir objeto al ArrayList
					coleccion.add(p);

				}
				// fin del bucle, ya no quedan mas lineas para leer
			} // fin del segundro try

		} catch (Exception e) {
			e.printStackTrace();
		}

		return coleccion;

	}

	/**
	 * Consulta la tabla 'personaje' para recuperar todos y devolverlos en una
	 * coleccion
	 * 
	 * @return Lista con todos los personajes de la bbdd
	 * @throws Exception
	 */

	public static ArrayList<Personaje> getAll() {

		ArrayList<Personaje> coleccion = new ArrayList<Personaje>();
		String sql = "SELECT id, nombre FROM personaje ORDER BY id ASC;";

		try (

				Connection con = ConnectionHelper.getConnection();
				PreparedStatement pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery(); // lanza la consulta SQL y obtiene Resultados RS

		) {

			while (rs.next()) { // itero sobre los resultados de la consulta SQL

				// creamos un nuevo Objeto y lo seteamos con los valores del RS
				Personaje p = new Personaje();

				// cogemos los valres de las columnas
				int colId = rs.getInt("id");
				String colNombre = rs.getString("nombre");

				p.setId(colId);
				p.setNombre(colNombre);
				// a�adir objeto al ArrayList
				coleccion.add(p);

			}
			// fin del bucle, ya no quedan mas lineas para leer

		} catch (Exception e) {
			e.printStackTrace();
		}

		return coleccion;
	}

	/**
	 * Buscamos un personaje por su identificador
	 */

	public static Personaje getById(int id) {
		Personaje p = null;
		String sql = "SELECT id, nombre FROM personaje WHERE id = ?;";

		try (Connection con = ConnectionHelper.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {

			pst.setInt(1, id);
			try (ResultSet rs = pst.executeQuery()) {

				while (rs.next()) { // hemos encontrado Participante por su ID

					// cogemos los valres de las columnas
					int colId = rs.getInt("id");
					String colNombre = rs.getString("nombre");

					p = new Personaje();
					p.setId(colId);
					p.setNombre(colNombre);

				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}

	/**
	 * Inserta un nuevo Personaje
	 */

	public static boolean insert(Personaje p) throws Exception {
		boolean insertado = false;
		String sql = "INSERT INTO personaje (nombre) VALUES (?); ";
		try (Connection con = ConnectionHelper.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {

			pst.setString(1, p.getNombre());

			if (pst.executeUpdate() == 1) {
				insertado = true;
			}

		}

		return insertado;
	}

	/**
	 * Modifica un personaje
	 */

	public static boolean update(Personaje p) throws Exception {
		boolean modificado = false;
		String sql = "UPDATE participante SET nombre = ? WHERE id = ?;";
		try (Connection con = ConnectionHelper.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {

			pst.setString(1, p.getNombre());
			pst.setInt(2, p.getId());

			if (pst.executeUpdate() == 1) {
				modificado = true;
			}

		}

		return modificado;

	}

}
