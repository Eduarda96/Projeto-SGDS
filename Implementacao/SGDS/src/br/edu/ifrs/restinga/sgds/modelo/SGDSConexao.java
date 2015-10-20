package br.edu.ifrs.restinga.sgds.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SGDSConexao {
	// Classe para realizar a conexão com o banco;
	public static Connection getSGDSConexao() {
		Connection conecta = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conecta = DriverManager.getConnection("jdbc:mysql://localhost/sgds_banco", "root", "cstads");
		} catch (ClassNotFoundException e) {
			System.out.println("Classe do driver2 não encontrada!\n" + e.getMessage());
		} catch (SQLException ex) {
			System.out.println("Não pode conectar!\n" + ex.getMessage());
		}
		return conecta;
	}
}
