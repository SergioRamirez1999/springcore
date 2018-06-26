package com.sergio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sergio.beans.Jugador;
import com.sergio.dao.DAOJugador;

@Service
public class ServiceJugadorImpl implements ServiceJugador {
	
	@Autowired
	private DAOJugador daoJugador;
	@Override
	public void registrar(Jugador jug) throws Exception {
		try {
			daoJugador.registrar(jug);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
