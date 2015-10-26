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
@WebServlet(name = "listaAtivos.do", urlPatterns = { "/listaAtivos.do" })
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

			lista.addAll(setorDao.consultarSetoresAtivos());
			for (Setor enviar : lista) {
				print += "<tr><td>" + enviar.getCodSetor() + "<td>" + enviar.getNome() + "<td>"
						+ enviar.getNomeResponsavel() + "<td>" + enviar.getEmail() + "<td>";
				if (enviar.getSetorResponsavel().getNome() == null) {
					print += "Não informado.";
				} else {
					print += enviar.getSetorResponsavel().getNome();
				}
				print += "<td>" + enviar.getDescricao() + "<td>";
			}
			 request.setAttribute("lista", print);
			 request.getRequestDispatcher("tabela.jsp").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("erro", e.getMessage());
			request.getRequestDispatcher("erro.jsp").forward(request, response);
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
