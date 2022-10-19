package com.api.library.service;

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
	
	public ResponseEntity<PropriedadesDTO> saveLivro(PropriedadesDTO proprieDto) {
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
}
