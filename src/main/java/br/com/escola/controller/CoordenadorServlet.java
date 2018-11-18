package br.com.escola.controller;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.escola.model.domain.Coordenador;
import br.com.escola.model.service.CoordenadorService;

@WebServlet("/CoordenadorServlet")
public class CoordenadorServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	//TODO alterado
	private static String FORM = "/listar_coordenador.jsp";
    private static String LIST = "/listar_coordenador.jsp";

	private CoordenadorService coordenadorService;
       
    public CoordenadorServlet() {
        super();
        this.coordenadorService = new CoordenadorService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String forward="";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("remover")){
            int coordenadorId = Integer.parseInt(request.getParameter("id"));
            //this.coordenadorService.remover(coordenadorId);
            forward = LIST;
            request.setAttribute("coordenadorList", this.coordenadorService.listar());    
                        
        } else if (action.equalsIgnoreCase("listar")){
            forward = LIST;
			request.setAttribute("coordenadorList", this.coordenadorService.listar());
            
        } else {
        	request.setAttribute("coordenador", new Coordenador());
            forward = FORM;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Coordenador coordenador = new Coordenador();
		coordenador.setNome(request.getParameter("nome"));
		coordenador.setEmail(request.getParameter("email"));
        
		String id = request.getParameter("id");
		
		if (id != null && !id.isEmpty()) {
			coordenador.setId(Integer.parseInt(id));
		}
		
		this.coordenadorService.salvar(coordenador);
		
        RequestDispatcher view = request.getRequestDispatcher(LIST);
        request.setAttribute("coordenadorList", this.coordenadorService.listar());
        view.forward(request, response);
	}

}
