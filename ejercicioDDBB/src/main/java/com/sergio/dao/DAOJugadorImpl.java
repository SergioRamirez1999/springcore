package com.sergio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sergio.beans.Jugador;

@Repository
public class DAOJugadorImpl implements DAOJugador {
	
	@Autowired
	private DataSource dataSource;
	@Override
	public void registrar(Jugador jugador) throws Exception {
		
		String sql = "INSERT INTO jugadores(ID,NOMBRE,IDEQUIPO,IDCAMISETA) VALUES(?,?,?,?)";
		Connection cn = null;
		try {
			cn = dataSource.getConnection();
			PreparedStatement pst = cn.prepareStatement(sql);
			pst.setInt(1, jugador.getId());
			pst.setString(2, jugador.getNombre());
			pst.setInt(3, jugador.getEquipo().getId());
			pst.setInt(4, jugador.getCamiseta().getId());
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
