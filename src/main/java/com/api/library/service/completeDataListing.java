package com.api.library.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import com.api.library.dto.LivrosDTO;
import com.api.library.model.Livros;
import com.api.library.repository.LivrosRepository;

@Service
public class completeDataListing {
  
	private LivrosRepository repository;
	private ModelMapper mapper;
	
	public completeDataListing(LivrosRepository repository,
			ModelMapper mapper) {
 		this.repository = repository;
		this.mapper = mapper;
	}
	
	public List<LivrosDTO> listDataAll() {
		return ((List<Livros>) repository
				.findAll())
				.stream()
				.map(this::ConverterEntityToDto)
				.collect(Collectors.toList());
	}
	
	public LivrosDTO ConverterEntityToDto(Livros livros) {
		mapper.getConfiguration()
		.setMatchingStrategy(MatchingStrategies.LOOSE);
		
		LivrosDTO livroDto = mapper.map(livros, LivrosDTO.class);
		return livroDto;
	}
	
	public List<LivrosDTO> listAllDto() {
		List<LivrosDTO> list = listDataAll();
		list
		.stream()
		.collect(Collectors.toList());
		
		return list;
	}
	
}
