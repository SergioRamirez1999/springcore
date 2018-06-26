package com.sergio.beans;

import org.springframework.stereotype.Component;

import com.sergio.interfaces.IEquipo;
@Component
public class Juventus implements IEquipo {

	public String mostrar() {
		return "Juventus";
	}
	
}
