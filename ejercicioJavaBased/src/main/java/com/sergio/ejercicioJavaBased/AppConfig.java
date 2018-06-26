package com.sergio.ejercicioJavaBased;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sergio.beans.Barcelona;
import com.sergio.beans.Camiseta;
import com.sergio.beans.Jugador;
import com.sergio.beans.Juventus;
import com.sergio.beans.Marca;

//Se debe declarar a la clase como @Configuration
@Configuration
public class AppConfig {
	
	//UTILIZACION DE JAVABASED PARA LA CREACIÓN DE BEANS UTILIZANDO CÓDIGO JAVA PURO
	
	//Los métodos retornarán la instancia del bean
	//Hay que marcarlos como @Bean
	@Bean
	public Jugador jugador() {
		return new Jugador();
	}
	@Bean
	public Camiseta camiseta() {
		return new Camiseta();
	}
	@Bean
	public Marca marca() {
		return new Marca();
	}
	@Bean
	public Barcelona barcelona() {
		return new Barcelona();
	}
	@Bean
	public Juventus juventus() {
		return new Juventus();
	}
}
