package com.solutis.hackaton.demo.util;

import java.util.ArrayList;
import java.util.List;

import com.solutis.hackaton.demo.model.Alternativa;
import com.solutis.hackaton.demo.model.Questao;

public class MontaQuestoesUtil {
	
	public static List<Questao> montar(){
		
		List<Alternativa> listaAlternativa = new ArrayList<>();
		List<Questao> questoes = new ArrayList<>();
		
		Questao questao = new Questao();
		questao.setEnunciado("questao 1");
		listaAlternativa.add( new Alternativa("text1.1.",false));
		listaAlternativa.add( new Alternativa("text1.2.",false));
		listaAlternativa.add( new Alternativa("text1.3.",false));
		listaAlternativa.add( new Alternativa("text1.4.",false));
		listaAlternativa.add( new Alternativa("text1.5.",true));
		questao.setAlternativas(listaAlternativa);
		questoes.add(questao);
		
		questao = new Questao();
		listaAlternativa = new ArrayList<>();
		questao.setEnunciado("questao 2");
		listaAlternativa.add( new Alternativa("text2.1.",false));
		listaAlternativa.add( new Alternativa("text2.2.",false));
		listaAlternativa.add( new Alternativa("text2.3.",false));
		listaAlternativa.add( new Alternativa("text2.4.",false));
		listaAlternativa.add( new Alternativa("text2.5.",true));
		questao.setAlternativas(listaAlternativa);
		
		questoes.add(questao);
		
		return questoes;
	}

}
