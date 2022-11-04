package com.api.library.repository;

import java.util.List;

import com.api.library.model.Livros;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface LivrosRepository extends PagingAndSortingRepository<Livros, Long> {
  
	Livros findByName(String name);
  	
 }
 