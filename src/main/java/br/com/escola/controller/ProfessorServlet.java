package br.com.escola.controller;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.escola.model.domain.Professor;
import br.com.escola.model.service.ProfessorService;

@WebServlet("/ProfessorServlet")
public class ProfessorServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private static String FORM = "/listar_professor.jsp";
    private static String LIST = "/listar_professor.jsp";

	private ProfessorService professorService;
       
    public ProfessorServlet() {
        super();
        this.professorService = new ProfessorService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String forward="";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("remover")){
            int professorId = Integer.parseInt(request.getParameter("id"));
            //this.professorService.remover(professorId);
            forward = LIST;
            request.setAttribute("professorList", this.professorService.listar());    
            
        } else if (action.equalsIgnoreCase("editar")){
            forward = FORM;
            int professorId = Integer.parseInt(request.getParameter("id"));
            Professor professor = this.professorService.buscar(professorId);
            request.setAttribute("professor", professor);
            
        } else if (action.equalsIgnoreCase("listar")){
            forward = LIST;
			request.setAttribute("professorList", this.professorService.listar());
            
        } else {
        	request.setAttribute("professor", new Professor());
            forward = FORM;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Professor professor = new Professor();
		professor.setNome(request.getParameter("nome"));
		professor.setEmail(request.getParameter("email"));
        
		String id = request.getParameter("id");
		
		if (id != null && !id.isEmpty()) {
			professor.setId(Integer.parseInt(id));
		}
		
		this.professorService.salvar(professor);
		
        RequestDispatcher view = request.getRequestDispatcher(LIST);
        request.setAttribute("professorList", this.professorService.listar());
        view.forward(request, response);
	}

}
