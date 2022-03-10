package com.estudoJava.curso.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

import com.estudoJava.curso.dao.ClienteDAO;
import com.estudoJava.curso.dao.DAOFactory;

public class JdbcDAOFactory extends DAOFactory {
	
	private Connection connection; //criando uma conex�o com o sql
	
	public JdbcDAOFactory() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");			//String de conex�o				//nome de usuario	//senha
			this.connection = DriverManager.getConnection("jdbc:mysql://localhost/cadastro_cliente", "root", "auhpuk260202");
			
			
		}catch(Exception e) {
			throw new RuntimeException("Erro recuperando conex�o com o banco", e);
		}
	}

	
	public ClienteDAO getClienteDAO() {
		return new JdbcClienteDao(connection);
	}
}
