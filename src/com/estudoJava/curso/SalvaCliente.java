package com.estudoJava.curso;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import com.estudoJava.curso.dao.ClienteDAO;
import com.estudoJava.curso.dao.DAOFactory;
import com.estudoJava.curso.modelo.Cliente;

public class SalvaCliente {
	public static void main(String[] args) throws Exception {
		
		UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		
		Cliente cliente = new Cliente();
		String nome = JOptionPane.showInputDialog(null, "Nome do cliente"
				, "Cadastro de cliente", JOptionPane.QUESTION_MESSAGE);
		
		if(nome != null) {
			cliente.setNome(nome);
			
			ClienteDAO clienteDAO = DAOFactory.getDaoFactory().getClienteDAO();
			clienteDAO.salvar(cliente);
			System.out.println("Cliente Salvo com sucesso");
		}
	}
}
