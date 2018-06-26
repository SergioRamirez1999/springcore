package com.sergio.beans;

import org.springframework.stereotype.Component;

import com.sergio.interfaces.IEquipo;
@Component
public class Barcelona implements IEquipo{

	public String mostrar() {
		return "Barcelona FC";
	}
	
}
