package com.sergio.beans;

import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Mundo {
	//Ejemplo1
	//Con annotations los valores por defecto se setean así.
	//Con el value descomentado de error en el video 20 al hacer el autowired
	//@Value("Hola mundos!")
	private String saludo;

	public Mundo() {
		
	}

	public Mundo(String saludo) {
		this.saludo = saludo;
	}

	public String getSaludo() {
		return saludo;
	}
	
	public void setSaludo(String saludo) {
		this.saludo = saludo;
	}
	@PostConstruct
	private void init() {
		System.out.println("Inicial");
	}
	@PreDestroy
	private void destroy() {
		System.out.println("Destruccion");
	}
	
}
