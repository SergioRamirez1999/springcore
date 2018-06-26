package com.sergio.beans;

public class Animal {

	private String especie;
	private Reino reino;
	private String clasificacion;
	private boolean salvaje;
	
	public Animal() {
		
	}
	
	public Animal(String especie, Reino reino, String clasificacion, boolean salvaje) {
		this.especie = especie;
		this.reino = reino;
		this.clasificacion = clasificacion;
		this.salvaje = salvaje;
	}
	
	@Override
	public String toString() {
		return "Animal [especie=" + especie + ", reino=" + reino.getNombre() + ", clasificacion=" + clasificacion + ", salvaje="
				+ salvaje + "]";
	}
	
	public String getEspecie() {
		return especie;
	}
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	public Reino getReino() {
		return reino;
	}
	public void setReino(Reino reino) {
		this.reino = reino;
	}
	public String getClasificacion() {
		return clasificacion;
	}
	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}
	public boolean getSalvaje() {
		return salvaje;
	}
	public void setSalvaje(boolean salvaje) {
		this.salvaje = salvaje;
	}
	
	
}
