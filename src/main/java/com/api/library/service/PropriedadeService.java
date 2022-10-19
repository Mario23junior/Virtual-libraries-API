package com.api.library.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.library.dto.PropriedadesDTO;
import com.api.library.exceptions.ReturnErroFindNotFound;
import com.api.library.model.Propriedades;
import com.api.library.repository.PropriedadesRepository;

@Service
public class PropriedadeService {
   
	private PropriedadesRepository repository;
	private ModelMapper mapper;

	public PropriedadeService(PropriedadesRepository repository, ModelMapper mapper) {
		super();
		this.repository = repository;
		this.mapper = mapper;
	}
	
	public ResponseEntity<PropriedadesDTO> savePropriedade(PropriedadesDTO proprieDto) {
		try {
			Propriedades proprie = bodySave(mapper.map(proprieDto, Propriedades.class));
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(mapper.map(proprie, PropriedadesDTO.class));
		} catch (Exception i) {
			throw new ReturnErroFindNotFound("Erro ao salvar informações,"
					+ " Por favor insira valores validos, ou tente mais tarde.");		
		}

	}

	private Propriedades bodySave(Propriedades Propriedades) {
		return repository.save(Propriedades);
	}
	
	public ResponseEntity<PropriedadesDTO> listid(Long id){
		Optional<Propriedades> proId = repository.findById(id);
		if (proId.isPresent()) {
			return ResponseEntity.ok(mapper.map(proId.get(), PropriedadesDTO.class));
		} else {
			  throw new ReturnErroFindNotFound("ID : "+id
					  +" Não encontrado por favor insira valores corretamento ou tente mais tarde.");
		}
	}
	
	
	public ResponseEntity<PropriedadesDTO> updatePropriedade(PropriedadesDTO propriedDto, Long id) {
		Optional<Propriedades> proprieId = repository.findById(id);
		if (proprieId.isPresent()) {
			Propriedades proprieUpdate = proprieId.get();
			proprieUpdate.setPage(propriedDto.getPage());
			proprieUpdate.setIsbn(propriedDto.getIsbn());
			proprieUpdate.setTheme(propriedDto.getTheme());
			repository.save(proprieUpdate);
			return ResponseEntity.ok(mapper.map(proprieUpdate, PropriedadesDTO.class));
		} else {
			throw new ReturnErroFindNotFound("Erro ao atualizar propriedades, Por favor confira os valores inseridos.");
		}
	}
	
	public ResponseEntity<PropriedadesDTO> delete(Long id) {
 		Optional<Propriedades> findId = repository.findById(id);
		if(findId.isPresent()) {
			repository.delete(findId.get());
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			throw new ReturnErroFindNotFound("ID: "+id
			+" Não encontrado, Por favor confira os valores inseridos.");		
		}
	}

 
	
}
 