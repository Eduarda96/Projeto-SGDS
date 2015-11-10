package br.edu.ifrs.restinga.sgds.modelo;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SetorDAO {
	// Manipular classe Setor no Banco;
	PreparedStatement comando;
	private static final String sqlSelecaoSetorResponsavel = "SELECT codSetor, nome FROM SETOR WHERE ativo = true;";
	private static final String sqlCadastrar = "INSERT INTO SETOR (nome, nomeResponsavel, descricao, email, ativo, setorResponsavel) "
			+ "VALUES (?, ?, ?, ?, ?, ?);";
	private static final String sqlConsultarSetor = "SELECT codSetor, nome, nomeResponsavel, setorResponsavel, descricao, email, ativo FROM SETOR WHERE codSetor = ?;";
	private static final String sqlConsultarSetoresAtivos = "SELECT codSetor, nome, nomeResponsavel, setorResponsavel, descricao, email, ativo FROM SETOR WHERE ativo = true;";
	ResultSet retorno;
	private static final String sqlVerificarSetor = "SELECT COUNT(*) AS verificar FROM SETOR WHERE setorResponsavel = ?";
	private static final String sqlDeletarSetor = "UPDATE SETOR  SET ativo = 0 WHERE (codSetor = ?) ";
	private static String msg = null;

	public void cadastrar(Setor setor) throws Exception {
		Connection conexao = null;
		int subordinado;
		if (setor.getSetorResponsavel() == null) {
			subordinado = 0;
		} else {
			subordinado = consultarSetor(
					setor.getSetorResponsavel().getCodSetor()).getCodSetor();
		}
		try {
			conexao = SGDSConexao.getSGDSConexao();
			comando = conexao.prepareStatement(sqlCadastrar);
			comando.setString(1, setor.getNome());
			comando.setString(2, setor.getNomeResponsavel());
			comando.setString(3, setor.getDescricao());
			comando.setString(4, setor.getEmail());
			comando.setBoolean(5, true);
			comando.setInt(6, subordinado);

			comando.execute();
			// System.out.println("Setor cadastrado com sucesso");
		} catch (SQLException e) {
			System.out.println("Não foi possivel cadastrar!\n"
					+ e.getMessage());
		} finally {
			if (comando != null)
				comando.close();
			if (conexao != null)
				conexao.close();
		}
	}

	public void alterarSetor() throws Exception {

	}

	public String deletarSetor(int cod) throws Exception {
		Connection conexao = null;

		// Setor deletarSetor = new Setor();
		try {
			conexao = SGDSConexao.getSGDSConexao();
			comando = conexao.prepareStatement(sqlVerificarSetor);
			comando.setInt(1, cod);

			retorno = comando.executeQuery();
			retorno.next();
			int cont = Integer.parseInt(retorno.getString("verificar"));

			if (cont == 0) {
				comando = conexao.prepareStatement(sqlDeletarSetor);
				comando.setInt(1, cod);
				comando.execute();
				msg = "Excluido com sucesso!";
			} else {
				msg = "Não foi possivel excluir, verefique se n�o h� dados relacionados!";
			}
		} catch (SQLException e) {
			msg = "Não foi possivel excluir!\n" + e.getMessage();
		} finally {
			if (comando != null)
				comando.close();
			if (conexao != null)
				conexao.close();
		}
		return msg;
	}

	public Setor consultarSetor(int codSetor) throws Exception {
		Connection conexao = null;
		Setor retornarSetor = new Setor();
		try {
			conexao = SGDSConexao.getSGDSConexao();
			comando = conexao.prepareStatement(sqlConsultarSetor);
			comando.setInt(1, codSetor);
			retorno = comando.executeQuery();
			retorno.next();
			retornarSetor.setCodSetor(retorno.getInt("codSetor"));
			retornarSetor.setNome(retorno.getString("nome"));
			retornarSetor.setNomeResponsavel(retorno
					.getString("nomeResponsavel"));
			retornarSetor.setEmail(retorno.getString("email"));
			retornarSetor.setDescricao(retorno.getString("descricao"));
		} catch (SQLException e) {
			System.out
					.println("Não foi possivel conectar!\n" + e.getMessage());
		} finally {
			if (comando != null)
				comando.close();
			if (conexao != null)
				conexao.close();
		}
		return retornarSetor;
	}

	public List<Setor> consultarSetoresAtivos() throws Exception {
		Connection conexao = null;
		List<Setor> setores = new ArrayList<Setor>();
		try {
			conexao = SGDSConexao.getSGDSConexao();
			comando = conexao.prepareStatement(sqlConsultarSetoresAtivos);
			retorno = comando.executeQuery();
			while (retorno.next()) {
				Setor setor = new Setor();
				setor.setCodSetor(retorno.getInt("codSetor"));
				setor.setNome(retorno.getString("nome"));
				setor.setNomeResponsavel(retorno.getString("nomeResponsavel"));
				if (retorno.getInt("setorResponsavel") > 0) {
					setor.setSetorResponsavel(new SetorDAO()
							.consultarSetor(retorno.getInt("setorResponsavel")));
				} else {
					setor.setSetorResponsavel(new Setor());
				}
				setor.setDescricao(retorno.getString("descricao"));
				setor.setEmail(retorno.getString("email"));
				setor.setAtivo(retorno.getBoolean("ativo"));
				setores.add(setor);
			}
		} catch (SQLException e) {
			System.out
					.println("Não foi possivel conectar!\n" + e.getMessage());
		} finally {
			if (comando != null)
				comando.close();
			if (conexao != null)
				conexao.close();
		}
		return setores;
	}

	public List<Setor> selecaoSetorResponsavel() throws Exception {
		List<Setor> ativos = new ArrayList<Setor>();
		Connection conexao = null;
		try {
			conexao = SGDSConexao.getSGDSConexao();
			comando = conexao.prepareStatement(sqlSelecaoSetorResponsavel);
			retorno = comando.executeQuery();
			while (retorno.next()) {
				Setor setor = new Setor();
				setor.setCodSetor(retorno.getInt("codSetor"));
				setor.setNome(retorno.getString("nome"));
				ativos.add(setor);
			}
		} catch (SQLException e) {
			throw new Exception("Não foi possivel conectar!\n"
					+ e.getMessage());
		} finally {
			if (comando != null)
				comando.close();
			if (conexao != null)
				conexao.close();
		}
		return ativos;
	}
}
