package br.edu.ifrs.restinga.sgds.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ServidorDAO {	
	
		// Manipular classe Setor no Banco;
		PreparedStatement comando;
		private static final String sqlSelecaoServidorResponsavel = "SELECT codServidor, nome FROM SERVIDOR WHERE status = 1;";
		private static final String sqlCadastrar = "INSERT INTO SERVIDOR (nome, nomeMae, nomePai, matriculaSiape, senha, perfil, sexo, dataNascimento, estadoCivil, endereco, numeroComplemento, bairro, cep, cidade, estado, telefoneResidencial, telefoneCelular, status) "
				+ "VALUES (?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?);";
		private static final String sqlConsultarServidor = "SELECT codServidor, nome, nomeMae, nomePai, matriculaSiape, senha, perfil, sexo, dataNascimento, estadoCivil, endereco, numeroComplemento, bairro, cep, cidade, estado, telefoneResidencial, telefoneCelular "
				+ "FROM SERVIDOR WHERE codSetor = ?;";
		private static final String sqlConsultarServidoresAtivos = "SELECT codServidor, nome, nomeMae, nomePai, matriculaSiape, senha, perfil, sexo, dataNascimento, estadoCivil, endereco, numeroComplemento, bairro, cep, cidade, estado, telefoneResidencial, telefoneCelular "
				+ "FROM SERVIDOR WHERE status = 1;";
		private static final String sqlDeletarServidor = "UPDATE SERVIDOR SET status = 0  WHERE (codServidor = ?) ";
		private static final String sqlAlterarServidor = "UPDATE SERVIDOR SET nome = ?, nomeMae = ?, nomePai = ?, matriculaSiape = ?, senha = ?, perfil = ?, sexo = ?, dataNascimento = ?, estadoCivil = ?, endereco = ?, numeroComplemento = ?, bairro = ?, cep = ?, cidade = ?, estado = ?, telefoneResidencial = ?, telefoneCelular = ?, status = ? WHERE (codServidor = ?) ";
		private static final String sqlVerificarMatriculaServidor = "SELECT COUNT(*) AS verificar FROM SERVIDOR WHERE ((matriculaSiape = ?) AND (status= 1))";
		private static final String sqlConsultarServidorNome = "SELECT codServidor, nome, nomeMae, nomePai, matriculaSiape, senha, perfil, sexo, dataNascimento, estadoCivil, endereco, numeroComplemento, bairro, cep, cidade, estado, telefoneResidencial, telefoneCelular FROM SERVIDOR WHERE nome LIKE ? AND status = 1;";
		
		ResultSet retorno;
		
		String msg = null;

		public String cadastrar(Servidor servidor) throws Exception {
			Connection conexao = null;
			
			try {
				conexao = SGDSConexao.getSGDSConexao();
				comando = conexao.prepareStatement(sqlCadastrar);
				comando.setString(1, servidor.getNome());
				comando.setString(2, servidor.getNomeMae());
				comando.setString(3, servidor.getNomePai());
				comando.setString(4, servidor.getMatriculaSiape());
				comando.setString(5, servidor.getSenha());
				comando.setString(6, servidor.getPerfil());
				comando.setString(7, servidor.getSexo());
				comando.setDate(8, servidor.getDataNascimento());
				comando.setString(9, servidor.getEstadoCivil());
				comando.setString(10, servidor.getEndereco());
				comando.setString(11, servidor.getNumeroComplemento());
				comando.setString(12, servidor.getBairro());
				comando.setString(13, servidor.getCep());
				comando.setString(14, servidor.getCidade());
				comando.setString(15, servidor.getTelefoneResidencial());				
				comando.setString(17, servidor.getTelefoneCelular());
				comando.setInt(18, servidor.getStatus());
				//, , , , , , , 

				comando.execute();
				msg = "Servidor cadastrado com sucesso";
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

		public String alterarServidor(Servidor servidor) throws Exception {
			
			Connection conexao = null;
			try {
				conexao = SGDSConexao.getSGDSConexao();
				comando = conexao.prepareStatement(sqlAlterarServidor);
				
				comando.setString(1, servidor.getNome());
				comando.setString(2, servidor.getNomeMae());
				comando.setString(3, servidor.getNomePai());
				comando.setString(4, servidor.getMatriculaSiape());
				comando.setString(5, servidor.getSenha());
				comando.setString(6, servidor.getPerfil());
				comando.setString(7, servidor.getSexo());
				comando.setDate(8, servidor.getDataNascimento());
				comando.setString(9, servidor.getEstadoCivil());
				comando.setString(10, servidor.getEndereco());
				comando.setString(11, servidor.getNumeroComplemento());
				comando.setString(12, servidor.getBairro());
				comando.setString(13, servidor.getCep());
				comando.setString(14, servidor.getCidade());
				comando.setString(15, servidor.getTelefoneResidencial());				
				comando.setString(17, servidor.getTelefoneCelular());
				comando.setInt(18, servidor.getStatus());
				comando.execute();
				msg = "Servidor atualizado com sucesso.";
			} catch (SQLException e) {
				msg = "Não foi possivel atualizar o servidor.\n" + e.getMessage();
			} finally {
				if (comando != null)
					comando.close();
				if (conexao != null)
					conexao.close();
			}
			return msg;

		}

		public String deletarServidor(int cod) throws Exception {
			Connection conexao = null;

			try {
				conexao = SGDSConexao.getSGDSConexao();
				comando = conexao.prepareStatement(sqlDeletarServidor);
				comando.setInt(1, cod);
				comando.execute();
				msg = "Servidor excluido com sucesso";
				
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

		public Servidor consultarServidor(int codServidor) throws Exception {
			Connection conexao = null;
			Servidor retornarServidor = new Servidor();
			try {
				conexao = SGDSConexao.getSGDSConexao();
				comando = conexao.prepareStatement(sqlConsultarServidor);
				comando.setInt(1, codServidor);
				retorno = comando.executeQuery();
				
				retorno.next();
				
				retornarServidor.setNome(retorno.getString("nome"));
				retornarServidor.setNomeMae(retorno.getString("nomeMae"));
				retornarServidor.setNomePai(retorno.getString("nomePai"));
				retornarServidor.setMatriculaSiape(retorno.getString("matriculaSiape"));
				retornarServidor.setSenha(retorno.getString("senha"));
				retornarServidor.setPerfil(retorno.getString("perfil"));
				retornarServidor.setSexo(retorno.getString("sexo"));
				retornarServidor.setDataNascimento(retorno.getDate("dataNascimento"));
				retornarServidor.setEstadoCivil(retorno.getString("estadoCivil"));
				retornarServidor.setEndereco(retorno.getString("endereco"));
				retornarServidor.setNumeroComplemento(retorno.getString("numeroComplemento"));
				retornarServidor.setBairro(retorno.getString("bairro"));
				retornarServidor.setCep(retorno.getString("cep"));
				retornarServidor.setCidade(retorno.getString("cidade"));
				retornarServidor.setTelefoneResidencial(retorno.getString("telefoneResidencial"));				
				retornarServidor.setTelefoneCelular(retorno.getString("telefoneCelular"));
				retornarServidor.setStatus(retorno.getInt("status"));
				
				
			} catch (SQLException e) {
				System.out.println("Não foi possivel conectar!\n" + e.getMessage());
			} finally {
				if (comando != null)
					comando.close();
				if (conexao != null)
					conexao.close();
			}
			return retornarServidor;
		}

		public List<Servidor> consultarServidoresAtivos() throws Exception {
			Connection conexao = null;
			List<Servidor> servidores = new ArrayList<Servidor>();
			try {
				conexao = SGDSConexao.getSGDSConexao();
				comando = conexao.prepareStatement(sqlConsultarServidoresAtivos);				
				retorno = comando.executeQuery();
				while (retorno.next()) {
					
					Servidor servidor = new Servidor();
										
					servidor.setNome(retorno.getString("nome"));
					servidor.setMatriculaSiape(retorno.getString("matriculaSiape"));
					servidor.setPerfil(retorno.getString("perfil"));			
					servidor.setStatus(retorno.getInt("status"));
					
					servidores.add(servidor);
				}
				return servidores;
			} catch (SQLException e) {
				System.out.println("Não foi possivel conectar!\n" + e.getMessage());
			} finally {
				if (comando != null)
					comando.close();
				if (conexao != null)
					conexao.close();
			}
			return servidores;
		}
		
		public int verificarMatriculaServidor(String matriculaSiape) throws Exception {
			Connection conexao = null;
			int cont = 0;
			try {
				conexao = SGDSConexao.getSGDSConexao();
				comando = conexao.prepareStatement(sqlVerificarMatriculaServidor);
				comando.setString(1, matriculaSiape);

				retorno = comando.executeQuery();
				retorno.next();
				cont = Integer.parseInt(retorno.getString("verificar"));

			} catch (SQLException e) {
				msg = "Nao foi possivel verificar!\n" + e.getMessage();
			} finally {
				if (comando != null)
					comando.close();
				if (conexao != null)
					conexao.close();
			}
			return cont;
		}

	}
	

