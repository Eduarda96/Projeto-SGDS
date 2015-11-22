package br.edu.ifrs.restinga.sgds.controle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifrs.restinga.sgds.modelo.Setor;
import br.edu.ifrs.restinga.sgds.modelo.SetorDAO;

/**
 * Servlet implementation class ControleSetor
 */
@WebServlet("/ControleSetor")
public class ControleSetor extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String msg = null;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String acao = request.getParameter("acao");

		switch (acao) {
		case "selecao":
			selecaoSetoresResponsaveis(request, response);
			break;
		case "listar":
			listarSetoresAtivos(request, response);
			break;
		case "cadastrar":
			cadastrarSetor(request, response);
			break;
		case "deletar":
			deletarSetor(request, response);
			break;
		case "visualizar":
			visualizarSetor(request, response);
			break;

		default:
			break;
		}
	}

	protected void selecaoSetoresResponsaveis(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {

			List<Setor> selecao = new ArrayList<Setor>();
			SetorDAO selecaoDao = new SetorDAO();
			String select = "<option value=\"0\">Sem Responsavel</option>";

			selecao.addAll(selecaoDao.selecaoSetorResponsavel());
			for (Setor enviar : selecao) {
				select += "<option value=\"" + enviar.getCodSetor() + "\">"
						+ enviar.getNome() + "</option>";
			}

			request.setAttribute("acao", "cadastrar");
			request.setAttribute("ativos", select);
			request.getRequestDispatcher("cadastrosetor.jsp").forward(request,
					response);
		} catch (Exception e) {
			request.setAttribute("erro", e.getMessage());
			request.getRequestDispatcher("erro.jsp").forward(request, response);
		}
	}

	protected void listarSetoresAtivos(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		try {
			request.setCharacterEncoding("UTF-8");
			List<Setor> listar = new ArrayList<Setor>();
			SetorDAO listarDao = new SetorDAO();
			String print = "";

			listar.addAll(listarDao.consultarSetoresAtivos());
			for (Setor enviar : listar) {
				print += "<tr><td>" + enviar.getNome() + "<td>"
						+ enviar.getSetorResponsavel().getNome() + "<td>"
						+ enviar.getNomeResponsavel() + "<td>"
						+ enviar.getEmail();
				print += "<td><div class=\"divColunaEditar\"><ul>"
						+ "<li><a href=\"ControleSetor?acao=alterar&codigo="
						+ enviar.getCodSetor()
						+ "\"><div class=\"iconeEditar\" alt=\"Editar Setor.\" title=\"Editar Setor\"></div></a></li>"
						+ "<li><a href=\"ControleSetor?acao=visualizar&codigo="
						+ enviar.getCodSetor()
						+ "\"><div class=\"iconeVisualizar\" alt=\"Visualizar Informações do Setor.\" title=\"Visualizar Setor\"></div></a></li>"
						+ "<li><a href=\"ControleSetor?acao=deletar&codigo="
						+ enviar.getCodSetor()
						+ "\"><div class=\"iconeDeletar\" alt=\"Deletar Setor.\" title=\"Deletar Setor\"></div></a></li></ul></div>";
			}
			request.setAttribute("lista", print);
			request.getRequestDispatcher("listasetores.jsp").forward(request,
					response);
		} catch (Exception e) {
			request.setAttribute("erro", e.getMessage());
			request.getRequestDispatcher("erro.jsp").forward(request, response);
		}

	}

	protected void cadastrarSetor(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			request.setCharacterEncoding("UTF-8");
			String mens_erro = "";
			boolean erro = false;
			Setor cadastrar = new Setor();
			cadastrar.setNome(request.getParameter("nome"));
			cadastrar.setNomeResponsavel(request
					.getParameter("nomeResponsavel"));
			cadastrar.setEmail(request.getParameter("email"));

			if (Integer.parseInt("" + request.getParameter("setores")) > 0) {
				cadastrar.setSetorResponsavel(new SetorDAO()
						.consultarSetor(Integer.parseInt(""
								+ request.getParameter("setores"))));
			} else {
				cadastrar.setSetorResponsavel(null);
			}

			cadastrar.setDescricao(request.getParameter("descricao"));

			if (!cadastrar.validarNomeSetor()) {
				mens_erro += "Erro: Nome do setor invalido!<br>";
				erro = true;
			}
			if (!cadastrar.validaEmail()) {
				mens_erro += "Erro: Email do setor invalido!<br>";
				erro = true;
			}

			SetorDAO cadastrarDAO = new SetorDAO();

			if (!erro) {
				int test = cadastrarDAO.VerificarNomeSetor(cadastrar.getNome());
			
				//if (cadastrarDAO.VerificarNomeSetor(cadastrar.getNome())!= "0") {
					request.setAttribute("msg", "Nome do setor j� cadastrado."+test);
				//} else {
					msg = cadastrarDAO.cadastrar(cadastrar);
					request.setAttribute("msg", msg+test);
				//}
			} else {
				request.setAttribute("erro", mens_erro);
				request.getRequestDispatcher("erro.jsp").forward(request,
						response);
			}

			request.getRequestDispatcher("main.jsp").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("erro", e.getMessage());
			request.getRequestDispatcher("erro.jsp").forward(request, response);
		}
	}

	protected void deletarSetor(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			SetorDAO deletarDao = new SetorDAO();
			int cod = Integer.parseInt(request.getParameter("codigo"));
			msg = deletarDao.deletarSetor(cod);
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("ControleSetor?acao=listar").forward(
					request, response);
		} catch (Exception e) {
			request.setAttribute("erro", e.getMessage());
			request.getRequestDispatcher("erro.jsp").forward(request, response);
		}
	}

	protected void visualizarSetor(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			SetorDAO visualizarDAO = new SetorDAO();
			int cod = Integer.parseInt(request.getParameter("codigo"));
			Setor visualizar = visualizarDAO.consultarSetor(cod);
			request.setAttribute("acao", "visualizar");
			request.setAttribute("codigo", cod);
			request.setAttribute("nome", visualizar.getNome());

			request.setAttribute("nomeResponsavel", visualizar.getNome());
			request.setAttribute("email", visualizar.getNome());
			request.setAttribute("descricao", visualizar.getNome());
			request.setAttribute("nomeResponsavel",
					visualizar.getNomeResponsavel());
			request.setAttribute("email", visualizar.getEmail());
			request.setAttribute("descricao", visualizar.getDescricao());
			if (visualizar.getSetorResponsavel().getCodSetor() > 0) {
				Setor visualizar2 = visualizarDAO.consultarSetor(visualizar
						.getSetorResponsavel().getCodSetor());
				String option = "<option value=\"" + visualizar2.getCodSetor()
						+ "\">" + visualizar2.getNome() + "</option>";
				request.setAttribute("ativos", option);
			} else {
				request.setAttribute("ativos",
						"<option value=\"0\">Sem Responsavel</option>");
			}
			request.getRequestDispatcher("cadastrosetor.jsp").forward(request,
					response);
		} catch (Exception e) {
			request.setAttribute("erro", e.getMessage());
			request.getRequestDispatcher("erro.jsp").forward(request, response);
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
