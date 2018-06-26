package com.sergio.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;

import com.sergio.beans.interfaces.IEquipo;

public class Jugador {

	private int id;
	private String nombre;
	@Autowired
	@Qualifier("barcelonaQualifier")
	private IEquipo equipo;
	
	public int getId() {
		return id;
	}
	@Required
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	@Required
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public IEquipo getEquipo() {
		return equipo;
	}
	
	public void setEquipo(IEquipo equipo) {
		this.equipo = equipo;
	}

	@Override
	public String toString() {
		return "Jugador [id=" + id + ", nombre=" + nombre + ", equipo=" + equipo + "]";
	}
	
	
}
