package com.elorrieta.cms.modelo;

public class Participante {

	private int id;
	private String nombre;
	private String apellidos;
	private String email;
	private String avatar;

	public Participante() {
		super();
		this.id = 0;
		this.nombre = "";
		this.apellidos = "";
		this.email = "";
		this.avatar = "https://randomuser.me/api/portraits/men/1.jpg";
	}

	public Participante(String nombre, String apellidos) {
		this();
		this.nombre = nombre;
		this.apellidos = apellidos;
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

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	@Override
	public String toString() {
		return "Participante [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", email=" + email
				+ ", avatar=" + avatar + "]";
	}

}
