package com.api.library.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.library.dto.LivrosDTO;
import com.api.library.exceptions.ReturnErroFindNotFound;
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
		} catch (Exception i) {
			throw new ReturnErroFindNotFound("Erro ao salvar o livro : ("+livroDto.getName()
			+") Por favor insira valores validos, ou tente mais tarde.");		
		}

	}

	private Livros bodySave(Livros livro) {
		return repository.save(livro);
	}

	public ResponseEntity<LivrosDTO> listId(Long id) {
		Optional<Livros> livroId = repository.findById(id);
		if (livroId.isPresent()) {
			return ResponseEntity.ok(mapper.map(livroId.get(), LivrosDTO.class));
		} else {
			  throw new ReturnErroFindNotFound("ID : "+id
					  +" Não encontrado por favor insira ou tente mais tarde");
		}
	}

	public ResponseEntity<LivrosDTO> updateLivro(LivrosDTO livroDto, Long id) {
		Optional<Livros> livrosId = repository.findById(id);
		if (livrosId.isPresent()) {
			Livros livroUpdate = livrosId.get();
			livroUpdate.setImage(livroDto.getImage());
			livroUpdate.setName(livroDto.getName());
			livroUpdate.setAuthor(livroDto.getAuthor());
			livroUpdate.setEdition(livroDto.getEdition());
			livroUpdate.setPublishingCompany(livroDto.getPublishingCompany());
			repository.save(livroUpdate);
			return ResponseEntity.ok(mapper.map(livroUpdate, LivrosDTO.class));
		} else {
			throw new ReturnErroFindNotFound("Erro ao atualizar o livro "+livroDto.getName()
			+", Por favor confira os valores inseridos.");
		}
	}
	
	public ResponseEntity<LivrosDTO> delete(Long id) {
		Livros livro = new Livros();
		Optional<Livros> findId = repository.findById(id);
		if(findId.isPresent()) {
			repository.delete(findId.get());
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			throw new ReturnErroFindNotFound("Erro ao deletar o livro "+livro.getName()
			+", Por favor confira os valores inseridos.");		
		}
	}

}
