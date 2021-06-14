package com.elorrieta.cms.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.elorrieta.cms.modelo.Ocupacion;

public class OcupacionDAO {

	/**
	 * metodo para conseguir todas las nacionalidades de la bbdd
	 * 
	 * @return
	 */
	public static ArrayList<Ocupacion> getAll() {

		ArrayList<Ocupacion> coleccion = new ArrayList<Ocupacion>();
		String sql = "SELECT id, nombre FROM ocupacion ORDER BY nombre ASC; ";

		try (Connection con = ConnectionHelper.getConnection();
				PreparedStatement pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();) {

			while (rs.next()) {
				Ocupacion o = new Ocupacion();
				o.setId(rs.getInt("id"));
				o.setNombre(rs.getString("nombre"));

				coleccion.add(o);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return coleccion;

	}

}
