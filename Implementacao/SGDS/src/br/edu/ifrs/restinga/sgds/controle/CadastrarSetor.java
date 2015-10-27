package br.edu.ifrs.restinga.sgds.controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifrs.restinga.sgds.modelo.Setor;
import br.edu.ifrs.restinga.sgds.modelo.SetorDAO;

/**
 * Servlet implementation class CadastrarSetor
 */
@WebServlet(name = "cadastrarSetor", urlPatterns = { "/cadastrarSetor" })
public class CadastrarSetor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
            String mens_erro = "";
        	boolean erro = false;
        	Setor cadSetor = new Setor();
            cadSetor.setNome("" + request.getParameter("nome"));
            cadSetor.setNomeResponsavel("" + request.getParameter("nomeResponsavel"));
            cadSetor.setEmail("" + request.getParameter("email"));
            
            if(Integer.parseInt("" + request.getParameter("setores")) > 0) {
            	cadSetor.setSetorResponsavel(new SetorDAO().consultarSetor(Integer.parseInt("" + request.getParameter("setores"))));
            } else {
            	cadSetor.setSetorResponsavel(null);
            }
            
            cadSetor.setDescricao("" + request.getParameter("descricao"));
            
            if(!cadSetor.validarNomeSetor()) {
            	mens_erro += "Nome do setor invalido!</ br>";
            	erro = true;
            }
            if(!cadSetor.validaEmail()) {
            	mens_erro += "Email do setor invalido!</ br>";
            	erro = true;
            }
            
            SetorDAO dao = new SetorDAO();
            
            if (!erro) {
            	dao.cadastrar(cadSetor);
            } else {
            	request.setAttribute("erro", mens_erro);
            	request.getRequestDispatcher("erro.jsp").forward(request, response);
            }
            	
        	
            request.getRequestDispatcher("TestaListaAtivos").forward(request, response);
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
		doGet(request, response);
		service(request, response);
	}

}
