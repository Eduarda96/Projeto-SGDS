package br.edu.ifrs.restinga.sgds.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifrs.restinga.sgds.modelo.Setor;
import br.edu.ifrs.restinga.sgds.modelo.SetorDAO;

/**
 * Servlet implementation class TestaCadastroSetor
 */
@WebServlet("/TestaCadastroSetor")
public class TestaCadastroSetor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestaCadastroSetor() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        try {
            String mens_erro = "";
        	boolean erro = false;
        	Setor cadSetor = new Setor();
            //if()
        	cadSetor.setNome("" + request.getParameter("nome"));
            cadSetor.setNomeResponsavel("" + request.getParameter("nomeResponsavel"));
            if(!cadSetor.validaEmail("" + request.getParameter("email"))) {
            	erro = true;
            }
            
            if(Integer.parseInt("" + request.getParameter("setores")) > 0) {
            	cadSetor.setSetorResponsavel(new SetorDAO().consultarSetor(Integer.parseInt("" + request.getParameter("setores"))));
            } else {
            	cadSetor.setSetorResponsavel(null);
            }
            
            cadSetor.setDescricao("" + request.getParameter("descricao"));
            
            SetorDAO dao = new SetorDAO();
            
            if (!erro) {
            	dao.cadastrar(cadSetor);
            } else {
            	request.setAttribute("erro", "Email invalido.");
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
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		processRequest(request, response);
	}

}
