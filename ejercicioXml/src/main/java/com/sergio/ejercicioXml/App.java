package com.sergio.ejercicioXml;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sergio.beans.Barcelona;
import com.sergio.beans.Juventus;
import com.sergio.beans.Jugador;

public class App {
	
    public static void main( String[] args ){
      
    	//EJERCICIO UTILIZANDO XML
    	
    	ApplicationContext appContextXml = new ClassPathXmlApplicationContext("com/sergio/xml/beansEjercicio.xml");
		Jugador messi = appContextXml.getBean("jugador", Jugador.class);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Elija un equipo: \n1-Barcelona  \n2-Juventus");
		int respuesta = sc.nextInt();
		
		switch (respuesta) {
		case 1:
			messi.setEquipo(new Barcelona());
			break;
			
		case 2:
			messi.setEquipo(new Juventus());
			break;

		default:
			System.out.println("Puto el que lee");
			break;
		}
		
		System.out.println("Jugador 1");
		System.out.println("ID: " + messi.getId()+ "\n" + "Nombre: " + messi.getNombre()+ "\n" + "Equipo: " + messi.getEquipo().mostrar()+ "\n" + "Camiseta: " + messi.getCamiseta().getNumero()+ "\n" + "Sponsor: " + messi.getCamiseta().getMarca().getNombre());
    }
}
