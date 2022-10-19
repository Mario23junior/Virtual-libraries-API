package com.api.library.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.library.dto.PublicacaoDTO;
import com.api.library.service.PublicacaoService;

@RestController
@RequestMapping("/v1/api/publicacao/")
public class PublicacaoController {
   
	private PublicacaoService service;

	public PublicacaoController(PublicacaoService service) {
		super();
		this.service = service;
	}
	
	@PostMapping
	public ResponseEntity<PublicacaoDTO> savePublic(
			@RequestBody PublicacaoDTO publiDto){
		return service.savePublicao(publiDto);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<PublicacaoDTO> listId(@PathVariable Long id){
		return service.listIdPublicao(id);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<PublicacaoDTO> update(@PathVariable Long id){
		return service.delete(id);
	}
}
