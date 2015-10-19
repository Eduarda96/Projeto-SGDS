package br.edu.ifrs.restinga.sgds.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
			System.out.println("Não foi possivel conectar!\n" + e.getMessage());
		}
		return ativos;
	}

	public void cadastrar(Setor setor) {
		int subordinado;
		if (setor.getSetorResponsavel() == null) {
			subordinado = 0;
		} else {
			subordinado = consultarSetor(setor.getSetorResponsavel().getCodSetor()).getCodSetor();
		}
		sql = "INSERT INTO SETOR (nome, nomeResponsavel, descricao, email, ativo, setorResponsavel) "
				+ "VALUES (?, ?, ?, ?, ?, ?);";

		try {
			comando = conexao.prepareStatement(sql);
			comando.setString(1, setor.getNome());
			comando.setString(2, setor.getNomeResponsavel());
			comando.setString(3, setor.getDescricao());
			comando.setString(4, setor.getEmail());
			comando.setBoolean(5, true);
			comando.setInt(6, subordinado);
			
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
		sql = "SELECT codSetor, nome, nomeResponsavel, setorResponsavel, descricao, email, ativo FROM SETOR WHERE codSetor = ?;";

		try {
			comando = conexao.prepareStatement(sql);
			comando.setInt(1, codSetor);
			retorno = comando.executeQuery();
			retorno.next();
			retornarSetor.setCodSetor(retorno.getInt("codSetor"));
			retornarSetor.setNome(retorno.getString("nome"));
			retornarSetor.setNomeResponsavel(retorno.getString("nomeResponsavel"));
			retornarSetor.setEmail(retorno.getString("email"));
			retornarSetor.setDescricao(retorno.getString("descricao"));
			comando.close();
		} catch (SQLException e) {
			System.out.println("Não foi possivel conectar!\n" + e.getMessage());
		}
		return retornarSetor;
	}

	public List<Setor> consultarTodosSetor() {
		sql = "SELECT codSetor, nome, nomeResponsavel, setorResponsavel, descricao, email, ativo FROM SETOR WHERE ativo = true;";
		List<Setor> setores = new ArrayList<Setor>();
		try {
			comando = conexao.prepareStatement(sql);
			retorno = comando.executeQuery();
			while (retorno.next()) {
				Setor setor = new Setor();
				setor.setCodSetor(retorno.getInt("codSetor"));
				setor.setNome(retorno.getString("nome"));
				setor.setNomeResponsavel(retorno.getString("nomeResponsavel"));
				if (retorno.getInt("setorResponsavel") > 0) {
					setor.setSetorResponsavel(new SetorDAO().consultarSetor(retorno.getInt("setorResponsavel")));
				} else {
					setor.setSetorResponsavel(null);
				}
				setor.setDescricao(retorno.getString("descricao"));
				setor.setEmail(retorno.getString("email"));
				setores.add(setor);
			}
			comando.close();
		} catch (SQLException e) {
			System.out.println("Não foi possivel conectar!\n" + e.getMessage());
		}
		return setores;
	}
}
