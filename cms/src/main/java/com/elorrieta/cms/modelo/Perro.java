package com.elorrieta.cms.modelo;

public class Perro {

	private int id;
	private String nombre;
	private String historia;
	private Raza raza;

	public Perro() {
		super();
		this.id = 0;
		this.nombre = "";
		this.historia = "";
		this.raza = new Raza();
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

	public String getHistoria() {
		return historia;
	}

	public void setHistoria(String historia) {
		this.historia = historia;
	}

	public Raza getRaza() {
		return raza;
	}

	public void setRaza(Raza raza) {
		this.raza = raza;
	}

	@Override
	public String toString() {
		return "Perro [id=" + id + ", nombre=" + nombre + ", historia=" + historia + ", raza=" + raza + "]";
	}

}
