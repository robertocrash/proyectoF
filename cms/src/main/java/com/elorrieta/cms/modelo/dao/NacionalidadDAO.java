package com.elorrieta.cms.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.elorrieta.cms.modelo.Nacionalidad;

public class NacionalidadDAO {

	/**
	 * metodo para conseguir todas las nacionalidades de la bbdd
	 * 
	 * @return
	 */
	public static ArrayList<Nacionalidad> getAll() {

		ArrayList<Nacionalidad> coleccion = new ArrayList<Nacionalidad>();
		String sql = "SELECT id, nombre FROM nacionalidad ORDER BY nombre ASC; ";

		try (Connection con = ConnectionHelper.getConnection();
				PreparedStatement pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();) {

			while (rs.next()) {
				Nacionalidad n = new Nacionalidad();
				n.setId(rs.getInt("id"));
				n.setNombre(rs.getString("nombre"));

				coleccion.add(n);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return coleccion;

	}

}