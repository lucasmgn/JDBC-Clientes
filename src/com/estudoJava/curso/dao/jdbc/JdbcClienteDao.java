package com.estudoJava.curso.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.estudoJava.curso.dao.ClienteDAO;
import com.estudoJava.curso.dao.DAOException;
import com.estudoJava.curso.modelo.Cliente;

public class JdbcClienteDao implements ClienteDAO {

	private Connection connection;

	public JdbcClienteDao(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void salvar(Cliente cliente) {
		try {
			String sql = String.format("insert into cliente(nome) values ('%s')", cliente.getNome());

			PreparedStatement ps = this.connection.prepareStatement(sql);
			ps.executeUpdate();

		} catch (SQLException e) {
			throw new DAOException("Erro salvando cliente ", e);
		} finally {
			try {
				this.connection.close();
			} catch (Exception e) {
			}
		}

	}

	@Override
	public Cliente buscarPeloCodigo(Long codigo) {
		Cliente cliente = null;

		try {
			String sql = String.format("select * from cliente where codigo = %d", codigo);
			PreparedStatement ps = this.connection.prepareStatement(sql);

			// Resulte Set como se fosse uma tabela
			ResultSet rs = ps.executeQuery();// executa a consulta
			while (rs.next()) {
				cliente = new Cliente();
				cliente.setCodigo(rs.getLong("codigo"));
				cliente.setNome(rs.getString("nome"));
			}

		} catch (SQLException e) {
			throw new DAOException("Erro buscando cliente", e);
		} finally {
			try {
				this.connection.close();
			} catch (Exception e) {
			}
		}

		return cliente;
	}

	@Override
	public List<Cliente> buscarTodos() {
		List<Cliente> clientes = new ArrayList<>(); 
		try {
			String sql = "select * from cliente";
			PreparedStatement ps = this.connection.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setCodigo(rs.getLong("codigo"));
				cliente.setNome(rs.getString("nome"));
				
				clientes.add(cliente);
			}
			
		} catch (SQLException e) {
			throw new DAOException("Erro buscando cliente", e);
		} finally {
			try {
				this.connection.close();
			} catch (Exception e) {
			}
		}
		return clientes;
	}
}
