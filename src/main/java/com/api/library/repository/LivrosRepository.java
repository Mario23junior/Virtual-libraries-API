package com.api.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.library.model.Livros;

public interface LivrosRepository extends JpaRepository<Livros, Long> {

}
