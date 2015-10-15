package br.edu.ifrs.restinga.sgds.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SetorDAO {
	// Manipular classe Setor no Banco;
	Connection conexao = SGDSConexao.getSGDSConexao();
	PreparedStatement comando;
	String sql = null;
	ResultSet retorno;

	public List<Setor> listarSetorAtivo() {
		sql = "SELECT codSetor, nome FROM SETOR WHERE ativo = true;";
		List<Setor> ativos = new ArrayList<Setor>();
		try {
			comando = conexao.prepareStatement(sql);
			retorno = comando.executeQuery();
			while (retorno.next()) {
				Setor setor = new Setor();
				setor.setCodSetor(retorno.getInt("codSetor"));
				setor.setNome(retorno.getString("nome"));
				ativos.add(setor);
			}
			comando.close();
		} catch (SQLException e) {
			System.out.println("Não foi possivel conectar " + e.getMessage());
		}
		return ativos;
	}

	public void cadastrar(Setor setor) {
		sql = "INSERT INTO SETOR (nome, nomeResponsavel, setorResponsavel, descricao, email, ativo) "
				+ "VALUES (?, ?, ?, ?, ?, ?);";
		try {
			comando = conexao.prepareStatement(sql);
			comando.setString(1, setor.getNome());
			comando.setString(2, setor.getNomeResponsavel());
			comando.setInt(3, setor.getSetorResponsavel().getCodSetor());
			comando.setString(4, setor.getDescricao());
			comando.setString(5, setor.getEmail());
			comando.setBoolean(6, true);

			comando.execute();
			comando.close();
			System.out.println("Setor cadastrado com sucesso");
		} catch (SQLException e) {
			System.out.println("Não foi possivel cadastrar!\n" + e.getMessage());
		}
	}

	public void alterarSetor() {

	}

	public void deletarSetor() {

	}

	public Setor consultarSetor(int codSetor) {
		Setor retornarSetor = new Setor();
		sql = "SELECT nome, nomeResponsavel, setorResponsavel, descricao, email, ativo FROM SETOR WHERE codSetor = ?;";

		try {
			comando = conexao.prepareStatement(sql);
			comando.setInt(1, codSetor);
			retorno = comando.executeQuery();
			retorno.next();
			retornarSetor.setNome(retorno.getString("nome"));
			retornarSetor.setNomeResponsavel(retorno.getString("nomeResponsavel"));
			retornarSetor.setEmail(retorno.getString("email"));
			retornarSetor.setDescricao(retorno.getString("descricao"));
			comando.close();
		} catch (SQLException e) {
			System.out.println("Não foi possivel conectar " + e.getMessage());
		}
		return retornarSetor;
	}

	public void consultarTodosSetor() {

	}
}
