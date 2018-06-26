package com.sergio.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sergio.beans.Mundo;

@Configuration
public class AppConfig {
	//Ejemplo 1
	//Mapeando mediante anotaciones, el nombre del metodo 'mundo' sería el id
	@Bean
	public Mundo mundo() {
		return new Mundo();
	}
}
