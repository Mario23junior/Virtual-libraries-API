package com.api.library.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.library.dto.PublicacaoDTO;
import com.api.library.exceptions.ReturnErroFindNotFound;
import com.api.library.model.Publicacao;
import com.api.library.repository.PublicacaoRepository;

@Service
public class PublicacaoService {
  
	private PublicacaoRepository repository;
	private ModelMapper mapper;

	public PublicacaoService(PublicacaoRepository repository, ModelMapper mapper) {
		super();
		this.repository = repository;
		this.mapper = mapper;
	}
	
	public ResponseEntity<PublicacaoDTO> savePublicao(PublicacaoDTO publiDto) {
		try {
			Publicacao publicId = bodySave(mapper.map(publiDto, Publicacao.class));
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(mapper.map(publicId, PublicacaoDTO.class));
		} catch (Exception i) {
			throw new ReturnErroFindNotFound("Erro ao salvar publicações,"
					+ " Por favor insira valores validos, ou tente mais tarde.");		
		}

	}
	private Publicacao bodySave(Publicacao publicacao) {
		return repository.save(publicacao);
	}
	
	public ResponseEntity<PublicacaoDTO> listIdPublicao(Long id){
		Optional<Publicacao> proId = repository.findById(id);
		if (proId.isPresent()) {
			return ResponseEntity.ok(mapper.map(proId.get(), PublicacaoDTO.class));
		} else {
			  throw new ReturnErroFindNotFound("Publicação de ID : "+id
					  +" Não encontrada por favor insira valores corretamento ou tente mais tarde.");
		}
	}
	
	
	
}
