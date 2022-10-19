package com.api.library.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.library.dto.LivrosDTO;
import com.api.library.service.LivroService;

@RestController
@RequestMapping("/v1/api/livros/")
public class LivroController {

	private LivroService servicce;

	public LivroController(LivroService servicce) {
		super();
		this.servicce = servicce;
	}

	@PostMapping
	ResponseEntity<LivrosDTO> save(@RequestBody LivrosDTO livrosDto) {
		return servicce.saveLivro(livrosDto);
	}

}
