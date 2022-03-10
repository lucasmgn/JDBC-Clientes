package com.estudoJava.curso;

import java.util.List;

import com.estudoJava.curso.dao.ClienteDAO;
import com.estudoJava.curso.dao.DAOFactory;
import com.estudoJava.curso.modelo.Cliente;

public class BuscaTodosClientes {

	public static void main(String[] args) {
		ClienteDAO clienteDAO = DAOFactory.getDaoFactory().getClienteDAO();
		
		List<Cliente> clientes = clienteDAO.buscarTodos();
		
		for (Cliente cliente : clientes) {
			System.out.println("------ Cliente ------");
			System.out.printf("Código: %d\n", cliente.getCodigo());
			System.out.printf("Nome: %s\n", cliente.getNome());
			System.out.println();
		}

	}

}
