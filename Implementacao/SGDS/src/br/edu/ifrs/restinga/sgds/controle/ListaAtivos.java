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
 * Servlet implementation class ListaAtivos
 */
@WebServlet(name = "listaativos.do", urlPatterns = { "/listaativos.do" })
public class ListaAtivos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListaAtivos() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		try {
			List<Setor> lista = new ArrayList<Setor>();
			SetorDAO setorDao = new SetorDAO();
			String print = "";

			lista.addAll(setorDao.consultarTodosSetor());
			for (Setor enviar : lista) {
				print += "<tr><th>" + enviar.getCodSetor() + "<th>" + enviar.getNome() + "<th>"
						+ enviar.getNomeResponsavel() + "<th>" + enviar.getEmail() + "<th>"
						+ enviar.getSetorResponsavel().getNome() + "<th>" + enviar.getDescricao();
			}
			 request.setAttribute("lista", print);
			 request.getRequestDispatcher("testaMostrarSetores.jsp").forward(request, response);
		} catch (Exception e) {
			request.getRequestDispatcher("index.html").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		processRequest(request, response);
		// try {
		// List<Setor> lista = new ArrayList<Setor>();
		// SetorDAO setorDao = new SetorDAO();
		// String select = "<option value=\"0\">Sem Responsavel</option>";
		//
		// lista.addAll(setorDao.listarSetorAtivo());
		// for(Setor enviar : lista) {
		// select += "<option value=\"" + enviar.getCodSetor() + "\">" +
		// enviar.getNome() + "</option>";
		// }
		//
		// request.setAttribute("ativos", select);
		// request.getRequestDispatcher("TesteFormulario.jsp").forward(request,
		// response);
		// } catch (Exception e) {
		// request.getRequestDispatcher("cadastrosetor.html").forward(request,
		// response);
		// }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);

		processRequest(request, response);
	}

}
