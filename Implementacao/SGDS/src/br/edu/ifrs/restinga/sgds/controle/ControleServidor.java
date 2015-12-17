package br.edu.ifrs.restinga.sgds.controle;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifrs.restinga.sgds.modelo.Servidor;
import br.edu.ifrs.restinga.sgds.modelo.ServidorDAO;
import jdk.nashorn.internal.ir.RuntimeNode.Request;


/**
 * Servlet implementation class ControleSetor
 */
@WebServlet("/ControleSetor")
public class ControleServidor extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String msg = null;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String acao = request.getParameter("acao");

		switch (acao) {
		case "listar":
			listarServidoresAtivos(request, response);
			break;
		case "cadastrar":
			cadastrarServidor(request, response);
			break;
		case "deletar":
			deletarServidor(request, response);
			break;
		case "visualizar":
			visualizarServidor(request, response);
			break;
		default:
			break;
		}
	}

	
	protected void listarServidoresAtivos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		try {
			request.setCharacterEncoding("UTF-8");
			List<Servidor> listar = new ArrayList<Servidor>();
			ServidorDAO listarDao = new ServidorDAO();
			String get = (String) request.getParameter("page");
			int page = 0;
			int ant = -1;
			int pro = -1;
			if (get != null) {
				page = Integer.parseInt(get);
				page *= 10;
			} else {
				page = 10;
			}
			int linha = 1;
			String print = "";

			listar.addAll(listarDao.consultarServidoresAtivos());
			for (Servidor enviar : listar) {
				/*Andrius fez cacaca aki...
				if(enviar.getNome() == null || enviar.getNome().equals(""))
					enviar.setNome("");
				if(enviar.getEmailInstitucional() == null || enviar.getEmailInstitucional().equals(""))
					enviar.setEmailInstitucional(emailInstitucional);("");
				if(enviar.getSetorResponsavel().getNome() == null || enviar.getSetorResponsavel().getNome().equals(""))
					enviar.getSetorResponsavel().setNome("");;
				*/
				if ((page-9 <= linha) && (page >= linha)) {
				print += "<tr><td>" + enviar.getMatriculaSiape() + "<td>" + enviar.getNome() + "<td>"
						+ enviar.getPerfil() + "<td>" + enviar.getEmailInstitucional();
				print += "<td><div class=\"divColunaEditar\"><ul>" + "<li><a href=\"ControleSetor?acao=consultarAlteracao&codigo="
						+ enviar.getCodServidor()
						+ "\"><div class=\"iconeEditar\" alt=\"Editar Setor.\" title=\"Editar Setor\"></div></a></li>"
						+ "<li><a href=\"ControleSetor?acao=visualizar&codigo=" + enviar.getCodServidor()
						+ "\"><div class=\"iconeVisualizar\" alt=\"Visualizar Informações do Setor.\" title=\"Visualizar Setor\"></div></a></li>"
						+ "<li><a href=\"ControleSetor?acao=deletar&codigo=" + enviar.getCodServidor()
						+ "\"><div class=\"iconeDeletar\" alt=\"Deletar Setor.\" title=\"Deletar Setor\"></div></a></li></ul></div>";
				} else if (linha == page-10) {
					ant = (linha/10);
				} else if ((linha > page) && (linha <= page+10)) {
					pro = (page/10)+1;
				}
				linha++;
			}
			if (ant != -1) { request.setAttribute("anterior", ant); }
			if (pro != -1) { request.setAttribute("proximo", pro); }
			request.setAttribute("lista", print);
			request.getRequestDispatcher("listaservidores.jsp").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("main.jsp").forward(request, response);
		}

	}

	protected void cadastrarServidor(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			request.setCharacterEncoding("UTF-8");
			String mens_erro = "";
			boolean erro = false;
			Servidor cadastrar = new Servidor();
						
			cadastrar.setNome(request.getParameter("nome"));
			cadastrar.setNomeMae(request.getParameter("nomeMae"));
			cadastrar.setNomePai(request.getParameter("nomePai"));
			cadastrar.setMatriculaSiape(request.getParameter("matriculaSiape"));
			cadastrar.setSenha(request.getParameter("senha"));
			cadastrar.setPerfil(request.getParameter("perfil"));
			cadastrar.setSexo(request.getParameter("sexo"));
			cadastrar.setPerfil(request.getParameter("perfil"));
			//data
			DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
			Date date = (Date)formatter.parse(request.getParameter("mes")+request.getParameter("dia")+request.getParameter("ano"));
			cadastrar.setDataNascimento(date);
	        
			cadastrar.setEmailInstitucional(request.getParameter("emailInstitucional"));
			cadastrar.setEstadoCivil(request.getParameter("estadocivil"));
			cadastrar.setEndereco(request.getParameter("endereco"));
			cadastrar.setNumeroComplemento(request.getParameter("numeroComplemento"));
			cadastrar.setBairro(request.getParameter("bairro"));
			cadastrar.setCep(request.getParameter("cep"));
			cadastrar.setCidade(request.getParameter("cidade"));
			cadastrar.setEstado(request.getParameter("estado"));
			cadastrar.setTelefoneResidencial(request.getParameter("telefoneResidencial"));
			cadastrar.setTelefoneCelular(request.getParameter("telefoneCelular"));
			

			

			ServidorDAO cadastrarDAO = new ServidorDAO();

			if (!erro) {
				int test = cadastrarDAO.VerificarMatriculaServidor(cadastrar.getMatriculaSiape());
			
				if (test != 0) {
					request.setAttribute("msg", "Nome do setor ja cadastrado.");
				} else {
					msg = cadastrarDAO.cadastrar(cadastrar);
					request.setAttribute("msg", msg);
				}
			} else {
				request.setAttribute("msg", mens_erro);
				request.getRequestDispatcher("main.jsp").forward(request,
						response);
			}

			request.getRequestDispatcher("ControleSetor?acao=listar").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("main.jsp").forward(request, response);
		}
	}

	protected void deletarServidor(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			ServidorDAO deletarDao = new ServidorDAO();
			int cod = Integer.parseInt(request.getParameter("codigo"));
			msg = deletarDao.deletarServidor(cod);
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("ControleSetor?acao=listar").forward(
					request, response);
		} catch (Exception e) {
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("main.jsp").forward(request, response);
		}
	}

	protected void visualizarServidor(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			ServidorDAO visualizarDAO = new ServidorDAO();
			int cod = Integer.parseInt(request.getParameter("codigo"));
			Servidor visualizar = visualizarDAO.consultarServidor(cod);
			request.setAttribute("acao", "visualizar");
			
			request.setAttribute("codigo", cod);			
			request.setAttribute("nome", visualizar.getNome());
			request.setAttribute("nomeMae", visualizar.getNomeMae());
			request.setAttribute("nomePai", visualizar.getNomePai());
			request.setAttribute("matriculaSiape", visualizar.getMatriculaSiape());
			request.setAttribute("perfil",  visualizar.getPerfil());
			request.setAttribute("sexo",  visualizar.getSexo());
			request.setAttribute("perfil",  visualizar.getPerfil());
			request.setAttribute("dataNascimento",  visualizar.getDataNascimento());
			request.setAttribute("emailInstitucional",  visualizar.getEmailInstitucional());
			request.setAttribute("estadocivil",  visualizar.getEstadoCivil());
			request.setAttribute("endereco",  visualizar.getEndereco());
			request.setAttribute("numeroComplemento",  visualizar.getNumeroComplemento());
			request.setAttribute("bairro",  visualizar.getBairro());
			request.setAttribute("cep",  visualizar.getCep());
			request.setAttribute("cidade",  visualizar.getCidade());
			request.setAttribute("estado",  visualizar.getEstado());
			request.setAttribute("telefoneResidencial",  visualizar.getTelefoneResidencial());
			request.setAttribute("telefoneCelular",  visualizar.getTelefoneCelular());
			
			request.getRequestDispatcher("cadastrosetor.jsp").forward(request,
					response);
		} catch (Exception e) {
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("main.jsp").forward(request, response);
		}
	}

	
	
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ")
				.append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	}