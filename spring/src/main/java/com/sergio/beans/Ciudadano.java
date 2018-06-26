package com.sergio.beans;

public class Ciudadano {
	private int dni;
	private String nombre;
	private String apellido;
	private Pais pais;
	
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
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
	public Pais getPais() {
		return pais;
	}
	public void setPais(Pais pais) {
		this.pais = pais;
	}
	private void init() {
		System.out.println("Método ejecutado antes de la inicialización");
	}
	private void destroy() {
		System.out.println("Método ejecutado despúes de la destrucción");
	}
	
	
}
