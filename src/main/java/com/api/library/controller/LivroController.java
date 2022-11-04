package com.api.library.controller;

import com.api.library.dto.LivrosDTO;
import com.api.library.model.Livros;
import com.api.library.service.LivroService;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/livros/")
public class LivroController {

	private LivroService service;

	public LivroController(LivroService service) {
		super();
		this.service = service;
	}

	@PostMapping
	ResponseEntity<Livros> save(@RequestBody Livros livros) {
		return service.saveLivro(livros);
	}
	
	@GetMapping("{id}")
	ResponseEntity<LivrosDTO> listId(@PathVariable Long id){
		return service.listId(id);	
	}
	
	@GetMapping
	public Page<Livros> listPage(
			 @RequestParam(value = "page", defaultValue = "0") Integer pageNo 
			,@RequestParam(value = "size", defaultValue = "3") Integer pageSize){
		return service.findPageAll(pageNo, pageSize);	
	}
	
	@PutMapping("{id}")
	ResponseEntity<LivrosDTO> update(
			@PathVariable Long id, 
			@RequestBody LivrosDTO livrosDto
			){
		return service.updateLivro(livrosDto, id);
	}
	
	@DeleteMapping("{id}")
	ResponseEntity<LivrosDTO> deleteId (@PathVariable Long id){
		return service.delete(id);
	}

}
