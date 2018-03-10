package com.solutis.hackaton.demo.model;

public class Alternativa {
	
	private String texto;
	private boolean selecionada;
	
	public Alternativa(){
		
	}
	
	public Alternativa(String texto, boolean selecionada){
		this.texto = texto;
		this.selecionada = selecionada;
	}
	
	
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public boolean isSelecionada() {
		return selecionada;
	}
	public void setSelecionada(boolean selecionada) {
		this.selecionada = selecionada;
	}

}
