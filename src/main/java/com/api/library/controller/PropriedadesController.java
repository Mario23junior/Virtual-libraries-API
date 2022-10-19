package com.api.library.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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
		return service.saveLivro(proDto);
	}
}
