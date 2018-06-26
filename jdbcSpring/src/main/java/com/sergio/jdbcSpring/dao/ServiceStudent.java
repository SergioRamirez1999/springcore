package com.sergio.jdbcSpring.dao;

import com.sergio.jdbcSpring.entities.Student;

public interface ServiceStudent {
	public void save(Student student) throws Exception;
	public void update(Student student) throws Exception;
	public void delete(Student student) throws Exception;
}
