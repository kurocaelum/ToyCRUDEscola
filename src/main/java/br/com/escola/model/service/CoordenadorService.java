package br.com.escola.model.service;

import java.util.List;

import br.com.escola.model.dao.CoordenadorDao;
import br.com.escola.model.domain.Coordenador;

public class CoordenadorService {
	
	private CoordenadorDao dao = new CoordenadorDao();
	
	public CoordenadorService() {
		popularBanco();
	}
	
	private void popularBanco() {
		Coordenador coordenador = new Coordenador();
		coordenador.setId(0);
		coordenador.setNome("Coordenador");
		coordenador.setEmail("cordeandor@gmail.com");
		coordenador.setCargo("Coordenadora de Cursos de Extensão do Tribunal");
		
		salvar(coordenador);
	}
	
	public void salvar(Coordenador coordenador) {
		if(coordenador != null) {
			if(coordenador.getId() > 0) {
				dao.alterar(coordenador);
			} else {
				dao.inserir(coordenador);
			}
		}
	}
	
	public List<Coordenador> listar() {
		return this.dao.listar();
	}

	public void imprimir(List<Coordenador> list) {
		System.out.println("-- Coordenadores:");
		for (Coordenador c : list) {
			System.out.println(c);
		}
	}

}
