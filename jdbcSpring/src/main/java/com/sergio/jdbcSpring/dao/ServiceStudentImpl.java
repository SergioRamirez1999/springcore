package com.sergio.jdbcSpring.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;

import com.sergio.jdbcSpring.entities.Student;

public class ServiceStudentImpl implements ServiceStudent {
	private JdbcTemplate jt;

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}

	public void save(Student student) throws Exception {
		String sql = "INSERT INTO student (NAME, AGE) VALUES (?,?)";
		jt.update(sql, student);
	}

	public Boolean savePrepared(final Student e){  
	    String query="insert into students (NAME, AGE) values(?,?)";  
	    return jt.execute(query,new PreparedStatementCallback<Boolean>(){  
	    public Boolean doInPreparedStatement(PreparedStatement ps)  
	            throws SQLException, DataAccessException {  
	               
	        ps.setString(1,e.getName());  
	        ps.setFloat(2,e.getAge());  
	              
	        return ps.execute();  
	              
	    }  
	    });  
	}

	public void update(Student student) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void delete(Student student) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
