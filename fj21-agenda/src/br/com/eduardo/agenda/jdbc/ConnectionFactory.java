package br.com.eduardo.agenda.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public Connection getConnection() throws ClassNotFoundException,SQLException{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost/fj21","root", "223580");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}catch(ClassNotFoundException e){
			throw new RuntimeException(e);
		}
	}

}