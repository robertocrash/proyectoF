package com.elorrieta.cms.modelo;

import java.util.ArrayList;

public class Personaje {

	private int id;
	private String nombre;
	private Nacionalidad nacionalidad;
	private Ocupacion ocupacion;
	private ArrayList<Rol> roles;
	private int poderAtaque;
	private int vida;
	private int mana;
	private int defensa;

	public Personaje() {
		super();
		this.id = 0;
		this.nombre = "";
		this.nacionalidad = new Nacionalidad();
		this.ocupacion = new Ocupacion();
		this.roles = new ArrayList<Rol>();
		this.poderAtaque = 0;
		this.vida = 0;
		this.mana = 0;
		this.defensa = 0;

	}

	public int getPoderAtaque() {
		return poderAtaque;
	}

	public void setPoderAtaque(int poderAtaque) {
		this.poderAtaque = poderAtaque;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}

	public int getDefensa() {
		return defensa;
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
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

	public Nacionalidad getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(Nacionalidad nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public Ocupacion getOcupacion() {
		return ocupacion;
	}

	public void setOcupacion(Ocupacion ocupacion) {
		this.ocupacion = ocupacion;
	}

	public ArrayList<Rol> getRoles() {
		return roles;
	}

	public void setRoles(ArrayList<Rol> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "Personaje [id=" + id + ", nombre=" + nombre + ", nacionalidad=" + nacionalidad + ", ocupacion="
				+ ocupacion + ", roles=" + roles + ", poderAtaque=" + poderAtaque + ", vida=" + vida + ", mana=" + mana
				+ ", defensa=" + defensa + "]";
	}

}