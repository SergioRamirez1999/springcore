package com.sergio.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sergio.beans.Mundo;

@Configuration
public class AppConfig2 {
	//Ejemplo 1
	@Bean
	public Mundo marte() {
		return new Mundo();
	}
}
