package com.estudoJava.curso.dao;

import com.estudoJava.curso.dao.jdbc.JdbcDAOFactory;

public abstract class DAOFactory {
	public static DAOFactory getDaoFactory() {
		
		return new JdbcDAOFactory();
	}
	
	public abstract ClienteDAO getClienteDAO();
}
