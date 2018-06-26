package com.sergio.jdbcSpring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sergio.jdbcSpring.dao.ServiceStudentImpl;
import com.sergio.jdbcSpring.entities.Student;

public class App {
	
    public static void main( String[] args ) {
    	ApplicationContext appContext = new ClassPathXmlApplicationContext("com/sergio/xml/beans.xml");
    	ServiceStudentImpl serviceSt = appContext.getBean("studentImpl", ServiceStudentImpl.class);
    	Student objSt = appContext.getBean("student", Student.class);
    	try {
			serviceSt.savePrepared(objSt);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
}
