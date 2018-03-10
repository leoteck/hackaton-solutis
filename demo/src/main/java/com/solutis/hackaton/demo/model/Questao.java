package com.solutis.hackaton.demo.model;

import java.util.List;

public class Questao {

	private String id;
	private String enunciado;
	private List<Alternativa> alternativas;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEnunciado() {
		return enunciado;
	}
	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}
	public List<Alternativa> getAlternativas() {
		return alternativas;
	}
	public void setAlternativas(List<Alternativa> alternativas) {
		this.alternativas = alternativas;
	}
}
