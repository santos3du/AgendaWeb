package br.com.eduardo.agenda.testes;

import java.sql.SQLException;

import br.com.eduardo.agenda.dao.UsuarioDao;
import br.com.eduardo.agenda.modelo.Usuario;

public class TestaLogin {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Usuario user = new Usuario();

		user.setUsuario("eduardo");
		user.setSenha("eduardo");
		
		Usuario usuario = new Usuario();
		UsuarioDao dao = new UsuarioDao();
		dao.consultaLogin(user);
		
		if(usuario.equals(user)){
			System.out.println("São iguais");
		}else{
			System.out.println("São diferentes");
		}
	}
}
