package com.sergio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sergio.beans.Marca;

@Repository
public class DAOMarcaImpl implements DAOMarca {
	
	//Si no usamos autowired deberíamos crear un bean en el xml
	@Autowired
	private DataSource dataSource;
	
	@Override
	public void registrar(Marca marca) throws Exception {
		
		String sql = "INSERT INTO marcas(id,nombre) VALUES(?,?)";
		Connection cn = null;
		try {
			cn = dataSource.getConnection();
			PreparedStatement pst = cn.prepareStatement(sql);
			pst.setInt(1, marca.getId());
			pst.setString(2, marca.getNombre());
			pst.executeUpdate();
			pst.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			if(cn != null) {
				cn.close();
			}
		}
		
		
	}
	
}
