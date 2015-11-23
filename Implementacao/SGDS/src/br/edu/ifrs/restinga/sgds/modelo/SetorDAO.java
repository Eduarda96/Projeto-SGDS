package br.edu.ifrs.restinga.sgds.modelo;

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
	private static final String sqlDeletarSetor = "UPDATE SETOR SET ativo = 0, setorResponsavel = 0 WHERE (codSetor = ?) ";
	private static final String sqlAlterarSetor = "UPDATE SETOR SET nome = ?, nomeResponsavel = ?, setorResponsavel = ?, descricao = ?, email = ? WHERE (codSetor = ?) ";
	private static final String sqlVerificarNomeSetor = "SELECT COUNT(*) AS verificar FROM SETOR WHERE nome = ?";
	private static final String sqlConsultarSetorNome = "SELECT codSetor, nome, nomeResponsavel, setorResponsavel, descricao, email, ativo FROM SETOR WHERE nome LIKE ?;";
	private static final String sqlConsultarSetorResp = "SELECT codSetor, nome, nomeResponsavel, setorResponsavel, descricao, email, ativo FROM SETOR WHERE nomeResponsavel LIKE ?;";
	String msg = null;

	public String cadastrar(Setor setor) throws Exception {
		Connection conexao = null;
		int subordinado;
		if (setor.getSetorResponsavel() == null) {
			subordinado = 0;
		} else {
			subordinado = consultarSetor(setor.getSetorResponsavel().getCodSetor()).getCodSetor();
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
			msg = "Setor cadastrado com sucesso";
		} catch (SQLException e) {
			msg = "Não foi possivel cadastrar!\n" + e.getMessage();
		} finally {
			if (comando != null)
				comando.close();
			if (conexao != null)
				conexao.close();
		}
		return msg;
	}

	public String alterarSetor(Setor setor) throws Exception {
		Connection conexao = null;

		int subordinado;
		if (setor.getSetorResponsavel() == null) {
			subordinado = 0;
		} else {
			subordinado = consultarSetor(setor.getSetorResponsavel().getCodSetor()).getCodSetor();
		}
		try {
			conexao = SGDSConexao.getSGDSConexao();
			comando = conexao.prepareStatement(sqlAlterarSetor);
			comando.setString(1, setor.getNome());
			comando.setString(2, setor.getNomeResponsavel());
			comando.setString(4, setor.getDescricao());
			comando.setString(5, setor.getEmail());
			comando.setInt(6, setor.getCodSetor());
			comando.setInt(3, subordinado);

			comando.execute();
			msg = "Setor atualizado com sucesso.";
		} catch (SQLException e) {
			msg = "Não foi possivel atualizar o setor.\n" + e.getMessage();
		} finally {
			if (comando != null)
				comando.close();
			if (conexao != null)
				conexao.close();
		}
		return msg;

	}

	public String deletarSetor(int cod) throws Exception {
		Connection conexao = null;

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
				msg = "Setor exclu�do com sucesso";
			} else {
				msg = "Setor n�o pode ser exclu�do, existem servidores associados";
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
			retornarSetor.setNomeResponsavel(retorno.getString("nomeResponsavel"));
			retornarSetor.setEmail(retorno.getString("email"));
			retornarSetor.setDescricao(retorno.getString("descricao"));
			Setor resp = new Setor();
			resp.setCodSetor(0);
			if (retorno.getInt("setorResponsavel") > 0)
				resp.setCodSetor(retorno.getInt("setorResponsavel"));
			retornarSetor.setSetorResponsavel(resp);
		} catch (SQLException e) {
			System.out.println("Não foi possivel conectar!\n" + e.getMessage());
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
					setor.setSetorResponsavel(new SetorDAO().consultarSetor(retorno.getInt("setorResponsavel")));
				} else {
					setor.setSetorResponsavel(new Setor());
				}
				setor.setDescricao(retorno.getString("descricao"));
				setor.setEmail(retorno.getString("email"));
				setor.setAtivo(retorno.getBoolean("ativo"));
				setores.add(setor);
			}
		} catch (SQLException e) {
			System.out.println("Não foi possivel conectar!\n" + e.getMessage());
		} finally {
			if (comando != null)
				comando.close();
			if (conexao != null)
				conexao.close();
		}
		return setores;
	}

	public List<Setor> consultarSetores(String selecao, String filtroSetor) throws Exception {
		Connection conexao = null;
		List<Setor> setores = new ArrayList<Setor>();
		try {
			conexao = SGDSConexao.getSGDSConexao();
			if (selecao.equals("nome"))
				comando = conexao.prepareStatement(sqlConsultarSetorNome);
			else if (selecao.equals("nomeResponsavel"))
				comando = conexao.prepareStatement(sqlConsultarSetorResp);
			else
				System.out.println("ERROR");
			comando.setString(1, "%" + filtroSetor + "%");
			// retorno = null;
			retorno = comando.executeQuery();
			// System.out.println(selecao);
			// System.out.println(filtroSetor);
			while (retorno.next()) {
				Setor setor = new Setor();
				setor.setCodSetor(retorno.getInt("codSetor"));
				setor.setNome(retorno.getString("nome"));
				setor.setNomeResponsavel(retorno.getString("nomeResponsavel"));
				if (retorno.getInt("setorResponsavel") > 0) {
					setor.setSetorResponsavel(new SetorDAO().consultarSetor(retorno.getInt("setorResponsavel")));
				} else {
					setor.setSetorResponsavel(new Setor());
				}
				setor.setDescricao(retorno.getString("descricao"));
				setor.setEmail(retorno.getString("email"));
				setor.setAtivo(retorno.getBoolean("ativo"));
				setores.add(setor);
			}
		} catch (SQLException e) {
			System.out.println("N�o foi possivel conectar!\n" + e.getMessage());
		} finally {
			if (retorno != null)
				retorno.close();
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

	public int VerificarNomeSetor(String nome) throws Exception {
		Connection conexao = null;
		int cont = 0;
		try {
			conexao = SGDSConexao.getSGDSConexao();
			comando = conexao.prepareStatement(sqlVerificarNomeSetor);
			comando.setString(1, nome);

			retorno = comando.executeQuery();
			retorno.next();
			cont = Integer.parseInt(retorno.getString("verificar"));

		} catch (SQLException e) {
			msg = "N�o foi possivel verificar!\n" + e.getMessage();
		} finally {
			if (comando != null)
				comando.close();
			if (conexao != null)
				conexao.close();
		}
		return cont;
	}

}
