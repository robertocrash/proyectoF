package com.elorrieta.cms.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.elorrieta.cms.modelo.Participante;

/**
 * Clase encargada relacionar el POJO con la Tabla DAO Data Access Object
 * 
 * @author Admin
 *
 */
public class ParticipanteDAO {

	/**
	 * Filtra los participantes por nombre, apellidos o email
	 * 
	 * @param palabraBusqueda la palabra a buscar en las 3 columnas
	 * @return ArrayList con todos los participantes filtrados
	 */
	public static ArrayList<Participante> filtrar(String palabraBusqueda) {

		ArrayList<Participante> coleccion = new ArrayList<Participante>();
		String sql = " SELECT id, nombre, apellidos, email, avatar FROM participante "
				+ " WHERE nombre LIKE ? OR apellidos LIKE ? or email LIKE ? " + " ORDER BY id ASC; ";

		try (Connection con = ConnectionHelper.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {

			pst.setString(1, "%" + palabraBusqueda + "%");
			pst.setString(2, "%" + palabraBusqueda + "%");
			pst.setString(3, "%" + palabraBusqueda + "%");

			try (ResultSet rs = pst.executeQuery()) { // lanza la consulta SQL y obtiene Resultados RS

				while (rs.next()) { // itero sobre los resultados de la consulta SQL

					// creamos un nuevo Objeto y lo seteamos con los valores del RS
					Participante p = new Participante();

					// cogemos los valores de las columnas
					int colId = rs.getInt("id");
					String colNombre = rs.getString("nombre");
					String colApellidos = rs.getString("apellidos");

					p.setId(colId);
					p.setNombre(colNombre);
					p.setApellidos(colApellidos);
					p.setEmail(rs.getString("email"));
					p.setAvatar(rs.getString("avatar"));

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
	 * Consulta la tabla 'participante' para recuperar todos y devolverlos en una
	 * coleccion
	 * 
	 * @return Lista con todos los participantes de la bbdd
	 * @throws Exception
	 */
	public static ArrayList<Participante> getAll() {

		ArrayList<Participante> coleccion = new ArrayList<Participante>();
		String sql = "SELECT id, nombre, apellidos, email, avatar FROM participante ORDER BY id ASC; ";

		try (

				Connection con = ConnectionHelper.getConnection();
				PreparedStatement pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery(); // lanza la consulta SQL y obtiene Resultados RS

		) {

			while (rs.next()) { // itero sobre los resultados de la consulta SQL

				// creamos un nuevo Objeto y lo seteamos con los valores del RS
				Participante p = new Participante();

				// cogemos los valres de las columnas
				int colId = rs.getInt("id");
				String colNombre = rs.getString("nombre");
				String colApellidos = rs.getString("apellidos");

				p.setId(colId);
				p.setNombre(colNombre);
				p.setApellidos(colApellidos);
				p.setEmail(rs.getString("email"));
				p.setAvatar(rs.getString("avatar"));

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
	 * Buscamos un participante por su identificador
	 * 
	 * @param id int identificador del participantes
	 * @return Participante con datos si encuentra, NULL si no lo encuentra
	 */
	public static Participante getById(int id) {

		Participante p = null;
		String sql = "SELECT id,nombre,apellidos,email, avatar FROM participante WHERE id = ?; ";

		try (Connection con = ConnectionHelper.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {

			pst.setInt(1, id);
			try (ResultSet rs = pst.executeQuery()) {

				while (rs.next()) { // hemos encontrado Participante por su ID

					// cogemos los valres de las columnas
					int colId = rs.getInt("id");
					String colNombre = rs.getString("nombre");
					String colApellidos = rs.getString("apellidos");
					String colEmail = rs.getString("email");
					String colAvatar = rs.getString("avatar");

					p = new Participante();
					p.setId(colId);
					p.setNombre(colNombre);
					p.setApellidos(colApellidos);
					p.setEmail(colEmail);
					p.setAvatar(colAvatar);
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}

	/**
	 * Elimina un particpante por su identificador
	 * 
	 * @param id int identificador
	 * @return true si elimina, false en caso contrario
	 * @throws Exception no deberia lanzar
	 */
	public static boolean delete(int id) throws Exception {

		boolean eliminado = false;
		String sql = "DELETE FROM participante WHERE id = ?;";
		try (Connection con = ConnectionHelper.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {

			pst.setInt(1, id);
			if (pst.executeUpdate() == 1) {
				eliminado = true;
			}

		}
		return eliminado;
	}

	/**
	 * Inserta un nuevo Participante
	 * 
	 * @param p Participante con los datos nuevos a insertar
	 * @return true si lo inserta, false en caso contrario
	 * @throws Exception si el email ya existe
	 */
	public static boolean insert(Participante p) throws Exception {
		boolean insertado = false;
		String sql = "INSERT INTO participante (nombre,apellidos,email,avatar) VALUES (?,?,?,?); ";
		try (Connection con = ConnectionHelper.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {

			pst.setString(1, p.getNombre());
			pst.setString(2, p.getApellidos());
			pst.setString(3, p.getEmail());
			pst.setString(4, p.getAvatar());

			if (pst.executeUpdate() == 1) {
				insertado = true;
			}

		}

		return insertado;
	}

	/**
	 * Modifica un Participante
	 * 
	 * @param p Participante con los datos a modificar, importante que tenga un id
	 * @return true si modifica, false en caso contrario
	 * @throws Exception si el email ya existe en la tabla
	 */
	public static boolean update(Participante p) throws Exception {
		boolean modificado = false;
		String sql = "UPDATE participante SET nombre = ? ,apellidos = ?, email = ?, avatar = ?	WHERE id = ?;";
		try (Connection con = ConnectionHelper.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {

			pst.setString(1, p.getNombre());
			pst.setString(2, p.getApellidos());
			pst.setString(3, p.getEmail());
			pst.setString(4, p.getAvatar());
			pst.setInt(5, p.getId());

			if (pst.executeUpdate() == 1) {
				modificado = true;
			}

		}

		return modificado;
	}

}
