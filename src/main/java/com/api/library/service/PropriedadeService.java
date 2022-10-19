package com.api.library.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

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
}
