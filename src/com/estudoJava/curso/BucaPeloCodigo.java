package com.estudoJava.curso;

import com.estudoJava.curso.dao.ClienteDAO;
import com.estudoJava.curso.dao.DAOFactory;
import com.estudoJava.curso.modelo.Cliente;

public class BucaPeloCodigo {
 public static void main(String[] args) {
	
	 ClienteDAO clienteDAO = DAOFactory.getDaoFactory().getClienteDAO();
	 
	 Cliente cliente = clienteDAO.buscarPeloCodigo(2L);
	 
	 if (cliente != null) {
			System.out.println("------ Cliente encontrado ------");
			System.out.printf("Código: %d\n", cliente.getCodigo());
			System.out.printf("Nome: %s\n", cliente.getNome());
			System.out.println();
		} else {
			System.out.println("Nenhum cliente encontrado.");
		}
}
}
