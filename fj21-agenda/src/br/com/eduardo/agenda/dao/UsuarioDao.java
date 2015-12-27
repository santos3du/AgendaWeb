package br.com.eduardo.agenda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.eduardo.agenda.jdbc.ConnectionFactory;
import br.com.eduardo.agenda.modelo.Usuario;

public class UsuarioDao {
	private Connection con;
	
	public UsuarioDao()throws ClassNotFoundException, SQLException{
		this.con = new ConnectionFactory().getConnection();
	}
	
	public Usuario consultaLogin(Usuario usuario){
		String sql = "select * from usuarios where id=?";
		
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setLong(1, usuario.getId());
			ResultSet rs = pstm.executeQuery();
			
			/*while(rs.next()){
				usuario = new Usuario();
				usuario.setId(rs.getLong("id"));
				usuario.setUsuario(rs.getString("usuario"));
				usuario.setSenha(rs.getString("senha"));
			}*/
			
			rs.close();
			pstm.close();
			return usuario;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
}
