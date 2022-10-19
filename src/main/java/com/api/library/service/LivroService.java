package com.api.library.service;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.library.dto.LivrosDTO;
import com.api.library.model.Livros;
import com.api.library.repository.LivrosRepository;

@Service
public class LivroService {

	private LivrosRepository repository;
	private ModelMapper mapper;

	public LivroService(LivrosRepository repository, ModelMapper mapper) {
		super();
		this.repository = repository;
		this.mapper = mapper;
	}

	public ResponseEntity<LivrosDTO> saveLivro(LivrosDTO livroDto) {
		try {
			Livros livroSave = bodySave(mapper.map(livroDto, Livros.class));
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(mapper.map(livroSave, LivrosDTO.class));
		}catch(Exception e) {
		    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
	}

	private Livros bodySave(Livros livro) {
		return repository.save(livro);
	}

}
