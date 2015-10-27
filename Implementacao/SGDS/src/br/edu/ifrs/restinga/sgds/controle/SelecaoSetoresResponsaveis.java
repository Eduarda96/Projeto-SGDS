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
 * Servlet implementation class SelecaoSetoresResponsaveis
 */
@WebServlet(name = "selecaoSetoresResponsaveis", urlPatterns = { "/selecaoSetoresResponsaveis" })
public class SelecaoSetoresResponsaveis extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
            List<Setor> lista = new ArrayList<Setor>();
            SetorDAO setorDao = new SetorDAO();
            String select = "<option value=\"0\">Sem Responsavel</option>";
            
            lista.addAll(setorDao.selecaoSetorResponsavel());
            for(Setor enviar : lista) {
            	select += "<option value=\"" + enviar.getCodSetor() + "\">" + enviar.getNome() + "</option>";
            }
            
            request.setAttribute("ativos", select);
            request.getRequestDispatcher("TesteFormulario.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("erro", e.getMessage());
        	request.getRequestDispatcher("erro.jsp").forward(request, response);
        }
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		service(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		service(request, response);
	}

}
