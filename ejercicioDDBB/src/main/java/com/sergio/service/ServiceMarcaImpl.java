package com.sergio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sergio.beans.Marca;
import com.sergio.dao.DAOMarca;

@Service
public class ServiceMarcaImpl implements ServiceMarca {
	
	@Autowired
	private DAOMarca daoMarca;
	@Override
	public void registrar(Marca marca) throws Exception {
		try {
			daoMarca.registrar(marca);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
