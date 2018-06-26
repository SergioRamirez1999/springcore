package com.sergio.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class EjemploBeanPostProcessor implements BeanPostProcessor {

	public Object postProcessAfterInitialization(Object bean, String nombreBean) throws BeansException {
		System.out.println("Después de la inicialización de cada Bean");
		return bean;
		
	}

	public Object postProcessBeforeInitialization(Object bean, String nombreBean) throws BeansException {
		System.out.println("Antes de la inicialización de cada Bean");
		return bean;
	}
	
}
