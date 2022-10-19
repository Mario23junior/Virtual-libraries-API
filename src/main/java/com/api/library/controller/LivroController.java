package com.api.library.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.library.dto.LivrosDTO;
import com.api.library.service.LivroService;

@RestController
@RequestMapping("/v1/api/livros/")
public class LivroController {

	private LivroService service;

	public LivroController(LivroService service) {
		super();
		this.service = service;
	}

	@PostMapping
	ResponseEntity<LivrosDTO> save(@RequestBody LivrosDTO livrosDto) {
		return service.saveLivro(livrosDto);
	}
	
	@GetMapping("{id}")
	ResponseEntity<LivrosDTO> listId(@PathVariable Long id){
		return service.listId(id);	
	}
	
	@PutMapping("{id}")
	ResponseEntity<LivrosDTO> update(
			@PathVariable Long id, 
			@RequestBody LivrosDTO livrosDto
			){
		return service.updateLivro(livrosDto, id);
	}

}
