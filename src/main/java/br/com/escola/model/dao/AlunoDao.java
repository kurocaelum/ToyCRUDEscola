package br.com.escola.model.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.escola.model.domain.Aluno;

public class AlunoDao {
	
	private List<Aluno> BD = new ArrayList<>();
	
	
	public List<Aluno> listar() {
		return BD;
	}
	
	public Aluno buscar(int id) {
		for (Aluno aluno : BD) {
			if(aluno.getId() == id) {
				return aluno;
			}
		}
		return null;
	}
	
	public Aluno buscar(String nome) {
		for (Aluno aluno : BD) {
			if(aluno.getNome() == nome) {
				return aluno;
			}
		}
		return null;
	}
	
	public void inserir(Aluno aluno) {
		aluno.setId(BD.size()+1);
		BD.add(aluno);
	}
	
	public void alterar(Aluno aluno) {
		int indexBD = getIndexAluno(aluno.getId());
		boolean foiEncontrado = indexBD >= 0;
		
		if(foiEncontrado) {
			BD.set(indexBD, aluno);
		}
	}
	
	public void remover(int id) {
		int indexBD = getIndexAluno(id);
		boolean foiEncontrado = indexBD >= 0;
		
		if(foiEncontrado) {
			BD.remove(indexBD);
		}
	}

	private int getIndexAluno(int id) {
		int indexBD = -1;
		
		for (int i = 0; i < BD.size(); i++) {
			Aluno modelTmp = BD.get(i);
			
			if(modelTmp.getId() == id) {
				indexBD = i;
			}
		}
		return indexBD;
	}

}
