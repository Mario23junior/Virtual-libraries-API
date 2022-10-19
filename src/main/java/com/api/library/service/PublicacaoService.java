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
		ValidDataDuplicate(publiDto);
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
	
	
	public ResponseEntity<PublicacaoDTO> update(Long id,PublicacaoDTO publicDto) {
		ValidDataDuplicate(publicDto);
		Optional<Publicacao> publiId = repository.findById(id);
		if (publiId.isPresent()) {
			Publicacao publiUpdate = publiId.get();
			publiUpdate.setCoverType(publicDto.getCoverType());
			publiUpdate.setPublicationDate(publicDto.getPublicationDate());
			publiUpdate.setDimensoes(publicDto.getDimensoes());
			repository.save(publiUpdate);
			return ResponseEntity.ok(mapper.map(publiUpdate, PublicacaoDTO.class));
		} else {
			throw new ReturnErroFindNotFound("Erro ao atualizar dados de publicações, Por favor confira os valores inseridos.");
		}
	}
	
	public ResponseEntity<PublicacaoDTO> delete(Long id){
 	 		Optional<Publicacao> findId = repository.findById(id);
			if(findId.isPresent()) {
				repository.delete(findId.get());
				return new ResponseEntity<>(HttpStatus.OK);
			} else {
				throw new ReturnErroFindNotFound("ID: "+id
				+" Não encontrado, Por favor confira os valores inseridos.");		
			}
		}
	
	public void ValidDataDuplicate(PublicacaoDTO PublicacaoDto) {
		Publicacao proprie = mapper.map(PublicacaoDto, Publicacao.class);
		Publicacao findDate = repository.findByCoverType(PublicacaoDto.getCoverType());
		if(findDate != null && findDate.getId() != proprie.getId()) {
			throw new ReturnErroFindNotFound("Informação já existe na base de dados , Por favor tente um outro livro");		
		}
	}
	
}
