package com.elorrieta.cms.modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionHelper implements AutoCloseable {

	private static Connection con = null;
	private static final String DIRECCION_BBDD = "jdbc:sqlite:C:\\desarrolloJava\\workspace\\cms\\personajes.db";

	public static Connection getConnection() throws Exception {

		// cargar el driver de sqlite
		Class.forName("org.sqlite.JDBC");

		con = DriverManager.getConnection(DIRECCION_BBDD);

		return con;
	}

	@Override
	public void close() throws Exception {

		if (con != null) {
			con.close();
		}

	}

}
