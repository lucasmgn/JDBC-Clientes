package com.estudoJava.curso.dao;

import java.util.List;

import com.estudoJava.curso.modelo.Cliente;

public interface ClienteDAO {
	
	public void salvar(Cliente cliente);

	public Cliente buscarPeloCodigo(Long codigo);

	public List<Cliente> buscarTodos();
}
