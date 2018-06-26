package com.sergio.beans;

import java.util.List;

public class Trabajador {
	private String nombre;
	private String apellido;
	private List<Oficios> oficio;
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public List<Oficios> getOficio() {
		return oficio;
	}
	public void setOficio(List<Oficios> oficio) {
		this.oficio = oficio;
	}
	
	
	
}
