package com.api.library.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.library.dto.PropriedadesDTO;
import com.api.library.service.PropriedadeService;

@RestController
@RequestMapping("/v1/api/propriedades/")
public class PropriedadesController {

	private PropriedadeService service;

	public PropriedadesController(PropriedadeService service) {
		super();
		this.service = service;
	}

	@PostMapping
	public ResponseEntity<PropriedadesDTO> save(@RequestBody PropriedadesDTO proDto) {
		return service.savePropriedade(proDto);
	}

	@GetMapping("{id}")
	public ResponseEntity<PropriedadesDTO> FindlistId(@PathVariable Long id) {
		return service.listid(id);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<PropriedadesDTO> update(
			@PathVariable Long id,
			@RequestBody PropriedadesDTO propriedadesDto) {
		return service.updatePropriedade(propriedadesDto, id);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<PropriedadesDTO> delete(@PathVariable Long id) {
		return service.delete(id);
	}
}
