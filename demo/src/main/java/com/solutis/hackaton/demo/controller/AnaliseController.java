package com.solutis.hackaton.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solutis.hackaton.demo.service.AnaliseService;

@RestController
@RequestMapping(path = "/api")
public class AnaliseController {
	
	@Autowired
	private AnaliseService analiseService;
	
	@GetMapping(path = "/analisar")
	public ResponseEntity<String> analisar() {
		return ResponseEntity.ok(analiseService.montarConteudo());
	}


}
