package com.elorrieta.cms.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.elorrieta.cms.modelo.Raza;

/**
 * Clase encargada relacionar el POJO con la Tabla DAO Data Access Object
 * 
 * @author Admin
 *
 */
public class RazaDAO {

	public static ArrayList<Raza> getAll() {

		ArrayList<Raza> coleccion = new ArrayList<Raza>();
		String sql = " SELECT id, nombre FROM raza ORDER BY nombre ASC; ";

		try (Connection con = ConnectionHelper.getConnection();
				PreparedStatement pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();) {

			while (rs.next()) {

				Raza r = new Raza();
				r.setId(rs.getInt("id"));
				r.setNombre(rs.getString("nombre"));

				coleccion.add(r);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return coleccion;
	}
	// getAll

}
