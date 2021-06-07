package com.elorrieta.cms.modelo;

public class Usuario {

	public static final int ROL_USUARIO = 1;
	public static final int ROL_ADMIN = 2;

	private int id;
	private String nombre;
	private String password;
	private int rol;

	public Usuario() {
		super();
		this.id = 0;
		this.nombre = "";
		this.password = "";
		this.rol = ROL_USUARIO;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRol() {
		return rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", password=" + password + ", rol=" + rol + "]";
	}

}
