package com.solutis.hackaton.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solutis.hackaton.demo.model.Questao;
import com.solutis.hackaton.demo.util.MontaQuestoesUtil;
import com.solutis.hackaton.demo.watson.ConectorWatson;

@Service
public class AnaliseService {
	
	@Autowired
	private ConectorWatson conectorWatson;
	
	public String montarConteudo(){
		
		String textoConcatenado = concatenar(MontaQuestoesUtil.montar());
		
		return conectorWatson.analisar(textoConcatenado);
	}
	
	public String concatenar(List<Questao> questoes){
		StringBuilder texto = new StringBuilder();
		
		questoes.stream().forEach(questao -> {
			texto.append(questao.getAlternativas().stream().filter(alternativa -> alternativa.isSelecionada() ).findFirst().get().getTexto())
			.append(" ");
		});
		
		return texto.toString();
	}

}
