package com.api.library.service;

import java.util.Optional;

import com.api.library.dto.LivrosDTO;
import com.api.library.exceptions.ReturnErroFindNotFound;
import com.api.library.model.Livros;
import com.api.library.repository.LivrosRepository;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LivroService {

	private LivrosRepository repository;
	private ModelMapper mapper;

	public LivroService(LivrosRepository repository, ModelMapper mapper) {
		super();
		this.repository = repository;
		this.mapper = mapper;
	}

	public ResponseEntity<Livros> saveLivro(Livros Livro) {
		try {
			Livros livroSave = bodySave(mapper.map(Livro, Livros.class));
 			return ResponseEntity
					.status(HttpStatus.OK)
					.body(mapper.map(livroSave, Livros.class));
		} catch (Exception i) {
			throw new ReturnErroFindNotFound("Erro ao salvar o livro : ("+Livro.getName()
			+") Por favor insira valores validos, ou tente mais tarde.");		
		}

	}

	private Livros bodySave(Livros livro) {
		ValidDataDuplicate(mapper.map(livro, LivrosDTO.class));
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
	
	
	public Page<Livros> findPageAll(Integer pageNo, Integer pageSize){
	   PageRequest pageRequest = PageRequest.of(pageNo, pageSize);
	   return repository.findAll(pageRequest);
 	}
	

	public ResponseEntity<LivrosDTO> updateLivro(LivrosDTO livroDto, Long id) {
		Optional<Livros> livrosId = repository.findById(id);
		ValidDataDuplicate(livroDto);
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
	
	public void ValidDataDuplicate(LivrosDTO livrosDto) {
		Livros livrosCon = mapper.map(livrosDto, Livros.class);
		Livros findDate = repository.findByName(livrosDto.getName());
		if(findDate != null && findDate.getId() != livrosCon.getId()) {
			throw new ReturnErroFindNotFound("O livro "+livrosDto.getName()
			+" já existe na base de dados , Por favor tente um outro livro");		
		}
	}

}
