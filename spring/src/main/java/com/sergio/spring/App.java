package com.sergio.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sergio.beans.Animal;
import com.sergio.beans.Ciudadano;
import com.sergio.beans.Humano;
import com.sergio.beans.Jugador;
import com.sergio.beans.Mundo;
import com.sergio.beans.Oficios;
import com.sergio.beans.Persona;
import com.sergio.beans.Trabajador;
import com.sergio.beans.interfaces.IEquipo;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Ejemplo 1: xml
		
		//Forma con beans mapeados en el xml
		//Ya que nuestro xml está en otro directorio, debemos indicárselo en el constructor
		//ApplicationContext appContext = new ClassPathXmlApplicationContext("com/sergio/xml/beans.xml");
		
		//Ejemplo 1: annotations
		//Forma con annotations
		//Pasamos por parámetros la clase que contiene nuestros beans
		//ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class, AppConfig2.class);
		
		System.out.println("---------Ejemplo 1: Seteo de propiedades usando Annotations---------");
		//Es lo mismo que utilizar ApplicationContext pero más ordenado al indicarle las clases mediante un método(register()).
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
		appContext.register(AppConfig.class);
		appContext.register(AppConfig2.class);
		
		//Este método reconstruye el archivo de configuración con todos los archivos java que contienen las definiciones de los beans
		appContext.refresh();
		
		//Indicamos el bean mediante el id que le seteamos y como segundo parámetro el tipo de obj(O podemos hacer un casteo a (Mundo))
		Mundo objMarte = appContext.getBean("marte", Mundo.class);
		Mundo objMundo = appContext.getBean("mundo", Mundo.class);
		
		System.out.println(objMarte.getSaludo());
		System.out.println(objMundo.getSaludo());
		
		//Cerrar el recurso
		((ConfigurableApplicationContext)appContext).close();
		
		
		//-------------------EJEMPLO 2: Inyeccion mediante Constructores ------------------------------
		System.out.println();
		System.out.println();
		System.out.println("------EJEMPLO 2: Inyeccion mediante Constructor-------");
		ApplicationContext appContextXml = new ClassPathXmlApplicationContext("com/sergio/xml/beans.xml");
		Persona objPer = appContextXml.getBean("persona", Persona.class);
		System.out.println(".........Utilizando el constructor(constructor-tag):.........");
		System.out.println(objPer.getId()+ " " +objPer.getNombre() + " " +objPer.getApodo());
		
		//Ejemplo 2: Diferenciando constructores
		
		Persona objPer2 = appContextXml.getBean("persona2", Persona.class);
		//Si eliminamos el tag type del bean, utilizará el constructor (String) ---> 0 null 1
		System.out.println(".......Utilización de propiedad type:........");
		System.out.println(objPer2.getId()+ " " +objPer2.getNombre() + " " +objPer2.getApodo());
		
		Persona objPer3 = appContextXml.getBean("persona3", Persona.class);
		System.out.println(".......Utilización de la propiedad index:........");
		System.out.println(objPer3.getId()+ " " +objPer3.getNombre() + " " +objPer3.getApodo());
		
		//-------------------EJEMPLO 3: Inyeccion de objetos--------------------------------
		System.out.println();
		System.out.println();
		System.out.println("------EJEMPLO 3: Inyeccion de objetos-------");
		Animal objAni = appContextXml.getBean("animal", Animal.class);
		System.out.println(".........Utilizando propiedad ref:.........");
		System.out.println(objAni.getEspecie() +" "+objAni.getReino().getNombre()+" "+objAni.getClasificacion()+" "+objAni.getSalvaje());
		System.out.println("...........Accediendo a una referencia de una referencia(Ambiente)........");
		System.out.println(objAni.getEspecie() +" "+objAni.getReino().getAmbiente().getNombre()+" "+objAni.getClasificacion()+" "+objAni.getSalvaje());
		
		//-------------------EJEMPLO 4: Beans Anidados -------------------------------------
		System.out.println();
		System.out.println();
		System.out.println("------EJEMPLO 4: Beans anidados-------");
		Animal objAni2 = appContextXml.getBean("animal2", Animal.class);
		System.out.println("...........Beans Anidados..........");
		System.out.println(objAni2.getEspecie() +" "+objAni2.getReino().getNombre()+" "+objAni2.getClasificacion()+" "+objAni2.getSalvaje());
		System.out.println(objAni.getEspecie() +" "+objAni.getReino().getAmbiente().getNombre()+" "+objAni.getClasificacion()+" "+objAni.getSalvaje());
		
		//------------------Ejemplo 5: Colecciones------------------------------------------
		System.out.println();
		System.out.println();
		System.out.println("--------Ejemplo 5: Colecciones--------------");
		System.out.println(".........Utilización de tag list y ref.......");
		String oficios = "";
		Trabajador objTrabajador = appContextXml.getBean("trabajador", Trabajador.class);
		for(Oficios tempOfi: objTrabajador.getOficio()) {
			oficios += tempOfi.getOficio() +"-";
		}
		
		System.out.println(objTrabajador.getNombre() + " " + objTrabajador.getApellido() + " " + oficios);
		
		//-----------------Ejemplo 6: autowire-----------------------------------------------
		System.out.println();
		System.out.println();
		System.out.println("--------Ejemplo 6: Autowire------------");
		System.out.println("........Utilización property autowire='byName'..........");
		Ciudadano objCiud = appContextXml.getBean("ciudadano", Ciudadano.class);
		Ciudadano objCiud2 = appContextXml.getBean("ciudadano2", Ciudadano.class);
		System.out.println(objCiud.getDni() + " " + objCiud.getNombre() + " " + objCiud.getApellido() + " " + objCiud.getPais().getNombre() + " " + objCiud.getPais().getCiudad().getNombre());
		System.out.println("........Utilización de property autowire='byType'.............");
		System.out.println(objCiud2.getDni() + " " + objCiud2.getNombre() + " " + objCiud2.getApellido() + " " + objCiud2.getPais().getNombre() + " " + objCiud2.getPais().getCiudad().getNombre());
		
		
		//---------------Ejemplo 7: Utilización de interfaces--------------
		//.........................VIDEO 18................................
		System.out.println();
		System.out.println();
		System.out.println("--------Ejemplo 7: Interfaces------------");
		Jugador jug = appContextXml.getBean("messi", Jugador.class);
		IEquipo equipo = appContextXml.getBean("barcelona", IEquipo.class);
		System.out.println("......Utilizando annotation required, autowired y qualifier......");
		System.out.println(equipo.mostrar());
		System.out.println(jug.getNombre() + " " + jug.getEquipo().mostrar());
		
		//-------------Ejemplo 8: Utilización de Stereotypes---------------
		System.out.println();
		System.out.println();
		System.out.println("--------Ejemplo 8: Stereotypes-----------");
		Humano objHum = appContextXml.getBean("humano", Humano.class);
		System.out.println(objHum.getDni() + " " + objHum.getNombre() + " " + objHum.getApellido());
		
		
		//Cerrar el recurso
		((ConfigurableApplicationContext)appContextXml).close();
	}

}
