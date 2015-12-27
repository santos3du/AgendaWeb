package br.com.eduardo.agenda.dao;
/**
 * @author eduardo
 * Classe com métodos de manipulação de dados do objeto Contato
 * 
 * @version 1.0
 * 
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.sql.Date;

import br.com.eduardo.agenda.jdbc.ConnectionFactory;
import br.com.eduardo.agenda.modelo.Contato;


/**
 * @author eduardo
 *
 */
public class ContatoDAO {
	private Connection connection;

	public ContatoDAO() throws ClassNotFoundException, SQLException {
		this.connection = new ConnectionFactory().getConnection()	;
	}
	
	
	public void adiciona(Contato contato){
		String sql = "insert into contatos (nome,email,endereco,dataNascimento)"+
	"values(?,?,?,?)";
		
		try {
			/**
			 * Preparando o statement de inserção.
			 * 
			 */
			
			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setString(1, contato.getNome());
			pstm.setString(2, contato.getEmail());
			pstm.setString(3, contato.getEndereco());
			pstm.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			
			//executa a query de inserção.
			pstm.execute();
			pstm.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
			
		}
		
	}
	
	public List<Contato> getLista(){
		try {
			List<Contato> contatos = new ArrayList<Contato>();
			PreparedStatement pstm = this.connection.prepareStatement("select * from contatos");
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()){
				Contato contato = new Contato();
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				contato.setDataNascimento(data);
				contatos.add(contato);
			}
			rs.close();
			pstm.close();
			
			return contatos;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public void altera(Contato contato){
		String sql = "update contatos set nome=?, email=?, endereco=?, "+
	"dataNascimento=? where id=?";
		
		try {
			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setString(1, contato.getNome());
			pstm.setString(2, contato.getEmail());
			pstm.setString(3, contato.getEndereco());
			pstm.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			pstm.setLong(5, contato.getId());
			
			pstm.execute(sql);
			pstm.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void remove(Contato contato){
		try {
			PreparedStatement pstm = connection.prepareStatement("delete from contatos where id=?");
			pstm.setLong(1, contato.getId());
			pstm.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
