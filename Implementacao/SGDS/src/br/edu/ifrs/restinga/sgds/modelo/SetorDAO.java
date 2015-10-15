package br.edu.ifrs.restinga.sgds.controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.edu.ifrs.restinga.sgds.modelo.Setor;

public class SetorDAO {
	// Manipular classe Setor no Banco;
	Connection conexao = SGDSConexao.getSGDSConexao();
	PreparedStatement comando;
	String sql = null;

	public void inserirSetor(Setor setor) {
		sql = "INSERT INTO SETOR (nome, nomeResponsavel, setorResponsavel, descricao, email) " +
				"VALUES (?, ?, ?, ?, ?);";
		try {
			comando = conexao.prepareStatement(sql);
			comando.setString(1, setor.getNome());
			comando.setString(2, setor.getNomeResponsavel());
			comando.setString(3, setor.getSetorResponsavel().getNome());
			comando.setString(4, setor.getDescricao());
			comando.setString(5, setor.getEmail());
			
			comando.execute();
			comando.close();
		} catch (SQLException e) {
			System.out.println("Não foi possivel cadastrar!\n" + e.getMessage());
		}
	}

	public void alterarSetor() {

	}

	public void deletarSetor() {

	}

	public void consultarSetor() {

	}

	public void consultarTodosSetor() {

	}
}
