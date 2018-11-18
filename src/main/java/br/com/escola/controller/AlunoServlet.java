package br.com.escola.controller;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.escola.model.domain.Aluno;
import br.com.escola.model.service.AlunoService;

@WebServlet("/AlunoServlet")
public class AlunoServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private static String FORM = "/form_aluno.jsp";
    private static String LIST = "/listar_aluno.jsp";

	private AlunoService alunoService;
       
    public AlunoServlet() {
        super();
        this.alunoService = new AlunoService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String forward="";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("remover")){
            int alunoId = Integer.parseInt(request.getParameter("id"));
            this.alunoService.remover(alunoId);
            forward = LIST;
            request.setAttribute("alunoList", this.alunoService.listar());    
            
        } else if (action.equalsIgnoreCase("editar")){
            forward = FORM;
            int alunoId = Integer.parseInt(request.getParameter("id"));
            Aluno aluno = this.alunoService.buscar(alunoId);
            request.setAttribute("aluno", aluno);
            
        } else if (action.equalsIgnoreCase("listar")){
            forward = LIST;
			request.setAttribute("alunoList", this.alunoService.listar());
            
        } else {
        	request.setAttribute("aluno", new Aluno());
            forward = FORM;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Aluno aluno = new Aluno();
		aluno.setNome(request.getParameter("nome"));
		aluno.setEmail(request.getParameter("email"));
        
		String id = request.getParameter("id");
		
		if (id != null && !id.isEmpty()) {
			aluno.setId(Integer.parseInt(id));
		}
		
		this.alunoService.salvar(aluno);
		
        RequestDispatcher view = request.getRequestDispatcher(LIST);
        request.setAttribute("alunoList", this.alunoService.listar());
        view.forward(request, response);
	}

}
