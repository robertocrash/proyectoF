package com.elorrieta.cms.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.elorrieta.cms.modelo.Perro;
import com.elorrieta.cms.modelo.Raza;

/**
 * Clase encargada relacionar el POJO con la Tabla DAO Data Access Object
 * 
 * @author Admin
 *
 */
public class PerroDAO {

	public static ArrayList<Perro> getAll() {

		ArrayList<Perro> coleccion = new ArrayList<Perro>();
		String sql = " SELECT perro.id, perro.nombre, historia, raza.nombre as 'raza', raza.id as 'id_raza' "
				+ " FROM perro INNER JOIN raza ON perro.id_raza = raza.id " + " ORDER BY perro.id ASC; ";

		try (

				Connection con = ConnectionHelper.getConnection();
				PreparedStatement pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery(); // lanza la consulta SQL y obtiene Resultados RS

		) {

			while (rs.next()) { // itero sobre los resultados de la consulta SQL

				// creamos un nuevo Objeto y lo seteamos con los valores del RS
				Perro p = new Perro();

				// cogemos los valres de las columnas
				int colId = rs.getInt("id");
				String colNombre = rs.getString("nombre");
				String colHis = rs.getString("historia");
				String colRazaNombre = rs.getString("raza");
				int colRazaId = rs.getInt("id_raza");

				p.setId(colId);
				p.setNombre(colNombre);
				p.setHistoria(colHis);

				Raza raza = new Raza();
				raza.setId(colRazaId);
				raza.setNombre(colRazaNombre);
				p.setRaza(raza);

				// añadir objeto al ArrayList
				coleccion.add(p);

			}
			// fin del bucle, ya no quedan mas lineas para leer

		} catch (Exception e) {
			e.printStackTrace();
		}

		return coleccion;
	}

	/**
	 * Inserta un perro en la base de datos
	 * 
	 * @param pNuevo Perro a insertar
	 * @return true si es insertado, false en caso contrario
	 */
	public static boolean insert(Perro pNuevo) throws Exception {

		boolean resultado = false;
		String sql = "INSERT INTO perro ( nombre, historia, id_raza ) VALUES (?,?,?);";

		try (Connection con = ConnectionHelper.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			// sustituir ? por valores del pNuevo
			pst.setString(1, pNuevo.getNombre());
			pst.setString(2, pNuevo.getHistoria());
			pst.setInt(3, pNuevo.getRaza().getId());

			// ejecuta la INSERT
			int affectedRows = pst.executeUpdate();
			// comprobamos que se ha insertado una fila
			if (affectedRows == 1) {
				resultado = true;
			}
		}

		return resultado;
	}

}
