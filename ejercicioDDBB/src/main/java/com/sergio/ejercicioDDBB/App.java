package com.sergio.ejercicioDDBB;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sergio.beans.Equipo;
import com.sergio.beans.Jugador;
import com.sergio.beans.Marca;
import com.sergio.service.ServiceJugador;
import com.sergio.service.ServiceMarca;

public class App {
	
    public static void main( String[] args ) {
        
    	
    	ApplicationContext appContextXml = new ClassPathXmlApplicationContext("com/sergio/xml/beans.xml");
    	
    	//Comunicamos mediante la capa de servicios con la capa de datos.
    	
    	ServiceMarca sm = appContextXml.getBean("serviceMarcaImpl", ServiceMarca.class);
    	Marca mar3 = appContextXml.getBean("marca1", Marca.class);
    	
    	
    	/*//ESTO DA ERROR POR COSAS DE SQL DE CLAVES FORANEAS QUE NO ENTIENDO
    	ServiceJugador sj = appContextXml.getBean("serviceJugadorImpl", ServiceJugador.class);
    	Jugador jug = appContextXml.getBean("jugador1", Jugador.class);*/
    	
    	try {
			sm.registrar(mar3);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
    	
    	
    	
    	
    	
    }
}
