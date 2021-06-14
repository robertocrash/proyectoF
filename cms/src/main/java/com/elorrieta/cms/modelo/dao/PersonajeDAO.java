package com.elorrieta.cms.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.elorrieta.cms.modelo.Nacionalidad;
import com.elorrieta.cms.modelo.Ocupacion;
import com.elorrieta.cms.modelo.Personaje;

public class PersonajeDAO {

	private static final String SQL_INNER_JOIN = " SELECT p.id, p.nombre ,n.nombre as 'nacionalidad', n.id as 'id_nacionalidad',o.id as 'id_ocupacion',"
			+ " o.nombre as 'ocupacion', p.poder_ataque as 'poderAtaque', p.vida as 'vida', p.mana as 'mana', p.defensa as 'defensa'"
			+ " \r\n" + " FROM personaje AS p INNER JOIN nacionalidad AS n ON p.id_nacionalidad = n.id\r\n"
			+ " INNER JOIN ocupacion AS o ON p.id_ocupacion = o.id ";

	public static ArrayList<Personaje> filtrar(String palabraBusqueda) {

		ArrayList<Personaje> coleccion = new ArrayList<Personaje>();
		String sql = SQL_INNER_JOIN + " WHERE p.nombre LIKE ?;";

		try (Connection con = ConnectionHelper.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {

			pst.setString(1, "%" + palabraBusqueda + "%");

			try (ResultSet rs = pst.executeQuery()) { // lanza la consulta SQL y obtiene Resultados RS

				while (rs.next()) { // itero sobre los resultados de la consulta SQL

					coleccion.add(mapper(rs));

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
		String sql = SQL_INNER_JOIN + " ORDER BY p.id ASC; ";

		try (

				Connection con = ConnectionHelper.getConnection();
				PreparedStatement pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery(); // lanza la consulta SQL y obtiene Resultados RS

		) {

			while (rs.next()) { // itero sobre los resultados de la consulta SQL

				// añadir objeto al ArrayList
				coleccion.add(mapper(rs));

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
		String sql = SQL_INNER_JOIN + " WHERE p.id = ?;";

		try (Connection con = ConnectionHelper.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {

			pst.setInt(1, id);
			try (ResultSet rs = pst.executeQuery()) {

				while (rs.next()) { // hemos encontrado Participante por su ID

					p = mapper(rs);

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
		String sql = "INSERT INTO personaje (nombre, nacionalidad, ocupacion, poderAtaque, vida, mana, defensa) VALUES (?,?,?,?,?,?,?);";
		try (Connection con = ConnectionHelper.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {

			pst.setString(1, p.getNombre());
			pst.setInt(2, p.getNacionalidad().getId());
			pst.setInt(3, p.getOcupacion().getId());
			pst.setInt(4, p.getPoderAtaque());
			pst.setInt(5, p.getVida());
			pst.setInt(6, p.getMana());
			pst.setInt(7, p.getDefensa());

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
		String sql = "UPDATE personaje SET nombre = ?, vida = ?, id_nacionalidad = ? WHERE id= ?; ";
		try (Connection con = ConnectionHelper.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {

			pst.setString(1, p.getNombre());
			pst.setInt(2, p.getVida());
			pst.setInt(3, p.getNacionalidad().getId());
			pst.setInt(4, p.getId());

			if (pst.executeUpdate() == 1) {
				modificado = true;
			}

		}

		return modificado;

	}

	/**
	 * Elimina un Personaje por su identificador
	 */

	public static boolean delete(int id) throws Exception {
		boolean eliminado = false;
		String sql = "DELETE FROM personaje WHERE p.id = ?;";
		try (Connection con = ConnectionHelper.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {

			pst.setInt(1, id);
			if (pst.executeUpdate() == 1) {
				eliminado = true;
			}

		}
		return eliminado;
	}

	private static Personaje mapper(ResultSet rs) throws SQLException {

		// cogemos los valores de las columnas
		int colId = rs.getInt("id");
		String colNombre = rs.getString("nombre");
		int ColAtaque = rs.getInt("poderAtaque");
		int ColVida = rs.getInt("vida");
		int ColMana = rs.getInt("mana");
		int ColDefensa = rs.getInt("Defensa");

		String colNacionalidad = rs.getString("nacionalidad");
		int colIdNacionalidad = rs.getInt("id_nacionalidad");

		String colOcupacion = rs.getString("ocupacion");
		int colIdOcupacion = rs.getInt("id_ocupacion");

		// creamos un nuevo Objeto y lo seteamos con los valores del RS
		Personaje p = new Personaje();
		p.setId(colId);
		p.setNombre(colNombre);
		p.setPoderAtaque(ColAtaque);
		p.setVida(ColVida);
		p.setMana(ColMana);
		p.setDefensa(ColDefensa);

		Nacionalidad nacionalidad = new Nacionalidad();
		nacionalidad.setId(colIdNacionalidad);
		nacionalidad.setNombre(colNacionalidad);
		p.setNacionalidad(nacionalidad);

		// ocupaciones TODO
		Ocupacion ocupacion = new Ocupacion();
		ocupacion.setId(colIdOcupacion);
		ocupacion.setNombre(colOcupacion);
		p.setOcupacion(ocupacion);

		return p;

	}

}
