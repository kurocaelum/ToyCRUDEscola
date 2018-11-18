package br.com.escola.model.domain;

public class OperacaoSoma implements OperacaoMatematica {

	@Override
	public double calcula(double numeroEsquerda, double numeroDireita) {
		return numeroEsquerda + numeroDireita;
	}

}
